package dl.pmdm.fragmentdinamico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentInfo.interfaceFragmento{
//
    static Context contexto;
    private RecyclerView recycler;
    private CheckBox checkBox;
    private View fragmentTablet;
    private Boolean isTablet = false;
    private Toolbar toolbar;
    private SharedPreferences prefs;
    private View contenedor;

   // private ImageView imgGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // isTablet = layoutTablet(this);
        checkBox = (CheckBox)findViewById(R.id.chkVistas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        contenedor = findViewById(R.id.contenedor);
      //  imgGuardar = findViewById(R.id.iconGuardar);

        setSupportActionBar(toolbar);

        prefs = getSharedPreferences("file_fondo", Context.MODE_PRIVATE);
        cambiarColorFondo();



        //region $checkTablet
        fragmentTablet =  findViewById(R.id.fragmentContainerViewTablet);
        if(fragmentTablet != null ){

            isTablet = true;
        }
//endregion

        //region $recycler
        recycler = findViewById(R.id.recycler);

        contexto = this;

        List<Pelicula> listaPelis = PeliculasBuilder.getListaPelisDB(this);
//endregion



        //region $listeners
        Switch sw = findViewById(R.id.swMostrar);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                List<Pelicula> listPelis;

                if(sw.isChecked()){

                    listPelis = filtrarPeliculasConRating();

                } else{
                    listPelis = PeliculasBuilder.getListaPelisDB(contexto);
                }

                recycler.setAdapter(new PeliculaAdapter(listPelis, getSupportFragmentManager(), isTablet));
                recycler.setLayoutManager(new LinearLayoutManager(contexto));
                recycler.setHasFixedSize(true);



            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                List<Pelicula>listPelis;

                if(checkBox.isChecked()){
                    listPelis = filtrarPeliculasVistas();
                } else{
                    listPelis = PeliculasBuilder.getListaPelisDB(contexto);
                }

                recycler.setAdapter(new PeliculaAdapter(listPelis, getSupportFragmentManager(), isTablet));
                recycler.setLayoutManager(new LinearLayoutManager(contexto));
                recycler.setHasFixedSize(true);
            }
        });

//        imgGuardar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(contexto, CrearPelicula.class);
//                startActivity(i);
//            }
//        });

        //endregion

        //region $cargar adapter principal

       //recycler.setAdapter(new PeliculaAdapter(PeliculasBuilder.getListaPelis(), getSupportFragmentManager(), isTablet));
        recycler.setAdapter(new PeliculaAdapter(listaPelis, getSupportFragmentManager(), isTablet));
        recycler.setLayoutManager(new LinearLayoutManager(contexto));
        recycler.setHasFixedSize(true);

        //endregion


    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();

        if(opcion == R.id.iconGuardar){
            Intent i = new Intent(contexto, CrearPelicula.class);
                        startActivity(i);
        }

        if (opcion == R.id.colorMain) {
            cambiarColor(R.color.blueblack);

        }
        if (opcion == R.id.colorMarron) {
            cambiarColor(R.color.brown);

        }
        if (opcion == R.id.colorNegro) {
        cambiarColor(R.color.blue);
        }

        return super.onOptionsItemSelected(item);
    }

    public void cambiarColor(int color){
        SharedPreferences.Editor editor = prefs.edit();
        contenedor.setBackgroundColor(ContextCompat.getColor(this, color));

        editor.putInt("color", color);
        editor.apply();
    }

    //region $metodos

    private List<Pelicula> filtrarPeliculasConRating(){
        List<Pelicula> pelisSinPuntuar = new ArrayList<>();

        for(Pelicula p : PeliculasBuilder.getListaPelisDB(this)){
            if (p.getRating() != null){
                pelisSinPuntuar.add(p);

            }
        }

        return pelisSinPuntuar;
    }

    private List<Pelicula> filtrarPeliculasVistas(){
        List<Pelicula> pelisVistas = new ArrayList<>();

        for(Pelicula p : PeliculasBuilder.getListaPelisDB(this)){
            if (p.getEsVista()){
                pelisVistas.add(p);

            }
        }

        return pelisVistas;
    }

    public void cambiarColorFondo(){
        int color = prefs.getInt("color", R.color.blueblack);
        contenedor.setBackgroundColor(ContextCompat.getColor(this, color));
    }



    @Override
    public void peliculaModificada() {

        recycler.getAdapter().notifyDataSetChanged();
        recycler.setAdapter(new PeliculaAdapter(PeliculasBuilder.getListaPelisDB(this), getSupportFragmentManager(), isTablet));
        recycler.setLayoutManager(new LinearLayoutManager(contexto));

    }

    @Override
    public void cerrarFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }

    //endregion
}