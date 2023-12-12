package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Pregunta4 extends AppCompatActivity {


    private final int PREGUNTA_4 = 4;
    ImageButton btnSiguiente, btnAtras;

    ImageButton btnRespuestaMal1, btnRespuestaMal2, btnRespuestaMal3, btnRespuestaBien;

    ImageButton imgSeleccionada;
    Intent intent, pregunta5, pregunta3;
    Bundle bundle, bundleFragment;
    Boolean resultadoPregunta4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnSiguiente = (ImageButton) findViewById(R.id.btnPregunta4Siguiente);
        btnAtras = (ImageButton) findViewById(R.id.btnPregunta4Anterior);
        btnRespuestaMal1 = (ImageButton) findViewById(R.id.idPregunta4Mal1);
        btnRespuestaMal2 = (ImageButton) findViewById(R.id.idPregunta4Mal2);
        btnRespuestaMal3 = (ImageButton) findViewById(R.id.idPregunta4Mal3);
        btnRespuestaBien = (ImageButton) findViewById(R.id.idPregunta4Bien);


        intent = getIntent();
        bundle = intent.getExtras();

        bundleFragment = new Bundle();
        bundleFragment.putInt("nivelProgreso", PREGUNTA_4);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentPregunta4, Progreso.class, bundleFragment).commit();


        btnRespuestaMal1.setOnClickListener(onClick);
        btnRespuestaMal2.setOnClickListener(onClick);
        btnRespuestaMal3.setOnClickListener(onClick);
        btnRespuestaBien.setOnClickListener(onClick);

        marcarImagen(bundle);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pregunta5 = new Intent(v.getContext(), Pregunta5.class);


               try {
                   if (imgSeleccionada.getId() == btnRespuestaBien.getId()) {
                       resultadoPregunta4 = true;

                   } else {
                       resultadoPregunta4 =false;
                   }


                bundle.putBoolean("resultadoPregunta4", resultadoPregunta4);
                pregunta5.putExtras(bundle);

                startActivity(pregunta5);
                finish();
               }catch (NullPointerException e){
                   Toast.makeText(Pregunta4.this, "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
               }

            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta3 = new Intent(v.getContext(), Pregunta3.class);

                pregunta3.putExtras(bundle);

                startActivity(pregunta3);
                finish();
            }
        });

    }


    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            deseleccionarBotones();


            v.setSelected(!v.isSelected());
            if (v.isSelected()) {
                v.setBackgroundColor(getResources().getColor(R.color.azulito));
            }
            imgSeleccionada = (ImageButton) v;
            bundle.putInt("respuestaPregunta4", imgSeleccionada.getId());


        }
    };

    private void deseleccionarBotones() {
        btnRespuestaMal1.setSelected(false);
        btnRespuestaMal1.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        btnRespuestaMal2.setSelected(false);
        btnRespuestaMal2.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        btnRespuestaMal3.setSelected(false);
        btnRespuestaMal3.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        btnRespuestaBien.setSelected(false);
        btnRespuestaBien.setBackgroundColor(getResources().getColor(android.R.color.transparent));

    }


    private void marcarImagen(Bundle bundle){

        if(bundle.getInt("respuestaPregunta4") == R.drawable.cassandra){
            btnRespuestaMal1.setSelected(true);
            btnRespuestaMal1.setBackgroundColor(getResources().getColor(R.color.azulito));
        }

        if(bundle.getInt("respuestaPregunta4") == R.drawable.mongodb){
            btnRespuestaMal2.setSelected(true);
            btnRespuestaMal2.setBackgroundColor(getResources().getColor(R.color.azulito));
        }

        if(bundle.getInt("respuestaPregunta4") == R.drawable.redis){
            btnRespuestaMal3.setSelected(true);
            btnRespuestaMal3.setBackgroundColor(getResources().getColor(R.color.azulito));
        }

        if(bundle.getInt("respuestaPregunta4") == R.drawable.mysql){
            btnRespuestaBien.setSelected(true);
            btnRespuestaBien.setBackgroundColor(getResources().getColor(R.color.azulito));
        }

    }
}