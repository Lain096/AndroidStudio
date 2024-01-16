package dl.pmdm.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentInfo.interfaceFragmento{

    static Context contexto;
    private RecyclerView recycler;
    private Intent intent;
    private String peliculaFragment = null;
    private  Bundle bundle;
    private Fragment fragment;
    private TextView txtTituloPeli;
    private TextView txtSinopsisPeli;
    private TextView txtratingPeli;

    private RatingBar ratingPeli;

    View existe;

    Boolean isTablet = false;
    ImageView imgPeli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isTablet = isTablet(this);

//        existe =  findViewById(R.id.fragmentContainerView);
//        if(existe != null ){
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
//

        recycler = findViewById(R.id.recycler);

        intent = new Intent(this, ActivityFragment.class);

        contexto = this;

        bundle = new Bundle();

        PeliculasBuilder.crearPeliculas();
        recycler.setAdapter(new PeliculaAdapter(PeliculasBuilder.getListaPelis()));
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);



    }
    public static boolean isTablet(Context mContext){
        return (mContext.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }



    @Override
    public void peliculaModificada(Integer posicion) {

        recycler.getAdapter().notifyItemChanged(posicion);



    }

//    private void listenerImagenes(ImageView imagen) {
//
//        imagen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String asd = "pelicula";
//
//
//
//                startActivity(intent);
//
//
//
////                if(isTablet){
////
////                    fragment = FragmentInfo.newInstance(peliculaFragment);
////                    FragmentManager fm = getSupportFragmentManager();
////                    FragmentTransaction ft = fm.beginTransaction();
////
////                    ft.replace(R.id.fragmentContainerView, fragment);
////                    ft.commit();
////
////                } else{
//
//               // }
//
//            }
//        });
//
//    }

}