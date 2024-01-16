package dl.pmdm.fragmentdinamico;

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

import java.util.List;


public class FragmentInfo extends Fragment {


    private static Pelicula pelicula;
    private List<Pelicula> listaPelis;
    private static Integer posicion;

    private static TextView tituloPeli, txtRatingPeli, directoresPeli, actoresPeli, sinopsisPeli;
    private static ImageView imgPeli;

    private static RatingBar rating;


    public FragmentInfo() {
        // Required empty public constructor
    }


    // definir la interfaz en la interfaz
    public interface interfaceFragmento{
         void peliculaModificada(Integer posicion);
    }

    interfaceFragmento interfFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        interfFragment = (interfaceFragmento) MainActivity.contexto;

    }



    public static FragmentInfo newInstance(String param1, Integer pos) {
        FragmentInfo fragment = new FragmentInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        System.out.println(param1);

        posicion = pos;
        pelicula = PeliculasBuilder.getListaPelis().stream().filter(x -> x.getCodigo().equals(param1)).findFirst().get();

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
                interfFragment.peliculaModificada(posicion);

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
        rating.setRating(peli.getRating());



    }




}