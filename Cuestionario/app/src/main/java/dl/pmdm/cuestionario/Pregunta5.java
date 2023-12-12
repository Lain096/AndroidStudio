package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class Pregunta5 extends AppCompatActivity {

    private final int PREGUNTA_5 = 5;
    private final String RESPUESTA_5 = "Barbie";

    EditText txtRespuesta;
    Intent intent, resumen, pregunta4;
    Bundle bundle, bundleFragment;

    ImageButton btnSiguiente, btnAtras;
    Boolean resultadoPregunta5 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtRespuesta = (EditText)findViewById(R.id.txtRespuestaPregunta5);
        btnSiguiente = (ImageButton)findViewById(R.id.btnPregunta5Siguiente);
        btnAtras = (ImageButton)findViewById(R.id.btnPregunta5Anterior);

        intent = getIntent();
        bundle = intent.getExtras();

        bundleFragment = new Bundle();
        bundleFragment.putInt("nivelProgreso", PREGUNTA_5);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentPregunta5, Progreso.class, bundleFragment).commit();

        if(bundle.getString("respuestaPregunta5") != null){

            txtRespuesta.setText(bundle.getString("respuestaPregunta5"));
        }


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                comprobarText();

                resumen = new Intent(v.getContext(), Resumen.class);

                //resumen.putExtra("EXIT", true);
                resumen.putExtras(bundle);
                //resumen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(resumen);
                finish();

            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta4 = new Intent(v.getContext(), Pregunta4.class);
                comprobarText();
                pregunta4.putExtras(bundle);
                startActivity(pregunta4);
            }
        });



    }

    private void comprobarText(){

        String escrito = txtRespuesta.getText().toString();

        if(escrito.toLowerCase().equals(RESPUESTA_5.toLowerCase().trim())){

            resultadoPregunta5 = true;
        } else{
            resultadoPregunta5 = false;
        }

        bundle.putBoolean("resultadoPregunta5", resultadoPregunta5);
        bundle.putString("respuestaPregunta5", escrito);
    }
}