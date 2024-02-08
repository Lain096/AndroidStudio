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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentVideojuegoModificar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVideojuegoModificar extends Fragment {

    private Videojuego videojuego;
   private EditText titulo, numJugadores, descripcion;
   private String textoTipo;
   private Button btnModificar;
   private int posicion;

    private Spinner tipo;

    InterfazModificarVideojuego interfazModificarVideojuego;

    public interface InterfazModificarVideojuego{

        void modificarVideojuego(Videojuego videojuego, String previousTitle, Fragment fragment, int posicion);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        interfazModificarVideojuego = (InterfazModificarVideojuego) context;
    }

    public static FragmentVideojuegoModificar newInstance(String param1, String param2) {
        FragmentVideojuegoModificar fragment = new FragmentVideojuegoModificar();
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
        View v = inflater.inflate(R.layout.fragment_videojuego_modificar, container, false);

        if (getArguments() != null) {

             videojuego = (Videojuego) getArguments().getSerializable("videojuego");
             posicion = getArguments().getInt("posicion");

        }

        titulo = v.findViewById(R.id.nuevoTitulo);
        numJugadores = v.findViewById(R.id.nuevoNumJugadores);
        descripcion = v.findViewById(R.id.nuevoDescripcion);
        tipo = v.findViewById(R.id.spinnerNuevoEstilo);
        btnModificar = v.findViewById(R.id.btnModificar);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.tipoJuegos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tipo.setAdapter(adapter);

        tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textoTipo = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!titulo.getText().toString().isEmpty() &&
                        !numJugadores.getText().toString().isEmpty() &&
                        !descripcion.getText().toString().isEmpty()) {
                    String previousTitle = videojuego.getName();

                    videojuego.setName(titulo.getText().toString());
                    videojuego.setNumJugadores(Integer.parseInt(numJugadores.getText().toString()));
                    videojuego.setDescription(descripcion.getText().toString());
                    videojuego.setTipo(textoTipo);

                    interfazModificarVideojuego.modificarVideojuego(videojuego, previousTitle, FragmentVideojuegoModificar.this, posicion);
                }

            }
        });






        return v;
    }
}