package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;


public class Pregunta2 extends AppCompatActivity {


    private final int PREGUNTA_2 = 2;

    Bundle bundle, bundleFragment, bundlePrevio;
    CheckBox pregunta2Mal, pregunta2Bien1, pregunta2Bien2, pregunta2Bien3;
    Boolean cbPreguntaBien1 = false, cbPreguntaBien2 = false, cbPreguntaBien3 = false, cbPreguntaMal = false;

    String respuestaPregunta2 = "";
    Boolean resultadoPregunta2 = false;
    ImageButton btnSiguiente, btnAtras;
    Intent intent, pregunta3, pregunta1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnSiguiente = (ImageButton) findViewById(R.id.btnPregunta2Siguiente);
        btnAtras = (ImageButton) findViewById(R.id.btnPregunta2Anterior);

        pregunta2Mal = (CheckBox)findViewById(R.id.cbPreguntaIncorrecta);
        pregunta2Bien1 = (CheckBox)findViewById(R.id.cbPreguntaVerdadera1);
        pregunta2Bien2 = (CheckBox)findViewById(R.id.cbPreguntaVerdadera2);
        pregunta2Bien3 = (CheckBox)findViewById(R.id.cbPreguntaVerdadera3);

        intent = getIntent();
        bundle = intent.getExtras();

        bundleFragment = new Bundle();

        bundleFragment.putInt("nivelProgreso", PREGUNTA_2);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentPregunta2, Progreso.class, bundleFragment)
                .commit();

        recuperarCheck(bundle);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pregunta3 = new Intent(v.getContext(), Pregunta3.class);

                comprobarRespuestasCheckBox();
                pregunta3.putExtras(bundle);

                startActivity(pregunta3);
                finish() ;


            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                comprobarRespuestasCheckBox();
                pregunta1 = new Intent(v.getContext(), Pregunta1.class);
                pregunta1.putExtras(bundle);

                startActivity(pregunta1) ;

            }
        });


    }


    public void comprobarRespuestasCheckBox() {


        if(pregunta2Bien1.isChecked() && pregunta2Bien2.isChecked() && pregunta2Bien3.isChecked()){

            resultadoPregunta2 = true;
            bundle.putBoolean("resultadoPregunta2", resultadoPregunta2);

        } else {
            resultadoPregunta2 = false;
            bundle.putBoolean("resultadoPregunta2", resultadoPregunta2);
        }


        if(pregunta2Bien1.isChecked()){

            respuestaPregunta2 +=  "-"+pregunta2Bien1.getText().toString()+ "\n";
            cbPreguntaBien1 = true;

        } else {
            cbPreguntaBien1 = false;

        }

        if(pregunta2Bien2.isChecked()){

            respuestaPregunta2 +=  "-"+pregunta2Bien2.getText().toString()+ "\n";
            cbPreguntaBien2 = true;


        } else {
            cbPreguntaBien2 = false;

        }

        if(pregunta2Bien3.isChecked()){

            respuestaPregunta2 +=  "-"+pregunta2Bien3.getText().toString()+ "\n";

            cbPreguntaBien3 = true;
        } else {
            cbPreguntaBien3 = false;
        }

        if(pregunta2Mal.isChecked()){

            respuestaPregunta2 += "-"+pregunta2Mal.getText().toString()+ "\n";
            cbPreguntaMal = true;

        } else {
            cbPreguntaMal = false;
        }

        bundle.putBoolean("pregunta2Bien1", cbPreguntaBien1);
        bundle.putBoolean("pregunta2Bien2", cbPreguntaBien2);
        bundle.putBoolean("pregunta2Bien3", cbPreguntaBien3);
        bundle.putBoolean("pregunta2Mal", cbPreguntaMal);
        bundle.putString("respuestaPregunta2", respuestaPregunta2);

    }


    private void recuperarCheck(Bundle bundle){

        if(bundle.getBoolean("pregunta2Bien1")){

            pregunta2Bien1.setChecked(true);
        }
        if(bundle.getBoolean("pregunta2Bien2")){

            pregunta2Bien2.setChecked(true);
        }
        if(bundle.getBoolean("pregunta2Bien3")){

            pregunta2Bien3.setChecked(true);
        }
        if(bundle.getBoolean("pregunta2Mal")){

            pregunta2Mal.setChecked(true);
        }

    }




}