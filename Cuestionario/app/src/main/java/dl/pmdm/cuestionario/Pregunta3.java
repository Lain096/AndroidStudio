package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Pregunta3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final int PREGUNTA_3 = 3;
    private final String PREGUNTA3_RESPUESTA = "FTP";
    Spinner spinner;
    Intent intent, pregunta4, pregunta2;
    Bundle bundle, bundleFragment;

    Boolean resultadoPregunta3 = false;

    ImageButton btnSiguiente, btnAnterior;

    Integer posicion;


    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        spinner = (Spinner) findViewById(R.id.idSpinnerPregunta3);

        btnSiguiente = (ImageButton) findViewById(R.id.btnPregunta3Siguiente);
        btnAnterior = (ImageButton) findViewById(R.id.btnPregunta3Anterior);

        intent = getIntent();
        bundle = intent.getExtras();


        bundleFragment = new Bundle();
        bundleFragment.putInt("nivelProgreso", PREGUNTA_3);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentPregunta3, Progreso.class, bundleFragment).commit();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.solucionesPregunta3, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(this);

        if (bundle.getBoolean("otra")) {
            marcarPosicion(bundle);

        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text.equals(PREGUNTA3_RESPUESTA)) {

                    resultadoPregunta3 = true;

                } else {
                    resultadoPregunta3 = false;
                }

                bundle.putString("respuestaPregunta3", text);
                bundle.putBoolean("resultadoPregunta3", resultadoPregunta3);
                bundle.putInt("posicion", posicion);
                bundle.putBoolean("otra", true);

                pregunta4 = new Intent(v.getContext(), Pregunta4.class);

                pregunta4.putExtras(bundle);

                startActivity(pregunta4);
                finish();

            }
        });


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta2 = new Intent(v.getContext(), Pregunta2.class);

                if (text.equals(PREGUNTA3_RESPUESTA)) {

                    resultadoPregunta3 = true;

                } else {
                    resultadoPregunta3 = false;
                }

                bundle.putString("respuestaPregunta3", text);
                bundle.putBoolean("resultadoPregunta3", resultadoPregunta3);
                bundle.putInt("posicion", posicion);
                bundle.putBoolean("otra", true);
                pregunta2.putExtras(bundle);

                startActivity(pregunta2);
                finish();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        text = parent.getItemAtPosition(position).toString();
        posicion = parent.getSelectedItemPosition();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void marcarPosicion(Bundle bundle) {

        spinner.setSelection(bundle.getInt("posicion"));
    }
}