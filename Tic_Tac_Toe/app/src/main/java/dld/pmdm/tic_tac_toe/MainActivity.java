package dld.pmdm.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btnStart;

    RadioButton vsJugador, vsMaquina;
    Boolean isVsJugador = false, isVsMaquina = false;
    Intent startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStartJuego);
        vsJugador = (RadioButton) findViewById(R.id.rdBtnVsJugador);
        vsMaquina = (RadioButton) findViewById(R.id.rdBtnVsMaquina);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Bundle bundle = new Bundle();

             if(vsJugador.isChecked()){
                isVsJugador = true;
                bundle.putBoolean("vsJugador", true);
             } if(vsMaquina.isChecked()){
                 isVsMaquina = true;
                 bundle.putBoolean("vsMaquina", true);
                }

             startGame = new Intent(v.getContext(), GameWindow.class);
             startGame.putExtras(bundle);
             startActivity(startGame);
            }
        });

    }
}