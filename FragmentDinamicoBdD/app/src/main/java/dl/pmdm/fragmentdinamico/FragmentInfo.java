package dl.pmdm.fragmentdinamico;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class FragmentInfo extends Fragment {

    private SharedPreferences prefs;
    private LinearLayout contenedorFragment;
    private static Pelicula pelicula;
    private List<Pelicula> listaPelis;
    private static Integer posicion;
    private CheckBox isVista;
    private TextView tituloPeli, txtRatingPeli, directoresPeli, actoresPeli, sinopsisPeli;
    private ImageView imgPeli, borrarPelicula;


    private RatingBar rating;


    public FragmentInfo() {
        // Required empty public constructor
    }


    // definir la interfaz en la interfaz
    public interface interfaceFragmento {

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



        if (getArguments() != null) {

            pelicula = (Pelicula) getArguments().getSerializable("peli");

        }


        View vista = inflater.inflate(R.layout.fragment_info, container, false);

        prefs = getActivity().getSharedPreferences("file_fondo", Context.MODE_PRIVATE);
        int color = prefs.getInt("color", R.color.blueblack);

        vista.setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), color));

        borrarPelicula = (ImageView) vista.findViewById(R.id.borrarPelicula);
        isVista = (CheckBox) vista.findViewById(R.id.checkVista);
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

                PeliculasBuilder.modificarRatingPelicula(pelicula, rating);

                txtRatingPeli.setText(rating + "/5.0");
                interfFragment.peliculaModificada();

            }
        });

        isVista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isVista.isChecked()) {
                    PeliculasBuilder.modificarVistaPelicula(pelicula, true);
                    interfFragment.peliculaModificada();
                } else {
                    PeliculasBuilder.modificarVistaPelicula(pelicula, false);
                    interfFragment.peliculaModificada();
                }

            }

        });

        borrarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PeliculasBuilder.eliminarPelicula(pelicula);
                getActivity().finish();
                Toast.makeText(getContext(), "Pelicula eliminada:" + pelicula.getTitulo(), Toast.LENGTH_SHORT).show();
                interfFragment.peliculaModificada();
            }
        });


        return vista;
    }

    public void crearPantalla(Pelicula peli) {

        tituloPeli.setText(peli.getTitulo());
        directoresPeli.setText(peli.getDirectores().toString());
        actoresPeli.setText(peli.getActores().toString());
        sinopsisPeli.setText(peli.getSinopsis());
        imgPeli.setImageResource(peli.getImagen());
        imgPeli.setBackgroundResource(getResources().getIdentifier(peli.getCodigo(), "drawable", getContext().getPackageName()));

        if (peli.getRating() == null) {
            rating.setRating(0f);
        } else {
            rating.setRating(peli.getRating());
        }

        if(peli.getEsVista()){
            isVista.setChecked(true);
        }

    }

//    private void modificarRatingPelicula(Pelicula peli, float valor) {
//
//        PeliculasHelper ph = new PeliculasHelper(MainActivity.contexto);
//
//        SQLiteDatabase sb = ph.getWritableDatabase();
//
//        sb.execSQL("UPDATE PELICULAS " +
//                "SET ratingScore = " + valor +
//                " WHERE code LIKE '" + peli.getCodigo() + "'");
//
//
//    }


//    private void modificarVistaPelicula(Pelicula peli, boolean vista) {
//
//        PeliculasHelper ph = new PeliculasHelper(MainActivity.contexto);
//
//        SQLiteDatabase sb = ph.getWritableDatabase();
//
//        int valor = 0;
//
//        if (vista) {
//            valor = 1;
//        }
//
//        sb.execSQL("UPDATE PELICULAS " +
//                "SET watched = " + valor +
//                " WHERE code LIKE '" + peli.getCodigo() + "'");
//
//
//    }

    public void cambiarColorFondo(){
        int color = prefs.getInt("color", R.color.blueblack);
        contenedorFragment.setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), color));

    }
}