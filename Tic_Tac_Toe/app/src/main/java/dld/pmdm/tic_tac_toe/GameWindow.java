package dld.pmdm.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class GameWindow extends AppCompatActivity {

    TextView turnoJugador, jugador1, jugador2;

    List<ImageView> tagsTablero = new ArrayList<ImageView>();

    int victoriasJ1, victoriasJ2;
    Boolean vsJugador, vsMaquina;
    ImageView img11, img12, img13, img21, img22, img23, img31, img32, img33;

    Intent appInicio;


    private boolean esTurnoJugador = true;

    Button reinicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);

        appInicio = getIntent();
        turnoJugador = (TextView) findViewById(R.id.lblTurnos);
        turnoJugador.setText("Turno del Jugador 1");
        jugador1 = (TextView) findViewById(R.id.jugador1);
        jugador2 = (TextView) findViewById(R.id.jugador2);

        vsJugador = appInicio.getExtras().getBoolean("vsJugador");
        vsMaquina = appInicio.getExtras().getBoolean("vsMaquina");
        if (vsMaquina) {
            jugador2.setText("Maquina: 0");
        }


        reinicio = (Button) findViewById(R.id.reiniciar);

        img11 = (ImageView) findViewById(R.id.f11);
        img12 = (ImageView) findViewById(R.id.f12);
        img13 = (ImageView) findViewById(R.id.f13);
        img21 = (ImageView) findViewById(R.id.f21);
        img22 = (ImageView) findViewById(R.id.f22);
        img23 = (ImageView) findViewById(R.id.f23);
        img31 = (ImageView) findViewById(R.id.f31);
        img32 = (ImageView) findViewById(R.id.f32);
        img33 = (ImageView) findViewById(R.id.f33);

        // no funciona el addAll
        tagsTablero.add(img11);
        tagsTablero.add(img12);
        tagsTablero.add(img13);
        tagsTablero.add(img21);
        tagsTablero.add(img22);
        tagsTablero.add(img23);
        tagsTablero.add(img31);
        tagsTablero.add(img32);
        tagsTablero.add(img33);

        reinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarPartida();
            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (esTurnoJugador) {
                    haClicado(img11);
                }
                if (vsJugador) {
                    haClicado(img11);
                }

            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img12);
                }
                if (vsJugador) {
                    haClicado(img12);
                }

            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img13);
                }
                if (vsJugador) {
                    haClicado(img13);
                }

            }
        });
        img21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img21);
                }
                if (vsJugador) {
                    haClicado(img21);
                }

            }
        });
        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img22);
                }
                if (vsJugador) {
                    haClicado(img22);
                }

            }
        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img23);
                }
                if (vsJugador) {
                    haClicado(img23);
                }
            }
        });
        img31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img31);
                }
                if (vsJugador) {
                    haClicado(img31);
                }

            }
        });
        img32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img32);
                }
                if (vsJugador) {
                    haClicado(img32);
                }

            }
        });
        img33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (esTurnoJugador) {
                    haClicado(img33);
                }
                if (vsJugador) {
                    haClicado(img33);
                }

            }
        });

    }


    private void checkTurno() {

        if (esTurnoJugador) {
            turnoJugador.setText("Turno de Jugador 1");
        } else if (vsJugador) {
            turnoJugador.setText("Turno de Jugador 2");
        } else if (vsMaquina) {
            turnoJugador.setText("Turno de la Máquina");
        }
    }

    private void haClicado(ImageView img) {

        if (img.getTag() == null) {
            if (esTurnoJugador) {
                img.setImageResource(R.drawable.cruz);
                img.setTag("cruz");
                Boolean resultado = comprobarGanador();

                if(resultado == null){
                    Toast.makeText(this, "EMPATE!", Toast.LENGTH_LONG).show();
                  //  reiniciarPartida();
                } else if (resultado) {
                    victoriasJ1++;
                    jugador1.setText("Jugador 1: " + victoriasJ1);
                    Toast.makeText(this, "Ha ganado el Jugador 1", Toast.LENGTH_SHORT).show();
                 //   reiniciarPartida();
                } else  if(!resultado){
                    cambiarTurno();
                    checkTurno();
                }
            } else {
                img.setImageResource(R.drawable.circulo);
                img.setTag("circulo");
                Boolean resultado = comprobarGanador();

                if(resultado == null){
                    Toast.makeText(this, "EMPATE!", Toast.LENGTH_LONG).show();
                  //  reiniciarPartida();
                } else if (resultado) {
                    if (vsJugador) {
                        victoriasJ2++;
                        jugador2.setText("Jugador 2: " + victoriasJ2);
                        Toast.makeText(this, "Ha ganado el Jugador 2", Toast.LENGTH_SHORT).show();
                       // reiniciarPartida();

                    } else  if(!resultado){
                        cambiarTurno();
                        checkTurno();

                    }
                }

            }
        }


    }

    private void cambiarTurno() {

        if (esTurnoJugador) {
            esTurnoJugador = false;
            if (vsMaquina) {
                jugadaMaquina();
            }

        } else {
            esTurnoJugador = true;
        }
    }

    private void jugadaMaquina() {
        Maquina maquina = new Maquina();

        Integer posicionJugada = maquina.realizarJugadaPrioritaria(this);

        switch (posicionJugada) {

            case 1:
                img11.setTag("circulo");
                img11.setImageResource(R.drawable.circulo);
                break;
            case 2:
                img12.setTag("circulo");
                img12.setImageResource(R.drawable.circulo);
                break;
            case 3:
                img13.setTag("circulo");
                img13.setImageResource(R.drawable.circulo);
                break;
            case 4:
                img21.setTag("circulo");
                img21.setImageResource(R.drawable.circulo);
                break;
            case 5:
                img22.setTag("circulo");
                img22.setImageResource(R.drawable.circulo);
                break;
            case 6:
                img23.setTag("circulo");
                img23.setImageResource(R.drawable.circulo);
                break;
            case 7:
                img31.setTag("circulo");
                img31.setImageResource(R.drawable.circulo);
                break;
            case 8:
                img32.setTag("circulo");
                img32.setImageResource(R.drawable.circulo);
                break;
            case 9:
                img33.setTag("circulo");
                img33.setImageResource(R.drawable.circulo);
                break;

        }

        Boolean resultado = comprobarGanador();

        if(resultado == null){
            Toast.makeText(this, "EMPATE!", Toast.LENGTH_LONG).show();
           // reiniciarPartida();
        } else if (resultado) {
            victoriasJ2++;
            jugador2.setText("Máquina: " + victoriasJ2);
            Toast.makeText(this, "Ha ganado la máquina", Toast.LENGTH_LONG).show();
            //reiniciarPartida();
        } else if (!resultado){
            cambiarTurno();
            checkTurno();
        }


    }

    private Boolean comprobarGanador() {

        int[][] combinacionesGanadoras = {
                {R.id.f11, R.id.f12, R.id.f13},
                {R.id.f21, R.id.f22, R.id.f23},
                {R.id.f31, R.id.f32, R.id.f33},
                {R.id.f11, R.id.f21, R.id.f31},
                {R.id.f12, R.id.f22, R.id.f32},
                {R.id.f13, R.id.f23, R.id.f33},
                {R.id.f11, R.id.f22, R.id.f33},
                {R.id.f13, R.id.f22, R.id.f31}};


        for (int[] combinacion : combinacionesGanadoras) {
            ImageView casilla1 = (ImageView) findViewById(combinacion[0]);
            ImageView casilla2 = (ImageView) findViewById(combinacion[1]);
            ImageView casilla3 = (ImageView) findViewById(combinacion[2]);

            Object tag1 = casilla1.getTag();
            Object tag2 = casilla2.getTag();
            Object tag3 = casilla3.getTag();


            if (tag1 != null && tag1.equals(tag2) && tag2.equals(tag3)) {

                return true;
            }

        }
       if (
        img11.getTag() != null &&
        img12.getTag() != null &&
        img13.getTag() != null &&
        img21.getTag() != null &&
        img22.getTag() != null &&
        img23.getTag() != null &&
        img31.getTag() != null &&
        img32.getTag() != null &&
        img33.getTag() != null){
           return null;
       }


        return false;
    }

    private void reiniciarPartida() {


        esTurnoJugador = true;

        img11.setImageResource(R.drawable.shape);
        img12.setImageResource(R.drawable.shape);
        img13.setImageResource(R.drawable.shape);
        img21.setImageResource(R.drawable.shape);
        img22.setImageResource(R.drawable.shape);
        img23.setImageResource(R.drawable.shape);
        img31.setImageResource(R.drawable.shape);
        img32.setImageResource(R.drawable.shape);
        img33.setImageResource(R.drawable.shape);

        img11.setTag(null);
        img12.setTag(null);
        img13.setTag(null);
        img21.setTag(null);
        img22.setTag(null);
        img23.setTag(null);
        img31.setTag(null);
        img32.setTag(null);
        img33.setTag(null);

    }

}