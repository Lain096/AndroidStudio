package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    RadioGroup rg;
    Button btnInicio;

    Boolean sobre100;
    EditText txtNombre;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        rg = (RadioGroup) findViewById(R.id.radioGroup);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        txtNombre = (EditText)findViewById(R.id.txtNombre);


        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtNombre.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Inicio.this, "Introduce un nombre!!", Toast.LENGTH_LONG).show();
                }else{

                    int eleccion = rg.getCheckedRadioButtonId();

                    if (eleccion == R.id.rd10Puntos){
                        sobre100 = false;

                    }
                    if (eleccion == R.id.rd100Puntos){
                        sobre100 = true;

                    }

                    ControlPuntos.getControl().setPuntuacion(sobre100);



                    Bundle bundle = new Bundle();
                    bundle.putString("nombre", txtNombre.getText().toString());
                    intent = new Intent(v.getContext(), Pregunta1.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                    finish();

                }





            }
        });


    }




}