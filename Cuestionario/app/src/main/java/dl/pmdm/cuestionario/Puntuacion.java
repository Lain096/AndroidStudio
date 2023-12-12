package dl.pmdm.cuestionario;

public class Puntuacion {

    private Boolean pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, esSobre100;


    //private int puntuacion1 = 0, puntuacion2= 0, puntuacion3=0, puntuacion4 = 0, puntuacion5 =0;

    public Puntuacion(Boolean pregunta1, Boolean pregunta2, Boolean pregunta3, Boolean pregunta4, Boolean pregunta5) {

        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.pregunta3 = pregunta3;
        this.pregunta4 = pregunta4;
        this.pregunta5 = pregunta5;

        esSobre100 = ControlPuntos.getControl().getPuntuacion();
    }


    public int getPuntuacion(){

        Integer puntuacionTotal = puntuacionPregunta1() + puntuacionPregunta2() + puntuacionPregunta3() + puntuacionPregunta4() + puntuacionPregunta5();

        return puntuacionTotal;
    }

    private int puntuacionPregunta1() {

        if (esSobre100) {

            if (pregunta1) {
                return 20;
            } else {
                return -10;
            }

        } else {
            if (pregunta1) {
                return 2;
            } else {
                return -1;
            }
        }
    }

    private int puntuacionPregunta2() {
        if (esSobre100) {

            if (pregunta2) {
                return 20;
            } else {
                return 0;
            }

        } else {
            if (pregunta2) {
                return 2;
            } else {
                return 0;
            }


        }

    }


    private int puntuacionPregunta3() {
        if (esSobre100) {

            if (pregunta3) {
                return 20;
            } else {
                return 0;
            }

        } else {
            if (pregunta3) {
                return 2;
            } else {
                return 0;
            }


        }

    }

    private int puntuacionPregunta4() {
        if (esSobre100) {

            if (pregunta4) {
                return 20;
            } else {
                return 0;
            }

        } else {
            if (pregunta4) {
                return 2;
            } else {
                return 0;
            }


        }

    }

    private int puntuacionPregunta5 () {
        if (esSobre100) {

            if (pregunta5) {
                return 20;
            } else {
                return 0;
            }

        } else {
            if (pregunta5) {
                return 2;
            } else {
                return 0;
            }


        }

    }
}






