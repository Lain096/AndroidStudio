package dld.pmdm.videojuegos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DatosVideojuego#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatosVideojuego extends Fragment {



    private TextView titulo, numJugadores, tipo, descripcion, ano;
    private ImageView imgBorrar, imgModificar;
    private int posicion;
    private Videojuego videojuego;

    public DatosVideojuego() {
        // Required empty public constructor
    }

    InterfazDatosVideojuego interfazDatosVideojuego;
    public interface InterfazDatosVideojuego{
        void eliminarJuego(Videojuego juego, Fragment fragment, int posicion);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        interfazDatosVideojuego = (InterfazDatosVideojuego) context;

    }

    public static DatosVideojuego newInstance(String param1, String param2) {
        DatosVideojuego fragment = new DatosVideojuego();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v  = inflater.inflate(R.layout.fragment_datos_videojuego, container, false);

        titulo = v.findViewById(R.id.titulo);
        numJugadores = v.findViewById(R.id.numeroJugadores);
        tipo = v.findViewById(R.id.estilo);
        descripcion = v.findViewById(R.id.descripcion);
        ano = v.findViewById(R.id.ano);
        imgBorrar = v.findViewById(R.id.borrarVideojuego);
        imgModificar = v.findViewById(R.id.editarVideojuego);


        if(getArguments() != null){

            videojuego = (Videojuego) getArguments().getSerializable("videojuego");

            posicion =  getArguments().getInt("posicion");

        }


        titulo.setText(videojuego.getName());
        numJugadores.setText(String.valueOf(videojuego.getNumJugadores()));
        tipo.setText(videojuego.getTipo());
        Log.d("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", videojuego.getDescription());
        descripcion.setText(videojuego.getDescription());
        ano.setText(String.valueOf(videojuego.getAno()));

        imgModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                androidx.fragment.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putSerializable("videojuego", videojuego);
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentVideojuegoModificar.class, bundle)
                        .commit();

            }
        });

        imgBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            interfazDatosVideojuego.eliminarJuego(videojuego, DatosVideojuego.this, posicion);

            }
        });




        return v;
    }
}