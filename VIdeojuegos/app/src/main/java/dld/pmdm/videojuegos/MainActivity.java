package dld.pmdm.videojuegos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentCrearVideojuego.InterfaceCrearVideojuego, FragmentVideojuegoModificar.InterfazModificarVideojuego, DatosVideojuego.InterfazDatosVideojuego {



    private ConstraintLayout contenedor;
    private Toolbar toolbar;
    private RecyclerView recycler;
    List<Videojuego> listaVideojuegos;
    private  VideojuegosDAO dao;
    private Button btnCrear;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        contenedor = findViewById(R.id.constraintContenedor);

        btnCrear = findViewById(R.id.btnCrear);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         dao = new VideojuegosDAO();

        listaVideojuegos = dao.getVideojuegos(this);

        // Log.d("videojuegos", String.valueOf(listaVideojuegos.size()));

        recycler.setAdapter(new VideojuegosAdapter(this, listaVideojuegos));
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);


        prefs = getSharedPreferences("file_fondo", MODE_PRIVATE);

        Boolean asd = prefs.getBoolean("estado", false);
        comprobarPrefs(asd);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentCrearVideojuego.class, null)
                        .commit();
            }
        });

    }


    @Override
    public void crearVideojuego(Videojuego videojuego, Fragment fragment) {

        dao = new VideojuegosDAO();

        dao.insertVideojuego(this, videojuego);


        listaVideojuegos = dao.getVideojuegos(this);
        recycler.setAdapter(new VideojuegosAdapter(this, listaVideojuegos));
        Toast.makeText(this, "Juego Creado Correctamente", Toast.LENGTH_SHORT).show();


        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

    }


    @Override
    public void modificarVideojuego(Videojuego videojuego, String previousTitle, Fragment fragment, int posicion) {

            dao = new VideojuegosDAO();

            dao.modificarVideojuego(this, videojuego, previousTitle);

            listaVideojuegos = dao.getVideojuegos(this);
            recycler.setAdapter(new VideojuegosAdapter(this, listaVideojuegos));
            Toast.makeText(this, "Se ha modificado el juego " + previousTitle, Toast.LENGTH_SHORT).show();

            getSupportFragmentManager().beginTransaction().remove(fragment).commit();

            recycler.getAdapter().notifyItemChanged(posicion);
    }

    @Override
    public void eliminarJuego(Videojuego juego, Fragment fragment, int posicion) {

        dao = new VideojuegosDAO();
        dao.eliminarVideojuego(this, juego.getName());

        listaVideojuegos = dao.getVideojuegos(this);
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();

        recycler.setAdapter(new VideojuegosAdapter(this, listaVideojuegos));
        // recycler.getAdapter().notifyItemRemoved(posicion);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater men = getMenuInflater();

        men.inflate(R.menu.items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        boolean res = false;

        if(item.getItemId() == R.id.colorMain){
            if(res){
                res = false;
            } else{
                res = true;
            }
        }
        SharedPreferences.Editor edit = prefs.edit();
        if(res){
            edit.putBoolean("estado", true);
            prefs.edit().putInt("color", R.color.white);
        } else{
            edit.putBoolean("estado", true);
            edit.putInt("color", R.color.redish);
        }
        comprobarPrefs(res);

        return super.onOptionsItemSelected(item);
    }

    public void comprobarPrefs(Boolean res){

        int color;
        if(res){
            color = prefs.getInt("color", R.color.white);
            contenedor.setBackgroundColor(ContextCompat.getColor(this, color));
        }else{
            color = prefs.getInt("color", R.color.redish);
            contenedor.setBackgroundColor(ContextCompat.getColor(this, color));
        }

    }
}