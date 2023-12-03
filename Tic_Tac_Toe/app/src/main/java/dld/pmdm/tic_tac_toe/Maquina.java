package dld.pmdm.tic_tac_toe;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maquina {

    String[] arrayTagsTablero = new String[9];

    List<Integer> cruces = new ArrayList<>();
    List<Integer> circulos = new ArrayList<>();


    int[][] combinacionesGanadoras = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, //Horizontales
            {1, 5, 9}, {3, 5, 7}, //diagonales
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9}}; //Verticales

    public Integer realizarJugadaPrioritaria(GameWindow juego) {

        estadoTablero(juego);
        inicializarVariables();

        Integer winPosition = checkWin();


        if (winPosition != null) {
            return winPosition;
        } else {
            Integer loosePosition = checkLoose();
            if (loosePosition != null) {
                return loosePosition;
            } else {
                Integer jugadaMedia = jugadaMedia();

                if(jugadaMedia != null){
                    return jugadaMedia;
                } else {
                    return jugadaBasica();
                }
            }
        }
    }

    private Integer jugadaBasica() {

        List<Integer> lista = new ArrayList<>();
        Random random = new Random();


        for (int j = 0; j < arrayTagsTablero.length; j++) {

            if (arrayTagsTablero[j] == null) {

                lista.add(j + 1);
            }

        }
        Integer posicion = 0;

            posicion = lista.get(random.nextInt(lista.size()));


        return posicion;
    }


    private Integer jugadaMedia() {

        int coincidencias;

        for (int i = 0; i < combinacionesGanadoras.length; i++) {
            coincidencias = 0;

            List<Integer> posicionesGanadoras = new ArrayList<>();
            //recorriendo el 123 de las matrices
            for (int j = 0; j < combinacionesGanadoras[i].length; j++) {

                //Comparando si la lista de circulos contiene las posiciones que están dentro de las combinaciones ganadoras de que recorre
                if (circulos.contains(combinacionesGanadoras[i][j])) {
                    coincidencias++;
                } else {
                    posicionesGanadoras.add(combinacionesGanadoras[i][j]);
                }
            }
            if (coincidencias == 1) {

                if (!cruces.contains(posicionesGanadoras.get(0)) && !cruces.contains(posicionesGanadoras.get(1))) {
                    return posicionesGanadoras.get(0);
                }
            }

        }


        return null;
    }

    private Integer checkWin() {

        int coincidencias;

        // recorriendo las matrices
        for (int i = 0; i < combinacionesGanadoras.length; i++) {
            coincidencias = 0;

            List<Integer> posicionesGanadoras = new ArrayList<>();
            //recorriendo el 123 de las matrices
            for (int j = 0; j < combinacionesGanadoras[i].length; j++) {

                //Comparando si la lista de circulos contiene las posiciones que están dentro de las combinaciones ganadoras de que recorre
                if (circulos.contains(combinacionesGanadoras[i][j])) {
                    coincidencias++;
                } else {
                    posicionesGanadoras.add(combinacionesGanadoras[i][j]);
                }
            }
            if (coincidencias == 2) {

                if (!cruces.contains(posicionesGanadoras.get(0))) {
                    return posicionesGanadoras.get(0);
                }
            }

        }
        return null;
    }

    private Integer checkLoose() {

        int coincidencias;

        // recorriendo las matrices
        for (int i = 0; i < combinacionesGanadoras.length; i++) {
            coincidencias = 0;

            List<Integer> posicionesPerdedoras = new ArrayList<>();
            //recorriendo el 123 de las matrices
            for (int j = 0; j < combinacionesGanadoras[i].length; j++) {

                //Comparando si la lista de circulos contiene las posiciones que están dentro de las combinaciones ganadoras de que recorre
                if (cruces.contains(combinacionesGanadoras[i][j])) {
                    coincidencias++;
                } else {
                    posicionesPerdedoras.add(combinacionesGanadoras[i][j]);
                }
            }
            if (coincidencias == 2) {
                if (!circulos.contains(posicionesPerdedoras.get(0))) {
                    return posicionesPerdedoras.get(0);
                }
            }


        }
        return null;
    }

    private void inicializarVariables() {


        cruces = new ArrayList<>();
        circulos = new ArrayList<>();

        for (int k = 0; k < arrayTagsTablero.length; k++) {

            if (arrayTagsTablero[k] == "cruz") {
                cruces.add(k + 1);
            } else if (arrayTagsTablero[k] == "circulo") {
                circulos.add(k + 1);
            }

        }
    }


    private void estadoTablero(GameWindow juego) {
        for (int i = 0; i < juego.tagsTablero.size(); i++) {

            arrayTagsTablero[i] = ((String) juego.tagsTablero.get(i).getTag());

        }
    }
}
