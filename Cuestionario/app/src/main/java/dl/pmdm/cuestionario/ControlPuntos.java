package dl.pmdm.cuestionario;

public class ControlPuntos {

    private static ControlPuntos instance;

    private static boolean puntuacion;

    private ControlPuntos(){

    }

    public static ControlPuntos getControl(){

        if (instance == null){
        instance = new ControlPuntos();
        }

    return instance;
    }


    public void setPuntuacion(boolean sobre100){
        this.puntuacion = sobre100;

    }

    public boolean getPuntuacion(){
       return puntuacion;
    }


}
