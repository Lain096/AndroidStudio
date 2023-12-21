package dl.pmdm.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class MainActivity extends AppCompatActivity implements FragmentInfo.interfaceFragmento {

    static Context contexto;
    Intent intent;
    String peliculaFragment = null;
    Bundle bundle;
    Fragment fragment;
    TextView txtTituloPeli1, txtTituloPeli2, txtTituloPeli3, txtTituloPeli4;
    TextView txtSinopsisPeli1, txtSinopsisPeli2, txtSinopsisPeli3, txtSinopsisPeli4;
    TextView txtratingPeli1, txtratingPeli2, txtratingPeli3, txtratingPeli4;

    RatingBar ratingPeli1, ratingPeli2, ratingPeli3, ratingPeli4;

    View existe;

    Boolean isTablet = false;
    ImageView imgPeli1, imgPeli2, imgPeli3, imgPeli4;
    Pelicula peli1, peli2, peli3, peli4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isTablet = isTablet(this);

        existe =  findViewById(R.id.fragmentContainerView);
        if(existe != null ){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }



        intent = new Intent(this, ActivityFragment.class);

        contexto = this;

        bundle = new Bundle();
        peliculasBuilder.crearPeliculas();


        peli1 = peliculasBuilder.getPeliculas().getPelicula1();
        peli2 = peliculasBuilder.getPeliculas().getPelicula2();
        peli3 = peliculasBuilder.getPeliculas().getPelicula3();
        peli4 = peliculasBuilder.getPeliculas().getPelicula4();

        txtTituloPeli1 = (TextView) findViewById(R.id.txtTituloPeli1);
        txtTituloPeli2 = (TextView) findViewById(R.id.txtTituloPeli2);
        txtTituloPeli3 = (TextView) findViewById(R.id.txtTituloPeli3);
        txtTituloPeli4 = (TextView) findViewById(R.id.txtTituloPeli4);

        txtSinopsisPeli1 = (TextView) findViewById(R.id.idSinopsisPeli1);
        txtSinopsisPeli2 = (TextView) findViewById(R.id.idSinopsisPeli2);
        txtSinopsisPeli3 = (TextView) findViewById(R.id.idSinopsisPeli3);
        txtSinopsisPeli4 = (TextView) findViewById(R.id.idSinopsisPeli4);

        imgPeli1 = (ImageView) findViewById(R.id.imgPeli1);
        imgPeli2 = (ImageView) findViewById(R.id.imgPeli2);
        imgPeli3 = (ImageView) findViewById(R.id.imgPeli3);
        imgPeli4 = (ImageView) findViewById(R.id.imgPeli4);

        ratingPeli1 = (RatingBar) findViewById(R.id.ratingPeli1);
        ratingPeli2 = (RatingBar) findViewById(R.id.ratingPeli2);
        ratingPeli3 = (RatingBar) findViewById(R.id.ratingPeli3);
        ratingPeli4 = (RatingBar) findViewById(R.id.ratingPeli4);

        txtratingPeli1 = (TextView) findViewById(R.id.txtRatingPeli1);
        txtratingPeli2 = (TextView) findViewById(R.id.txtRatingPeli2);
        txtratingPeli3 = (TextView) findViewById(R.id.txtRatingPeli3);
        txtratingPeli4 = (TextView) findViewById(R.id.txtRatingPeli4);


        cargarPeliculas();



        listenerImagenes(imgPeli1);
        listenerImagenes(imgPeli2);
        listenerImagenes(imgPeli3);
        listenerImagenes(imgPeli4);


    }
    public static boolean isTablet(Context mContext){
        return (mContext.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    private void cargarPeliculas() {


        ratingPeli1.setRating(peli1.getRating());
        ratingPeli2.setRating(peli2.getRating());
        ratingPeli3.setRating(peli3.getRating());
        ratingPeli4.setRating(peli4.getRating());

        txtratingPeli1.setText(peli1.getRating() + "/5.0");
        txtratingPeli2.setText(peli2.getRating() + "/5.0");
        txtratingPeli3.setText(peli3.getRating() + "/5.0");
        txtratingPeli4.setText(peli4.getRating() + "/5.0");


        txtTituloPeli1.setText(peli1.getTitulo());
        txtTituloPeli2.setText(peli2.getTitulo());
        txtTituloPeli3.setText(peli3.getTitulo());
        txtTituloPeli4.setText(peli4.getTitulo());

        txtSinopsisPeli1.setText(peli1.getSinopsis());
        txtSinopsisPeli2.setText(peli2.getSinopsis());
        txtSinopsisPeli3.setText(peli3.getSinopsis());
        txtSinopsisPeli4.setText(peli4.getSinopsis());

        imgPeli1.setImageResource(peli1.getImagen());
        imgPeli2.setImageResource(peli2.getImagen());
        imgPeli3.setImageResource(peli3.getImagen());
        imgPeli4.setImageResource(peli4.getImagen());
    }

    private void listenerImagenes(ImageView imagen) {

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (v.getId() == R.id.imgPeli1) {
                    intent.putExtra("bojack", (String) null);

                    peliculaFragment = "bojack";

                }
                if (v.getId() == R.id.imgPeli2) {
                    intent.putExtra("brian", (String) null);

                    peliculaFragment = "brian";

                }
                if (v.getId() == R.id.imgPeli3) {
                    intent.putExtra("dragon", (String) null);

                    peliculaFragment = "dragon";

                }
                if (v.getId() == R.id.imgPeli4) {
                     intent.putExtra("aterriza", (String) null);

                    peliculaFragment = "aterriza";

                }

                if(isTablet){

                    fragment = FragmentInfo.newInstance(peliculaFragment);
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.replace(R.id.fragmentContainerView, fragment);
                    ft.commit();

                } else{
                    startActivity(intent);
                }

            }
        });

    }


    // definir la interfaz del fragmento, que tiene que recoger de él
    @Override
    public void peliculaModificada(Pelicula pelicula) {
        Log.d("debug", "onRatingChanged: " + pelicula.getRating());
        if (pelicula != null) {

            if (pelicula.getTitulo().equals(peli1.getTitulo())) {
                peli1 = pelicula;
            }
            if (pelicula.getTitulo().equals(peli2.getTitulo())) {
                peli2 = pelicula;
            }
            if (pelicula.getTitulo().equals(peli3.getTitulo())) {
                peli3 = pelicula;
            }
            if (pelicula.getTitulo().equals(peli4.getTitulo())) {
                peli4 = pelicula;
            }

            cargarPeliculas();
        }
    }
}