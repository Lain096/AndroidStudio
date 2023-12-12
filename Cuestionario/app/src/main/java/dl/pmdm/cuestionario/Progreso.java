package dl.pmdm.cuestionario;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Progreso extends Fragment {


    private ProgressBar barraProgreso;
    private TextView titlePuntuacion, txtProgreso;
    boolean sobre100;

    private String valor;

    public Progreso() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View interfaz = inflater.inflate(R.layout.fragment_progreso, container, false);
        barraProgreso = (ProgressBar) interfaz.findViewById(R.id.progressBar);
        titlePuntuacion = (TextView) interfaz.findViewById(R.id.idPuntos);
        txtProgreso = (TextView) interfaz.findViewById(R.id.txtProgressBar);

        if(getArguments() != null) {
            valor = String.valueOf(getArguments().getInt("nivelProgreso"));
        }else {
            System.out.println("No hay valor");
        }

        sobre100 = ControlPuntos.getControl().getPuntuacion();

        if(sobre100){
            titlePuntuacion.setText("Sobre 100 Puntos");
        } else {
            titlePuntuacion.setText("Sobre 10 puntos");
        }

        txtProgreso.setText(valor + getString(R.string.fraccionTotal));



        actualizarProgreso(Integer.valueOf(valor));

        // Inflate the layout for this fragment
        return interfaz;
    }


    public void actualizarProgreso(int nivelProgreso){

        barraProgreso.setProgress(nivelProgreso);

    }

}