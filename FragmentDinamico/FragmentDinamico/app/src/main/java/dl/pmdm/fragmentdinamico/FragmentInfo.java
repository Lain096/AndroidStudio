package dl.pmdm.fragmentdinamico;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class FragmentInfo extends Fragment {

    private static Pelicula pelicula;

    private static TextView tituloPeli, txtRatingPeli, directoresPeli, actoresPeli, sinopsisPeli;
    private static ImageView imgPeli;

    private RatingBar rating;


    public FragmentInfo() {
        // Required empty public constructor
    }


    // definir la interfaz en la interfaz
    public interface interfaceFragmento{
         void peliculaModificada(Pelicula pelicula);
    }

    interfaceFragmento interfFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        interfFragment = (interfaceFragmento) MainActivity.contexto;

    }



    public static FragmentInfo newInstance(String param1) {
        FragmentInfo fragment = new FragmentInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);


        if(param1.equals("bojack")){
            pelicula = peliculasBuilder.getPeliculas().getPelicula1();

        }
        if(param1.equals("brian")){
            pelicula = peliculasBuilder.getPeliculas().getPelicula2();
        }
        if(param1.equals("dragon")){
            pelicula = peliculasBuilder.getPeliculas().getPelicula3();
        }
        if(param1.equals("aterriza")){
            pelicula = peliculasBuilder.getPeliculas().getPelicula4();
        }


        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_info, container, false);

        rating = (RatingBar) vista.findViewById(R.id.ratingPelicula);
        tituloPeli = (TextView) vista.findViewById(R.id.tituloPelicual);
        txtRatingPeli = (TextView) vista.findViewById(R.id.txtRatingPelicula);
        directoresPeli = (TextView) vista.findViewById(R.id.txtDirectoresPelicula);
        actoresPeli = (TextView) vista.findViewById(R.id.txtActoresPelicula);
        sinopsisPeli = (TextView) vista.findViewById(R.id.txtSinopsisPelicula);

        imgPeli = (ImageView) vista.findViewById(R.id.imagePelicula);



        crearPantalla(pelicula);


        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                pelicula.setRating(rating);
                txtRatingPeli.setText(rating + "/5.0");
                interfFragment.peliculaModificada(pelicula);

            }
        });


        return vista;
    }

    public static void crearPantalla(Pelicula peli){

        tituloPeli.setText(peli.getTitulo());
        directoresPeli.setText(peli.getDirectores().toString());
        actoresPeli.setText(peli.getActores().toString());
        sinopsisPeli.setText(peli.getSinopsis());
        imgPeli.setImageResource(peli.getImagen());


    }




}