package dl.pmdm.fragmentdinamico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

    private TextView tituloPeli, txtRatingPeli, directoresPeli, actoresPeli, sinopsisPeli;
    private ImageView imgPeli;

    private RatingBar rating;


    public FragmentInfo() {
        // Required empty public constructor
    }


    // definir la interfaz en la interfaz
    public interface interfaceFragmento{

         void peliculaModificada();
    }

    interfaceFragmento interfFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        interfFragment = (interfaceFragmento) MainActivity.contexto;

    }


//, Integer pos
    public static FragmentInfo newInstance(Pelicula param1) {
        FragmentInfo fragment = new FragmentInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        // posicion = pos;
       // pelicula = PeliculasBuilder.getListaPelisDB().stream().filter(x -> x.getCodigo().equals(param1.getCodigo())).findFirst().get();
        //pelicula = PeliculasBuilder.getListaPelis().stream().filter(x -> x.getCodigo().equals(param1)).findFirst().get();


        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if(getArguments() != null){

            pelicula = (Pelicula) getArguments().getSerializable("peli");

        }



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

                modificarPelicula(pelicula, rating);

                //pelicula.setRating(rating);
                txtRatingPeli.setText(rating + "/5.0");
                interfFragment.peliculaModificada();

            }
        });


        return vista;
    }

    public void crearPantalla(Pelicula peli){

        tituloPeli.setText(peli.getTitulo());
        directoresPeli.setText(peli.getDirectores().toString());
        actoresPeli.setText(peli.getActores().toString());
        sinopsisPeli.setText(peli.getSinopsis());
        imgPeli.setImageResource(peli.getImagen());
        imgPeli.setBackgroundResource(getResources().getIdentifier(peli.getCodigo(), "drawable", getContext().getPackageName()));

        if (peli.getRating() == null){
            rating.setRating(0f);
        } else{
            rating.setRating(peli.getRating());
        }




    }

    private void modificarPelicula(Pelicula peli, float valor){

       PeliculasHelper ph = new PeliculasHelper(MainActivity.contexto);

       SQLiteDatabase sb = ph.getWritableDatabase();

       sb.execSQL("UPDATE PELICULAS " +
               "SET ratingScore = " + valor +
                ", watched = 1 " +
               "WHERE code LIKE '" + peli.getCodigo() + "'");


    }




}