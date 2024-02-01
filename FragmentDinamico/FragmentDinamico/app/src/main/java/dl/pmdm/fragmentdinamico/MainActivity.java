package dl.pmdm.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentInfo.interfaceFragmento{
//
    static Context contexto;
    private RecyclerView recycler;
    View fragmentTablet;
    Boolean activado = false;

    Boolean isTablet = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // isTablet = layoutTablet(this);


        fragmentTablet =  findViewById(R.id.fragmentContainerViewTablet);
        if(fragmentTablet != null ){
            // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            isTablet = true;
        }

        recycler = findViewById(R.id.recycler);

        contexto = this;

        PeliculasBuilder.crearPeliculas();

        Switch sw = findViewById(R.id.swMostrar);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sw.isChecked()){

                    List<Pelicula> pelisSinPuntuar = new ArrayList<>();

                    for(Pelicula p : PeliculasBuilder.getListaPelis()){

                        if (p.getRating() != null){
                            pelisSinPuntuar.add(p);

                        }
                    }
                    recycler.setAdapter(new PeliculaAdapter(pelisSinPuntuar, getSupportFragmentManager(), isTablet));
                    recycler.setLayoutManager(new LinearLayoutManager(contexto));
                    recycler.setHasFixedSize(true);

                } else{
                    recycler.setAdapter(new PeliculaAdapter(PeliculasBuilder.getListaPelis(), getSupportFragmentManager(), isTablet));
                    recycler.setLayoutManager(new LinearLayoutManager(contexto));
                    recycler.setHasFixedSize(true);
                }

                recycler.getAdapter().notifyDataSetChanged();
            }
        });

        recycler.setAdapter(new PeliculaAdapter(PeliculasBuilder.getListaPelis(), getSupportFragmentManager(), isTablet));
        recycler.setLayoutManager(new LinearLayoutManager(contexto));
        recycler.setHasFixedSize(true);






    }
//    public static boolean layoutTablet(Context mContext){
//        return (mContext.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
//    }



    @Override
    public void peliculaModificada(Integer posicion) {

      //  recycler.getAdapter().notifyItemChanged(posicion);
        recycler.getAdapter().notifyDataSetChanged();



    }


}