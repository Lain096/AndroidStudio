package dl.pmdm.cuestionario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class Resumen extends AppCompatActivity {

    ScrollView scroll;

    TextView nombre, puntuacion;
    Intent intent;
    Bundle bundle;
    Boolean pregunta1Bien, pregunta2Bien, pregunta3Bien, pregunta4Bien, pregunta5Bien;

    Button volverInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        scroll = (ScrollView) findViewById(R.id.idScroll);
        nombre = (TextView) findViewById(R.id.idCuestionadoNombre);
        puntuacion = (TextView) findViewById(R.id.idCuestionadoScore);
        volverInicio = (Button) findViewById(R.id.btnInicio);

                intent = getIntent();
        bundle = intent.getExtras();


        pregunta1Bien = bundle.getBoolean("resultadoPregunta1");
        pregunta2Bien = bundle.getBoolean("resultadoPregunta2");
        pregunta3Bien = bundle.getBoolean("resultadoPregunta3");
        pregunta4Bien = bundle.getBoolean("resultadoPregunta4");
        pregunta5Bien = bundle.getBoolean("resultadoPregunta5");

        Puntuacion puntuaje = new Puntuacion(pregunta1Bien, pregunta2Bien, pregunta3Bien, pregunta4Bien, pregunta5Bien);

        nombre.setText("Alumno: " + bundle.getString("nombre"));
        puntuacion.setText("Puntuacion: " + puntuaje.getPuntuacion());

        // Creacion del contenedor

        LinearLayout contenedor = new LinearLayout(this);
        contenedor.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        ));
        contenedor.setOrientation(LinearLayout.VERTICAL);

        contenedor.addView(comprobacionPregunta1());

        contenedor.addView(comprobacionPregunta2());

        contenedor.addView(comprobacionPregunta3());

        contenedor.addView(comprobacionPregunta4());

        contenedor.addView(comprobacionPregunta5());


        // añadir todo al contenedor
        scroll.addView(contenedor);
        volverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inicio = new Intent(v.getContext(), Inicio.class);
                startActivity(inicio);
                finish();


            }
        });



    }


    private CardView generarCardView() {
        CardView cardView = new CardView(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(10, 10, 10, 10);

        cardView.setLayoutParams(params);


        cardView.setBackgroundColor(getResources().getColor(R.color.grey));
        cardView.setRadius(50);


        return cardView;
    }

    private LinearLayout generarLinearLayout() {
        LinearLayout layoutVertical = new LinearLayout(this);
        layoutVertical.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        layoutVertical.setOrientation(LinearLayout.VERTICAL);

        return layoutVertical;
    }


    private CardView comprobacionPregunta1() {

        LinearLayout layoutPregunta1 = generarLinearLayout();

        TextView titulo = new TextView(this);
        titulo.setText("Pregunta: \n" + getResources().getString(R.string.pregunta1));

        TextView respuestaIncorrecta = new TextView(this);
        if(bundle.getString("respuestaPregunta1") != null){
            respuestaIncorrecta.setText("Tu respuesta: \n" + bundle.getString("respuestaPregunta1"));
        } else{
            respuestaIncorrecta.setText("Tu respuesta: \n" + "No has respondido nada");
        }



        TextView respuestaCorrecta = new TextView(this);
        respuestaCorrecta.setText("Respuesta Correcta: \n" + getResources().getString(R.string.respuestaVerdaderaPregunta1));



        if(!pregunta1Bien){
            titulo.setTextColor(getResources().getColor(R.color.red));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.red));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.red));
        } else {
            titulo.setTextColor(getResources().getColor(R.color.white));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));
        }

        CardView cardView = generarCardView();

        layoutPregunta1.addView(titulo);
        layoutPregunta1.addView(respuestaIncorrecta);
        layoutPregunta1.addView(respuestaCorrecta);

        cardView.addView(layoutPregunta1);


        return cardView;
    }

    private CardView comprobacionPregunta2() {

        LinearLayout layoutPregunta = generarLinearLayout();

        TextView titulo = new TextView(this);
        titulo.setText("Pregunta: \n" + getResources().getString(R.string.pregunta2));
        titulo.setTextColor(getResources().getColor(R.color.white));



        TextView respuestaIncorrecta = new TextView(this);
        respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));

        if(bundle.getString("respuestaPregunta2") != null){
            respuestaIncorrecta.setText("Tu respuesta: \n" + bundle.getString("respuestaPregunta2"));
        } else{
            respuestaIncorrecta.setText("Tu respuesta: \n" + " No has respondido nada");
        }

        TextView respuestaCorrecta = new TextView(this);
        respuestaCorrecta.setText("Respuesta Correcta: \n"
                + "- " + getResources().getString(R.string.pregunta2RespuestaVerdadera1) + "\n"
                + "- " + getResources().getString(R.string.pregunta2RespuestaVerdadera2) + "\n"
                + "- " + getResources().getString(R.string.pregunta2RespuestaVerdadera3));
        respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));

        if(!pregunta2Bien){
            titulo.setTextColor(getResources().getColor(R.color.red));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.red));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.red));
        } else {
            titulo.setTextColor(getResources().getColor(R.color.white));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));
        }

        CardView cardView = generarCardView();

        layoutPregunta.addView(titulo);
        layoutPregunta.addView(respuestaIncorrecta);
        layoutPregunta.addView(respuestaCorrecta);

        cardView.addView(layoutPregunta);


        return cardView;
    }

    private CardView comprobacionPregunta3() {

        LinearLayout layoutPregunta1 = generarLinearLayout();

        TextView titulo = new TextView(this);
        titulo.setText("Pregunta: \n" + getResources().getString(R.string.pregunta3));
        titulo.setTextColor(getResources().getColor(R.color.white));


        TextView respuestaIncorrecta = new TextView(this);
        respuestaIncorrecta.setText("Tu respuesta: \n" + bundle.getString("respuestaPregunta3"));
        respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));

        TextView respuestaCorrecta = new TextView(this);
        respuestaCorrecta.setText("Respuesta Correcta: \n" + getResources().getString(R.string.respuestaVerdaderaPregunta3));
        respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));

        if(!pregunta3Bien){
            titulo.setTextColor(getResources().getColor(R.color.red));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.red));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.red));
        } else {
            titulo.setTextColor(getResources().getColor(R.color.white));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));
        }

        CardView cardView = generarCardView();

        layoutPregunta1.addView(titulo);
        layoutPregunta1.addView(respuestaIncorrecta);
        layoutPregunta1.addView(respuestaCorrecta);

        cardView.addView(layoutPregunta1);


        return cardView;
    }

    private CardView comprobacionPregunta4() {

        LinearLayout layoutPregunta1 = generarLinearLayout();

        TextView titulo = new TextView(this);
        titulo.setText("Pregunta: \n" + getResources().getString(R.string.pregunta4));
        titulo.setTextColor(getResources().getColor(R.color.white));


        TextView respuestaIncorrecta = new TextView(this);
        respuestaIncorrecta.setText("Tu respuesta: ");
        respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));


        // No entiendo por que no me muestra imagenIncorrecta, si el ID sí que se pasa mediante el bundle

        ImageView imagenIncorrecta = new ImageView(this);
       // ImageView imagenIncorrecta = findViewById(bundle.getInt("respuestaPregunta4"));
        imagenIncorrecta.setLayoutParams(new ViewGroup.LayoutParams(150, 100));
       // imagenIncorrecta = findViewById(bundle.getInt("respuestaPregunta4"));
        imagenIncorrecta.setImageResource(bundle.getInt("respuestaPregunta4"));

        ImageView imagenCorrecta = new ImageView(this);
        imagenCorrecta.setLayoutParams(new ViewGroup.LayoutParams(150, 100));
        imagenCorrecta.setImageResource(R.drawable.mysql);


        TextView respuestaCorrecta = new TextView(this);
        respuestaCorrecta.setText("Respuesta Correcta: ");
        respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));

        if(!pregunta4Bien){
            titulo.setTextColor(getResources().getColor(R.color.red));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.red));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.red));
        } else {
            titulo.setTextColor(getResources().getColor(R.color.white));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));
        }

        CardView cardView = generarCardView();

        layoutPregunta1.addView(titulo);
        layoutPregunta1.addView(respuestaIncorrecta);
        layoutPregunta1.addView(imagenIncorrecta);
        layoutPregunta1.addView(respuestaCorrecta);
        layoutPregunta1.addView(imagenCorrecta);

        cardView.addView(layoutPregunta1);


        return cardView;
    }


    private CardView comprobacionPregunta5() {

        LinearLayout layoutPregunta1 = generarLinearLayout();

        TextView titulo = new TextView(this);
        titulo.setText("Pregunta: \n" + getResources().getString(R.string.pregunta5));
        titulo.setTextColor(getResources().getColor(R.color.white));


        TextView respuestaIncorrecta = new TextView(this);

        respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));

        if(bundle.getString("respuestaPregunta5") != null){
            respuestaIncorrecta.setText("Tu respuesta: \n" + bundle.getString("respuestaPregunta5"));
        } else{
            respuestaIncorrecta.setText("Tu respuesta: \n" + "No has respondido nada");
        }

        TextView respuestaCorrecta = new TextView(this);
        respuestaCorrecta.setText("Respuesta Correcta: \n" + getResources().getString(R.string.respuestaCorrectaPregunta5));
        respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));

        if(!pregunta5Bien){
            titulo.setTextColor(getResources().getColor(R.color.red));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.red));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.red));
        } else {
            titulo.setTextColor(getResources().getColor(R.color.white));
            respuestaIncorrecta.setTextColor(getResources().getColor(R.color.white));
            respuestaCorrecta.setTextColor(getResources().getColor(R.color.white));
        }

        CardView cardView = generarCardView();

        layoutPregunta1.addView(titulo);
        layoutPregunta1.addView(respuestaIncorrecta);
        layoutPregunta1.addView(respuestaCorrecta);

        cardView.addView(layoutPregunta1);


        return cardView;
    }




}