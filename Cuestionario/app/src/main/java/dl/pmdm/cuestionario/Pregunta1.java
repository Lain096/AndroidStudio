package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Pregunta1 extends AppCompatActivity {


    private RadioGroup group;

    private final int N_PREGUNTA = 1;

    private boolean pregunta1Bien = false;
    String pregunta1Seleccionada;
    private ImageButton botonSiguiente, btnAyuda;
    private Intent intent, pregunta2;
    private Bundle bundle, bundleFragment;

    RadioButton respuestaMal1, respuestaMal2, respuestaBien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        intent = getIntent();
        bundle = intent.getExtras();

        group = (RadioGroup) findViewById(R.id.idRgPregunta1);

        botonSiguiente = (ImageButton) findViewById(R.id.btnPregunta1Siguiente);
        btnAyuda = (ImageButton) findViewById(R.id.btnAyuda);

        respuestaMal1 = findViewById(R.id.pregunta1RespuestaFalsa1);
        respuestaMal2 = findViewById(R.id.pregunta1RespuestaFalsa2);
        respuestaBien = findViewById(R.id.pregunta1RespuestaVerdadera);

        bundleFragment = new Bundle();

        bundleFragment.putInt("nivelProgreso", N_PREGUNTA);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentPregunta1, Progreso.class, bundleFragment)
                .commit();


        if (bundle.getString("respuestaPregunta1") != null) {
            checkMarcados(bundle);
        }


        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                comprobarRespuesta();

                pregunta2 = new Intent(v.getContext(), Pregunta2.class);
                bundle.putBoolean("resultadoPregunta1", pregunta1Bien);

                pregunta2.putExtras(bundle);
                startActivity(pregunta2);
                finish();
            }
        });

        btnAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ControlPuntos.getControl().getPuntuacion()) {
                    Toast.makeText(Pregunta1.this, "Respuesta incorrecta resta 10 puntos (-10), OJO", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Pregunta1.this, "Respuesta incorrecta resta 1 punto (-1), OJO", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    private void comprobarRespuesta() {

        int respuesta = group.getCheckedRadioButtonId();

        if (respuesta == R.id.pregunta1RespuestaVerdadera) {
            pregunta1Bien = true;
            pregunta1Seleccionada = respuestaBien.getText().toString();

        }
        if (respuesta == R.id.pregunta1RespuestaFalsa1) {
            pregunta1Bien = false;
            pregunta1Seleccionada = respuestaMal1.getText().toString();

        }

        if (respuesta == R.id.pregunta1RespuestaFalsa2) {
            pregunta1Bien = false;
            pregunta1Seleccionada = respuestaMal2.getText().toString();
        }


        bundle.putString("respuestaPregunta1", pregunta1Seleccionada);

    }


    private void checkMarcados(Bundle bundle) {

        if (bundle.getString("respuestaPregunta1").equals(respuestaBien.getText().toString())) {
            respuestaBien.setChecked(true);
        }
        if (bundle.getString("respuestaPregunta1").equals(respuestaMal1.getText().toString())) {
            respuestaMal1.setChecked(true);
        }
        if (bundle.getString("respuestaPregunta1").equals(respuestaMal2.getText().toString())) {
            respuestaMal2.setChecked(true);
        }

    }


}