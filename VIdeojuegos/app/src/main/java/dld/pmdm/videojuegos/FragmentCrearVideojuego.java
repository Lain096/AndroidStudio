package dld.pmdm.videojuegos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCrearVideojuego#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCrearVideojuego extends Fragment {


    private EditText titulo, numJugadores, ano, descripcion;
    private Spinner spinner;
    private String estiloEscogido;
    private Button btnCrear;


    InterfaceCrearVideojuego interfazCrearVideojuego;

    public interface InterfaceCrearVideojuego{

        void crearVideojuego(Videojuego videojuego, Fragment fragment);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        interfazCrearVideojuego = (InterfaceCrearVideojuego) context;
    }

    public static FragmentCrearVideojuego newInstance(String param1, String param2) {
        FragmentCrearVideojuego fragment = new FragmentCrearVideojuego();
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

        View v = inflater.inflate(R.layout.fragment_crear_videojuego, container, false);

        titulo = v.findViewById(R.id.escribirTitulo);
        numJugadores = v.findViewById(R.id.escribirNumeroJugadores);
        ano = v.findViewById(R.id.escribirAnoLanzamiento);
        descripcion = v.findViewById(R.id.escribirDescripcion);
        btnCrear = v.findViewById(R.id.btnCrearPelicula);

        spinner = v.findViewById(R.id.spinnerTipoJuego );


       ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(getContext(), R.array.tipoJuegos, android.R.layout.simple_spinner_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               estiloEscogido = parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

       btnCrear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(!titulo.getText().toString().isEmpty() &&
                       !numJugadores.getText().toString().isEmpty() &&
                       !ano.getText().toString().isEmpty() &&
                       !descripcion.getText().toString().isEmpty()){

                   VideojuegosDAO dao = new VideojuegosDAO();

                   Videojuego game = new Videojuego();

                    game.setName(titulo.getText().toString());
                    game.setAno(Integer.valueOf(ano.getText().toString()));
                    game.setDescription(descripcion.getText().toString());
                    game.setNumJugadores(Integer.valueOf(numJugadores.getText().toString()));
                    game.setTipo(estiloEscogido);

                    interfazCrearVideojuego.crearVideojuego(game, FragmentCrearVideojuego.this);
                   //Toast.makeText(null, "Juego Creado Correctamente", Toast.LENGTH_SHORT).show();




               }

           }
       });



        return v;
    }


}