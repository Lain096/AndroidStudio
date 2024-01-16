package dl.pmdm.fragmentdinamico;

import java.util.ArrayList;
import java.util.List;

public class PeliculasBuilder {

     private Pelicula pelicula;

    private static PeliculasBuilder crear;

    private static List<Pelicula> listaPelis;

    public PeliculasBuilder() {
        crearPelicula1();
        crearPelicula2();
        crearPelicula3();
        crearPelicula4();
    }

    public static void crearPeliculas() {

            listaPelis = new ArrayList<>();
            crear = new PeliculasBuilder();
    }

    public static PeliculasBuilder getPeliculas(){
        if (crear == null) {

           crearPeliculas();

        }

        return crear;
    }

    public static List<Pelicula> getListaPelis() {
        return listaPelis;
    }

    private void crearPelicula1(){

        pelicula = new Pelicula();

        pelicula.setCodigo("bojack");
        pelicula.setTitulo("Bojack Horseman");
        pelicula.setSinopsis("'BoJack Horseman' gira en torno a un caballo humanoide BoJack que bebe whisky sin parar (Will Arnett) y que se ocupa de sus crisis personales con la ayuda de su compañero humano Todd (Aaron Paul) y el agente y examante felino Princess Caroline (Amy Sedaris)");
        pelicula.setImagen(R.drawable.bojack);
        pelicula.addDirectores("Raphael Bob-Waksberg");
        pelicula.addActores("Will Arnett");
        pelicula.addActores("Aaron Paul");
        pelicula.addActores("Amy Sedaris");
        pelicula.addActores("Alison Brie");
        pelicula.addActores("Paul F.Tompkins");
        pelicula.addActores("J. K. Simmons");
        pelicula.addActores("Kristen Schaal");
        listaPelis.add(pelicula);
    }

    private void crearPelicula2(){
        pelicula = new Pelicula();
        pelicula.setCodigo("brian");
        pelicula.setTitulo("La vida de Brian");
        pelicula.setSinopsis("Durante la época bíblica, un hombre parece ser el Mesías y se ve puesto como líder de un movimiento religioso. Su vida estará marcada por su castrante madre, sus nuevos amigos del Frente Popular de Judea y su novia feminista.");
        pelicula.setImagen(R.drawable.brian);
        pelicula.addDirectores("Terry Jones");
        pelicula.addActores("Graham Chapman");
        pelicula.addActores("Terry Gilliam");
        pelicula.addActores("John Cleese");
        pelicula.addActores("Michael Palin");
        pelicula.addActores("Eric idle");
        pelicula.addActores("Terry Jones");
        pelicula.addActores("George Harrison");
        pelicula.addActores("Spike Milligan");
        listaPelis.add(pelicula);
    }

    private void crearPelicula3(){
        pelicula = new Pelicula();

        pelicula.setTitulo("Como entrenar a tu dragón");
        pelicula.setCodigo("dragon");
        pelicula.setSinopsis("Hipo, un vikingo adolescente, comienza las clases de entrenamiento con dragones, y ve por fin una oportunidad para demostrar que es capaz de convertirse en guerrero, cuando hace amistad con un dragón herido.");
        pelicula.setImagen(R.drawable.dragon);
        pelicula.addDirectores("Dean DeBlois");
        pelicula.addDirectores("Chris Sanders");
        pelicula.addActores("Jay Baruchel");
        pelicula.addActores("America Ferrera");
        pelicula.addActores("Gerard Butler");
        pelicula.addActores("Jonah Hill");
        pelicula.addActores("Kristen Wiig");
        pelicula.addActores("T. J. Miller");
        pelicula.addActores("Christopher Mintz-Plasse");
        pelicula.addActores("Craig Ferguson");
        listaPelis.add(pelicula);
    }

    private void crearPelicula4(){
        pelicula = new Pelicula();

        pelicula.setTitulo("Aterriza como puedas");
        pelicula.setCodigo("aterriza");
        pelicula.setSinopsis("Durante un vuelo de Los Angeles a Chicago, gran parte de la tripulación de un avión comercial, incluyendo a los dos pilotos, cae gravemente enferma a consecuencia de una intoxicación alimentaria.");
        pelicula.setImagen(R.drawable.aterriza);
        pelicula.addDirectores("Jim Abrahams");
        pelicula.addDirectores("David Zucker");
        pelicula.addDirectores(" Jerry Zucker");
        pelicula.addActores("Robert Hays");
        pelicula.addActores("Julie Hagerty");
        pelicula.addActores("Leslie Nielsen");
        pelicula.addActores("Robert Stack");
        pelicula.addActores("Lloyd Bridges");
        pelicula.addActores("Peter Graves");
        pelicula.addActores("Kareem Abdul-Jabbar y Lorna Patterson");
        listaPelis.add(pelicula);
    }


}
