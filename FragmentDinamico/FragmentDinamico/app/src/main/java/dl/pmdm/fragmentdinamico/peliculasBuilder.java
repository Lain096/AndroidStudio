package dl.pmdm.fragmentdinamico;

public class peliculasBuilder {

     private Pelicula pelicula1, pelicula2, pelicula3, pelicula4;

    private static peliculasBuilder crear;


    public peliculasBuilder() {
        crearPelicula1();
        crearPelicula2();
        crearPelicula3();
        crearPelicula4();

    }

    public static void crearPeliculas() {


            crear = new peliculasBuilder();


    }

    public static peliculasBuilder getPeliculas(){
        if (crear == null) {

           crearPeliculas();

        }

        return crear;
    }


    private void crearPelicula1(){

        pelicula1 = new Pelicula();

        pelicula1.setTitulo("Bojack Horseman");
        pelicula1.setSinopsis("'BoJack Horseman' gira en torno a un caballo humanoide BoJack que bebe whisky sin parar (Will Arnett) y que se ocupa de sus crisis personales con la ayuda de su compañero humano Todd (Aaron Paul) y el agente y examante felino Princess Caroline (Amy Sedaris)");
        pelicula1.setImagen(R.drawable.bojack);
        pelicula1.addDirectores("Raphael Bob-Waksberg");
        pelicula1.addActores("Will Arnett");
        pelicula1.addActores("Aaron Paul");
        pelicula1.addActores("Amy Sedaris");
        pelicula1.addActores("Alison Brie");
        pelicula1.addActores("Paul F.Tompkins");
        pelicula1.addActores("J. K. Simmons");
        pelicula1.addActores("Kristen Schaal");
    }

    private void crearPelicula2(){
        pelicula2 = new Pelicula();
        pelicula2.setTitulo("La vida de Brian");
        pelicula2.setSinopsis("Durante la época bíblica, un hombre parece ser el Mesías y se ve puesto como líder de un movimiento religioso. Su vida estará marcada por su castrante madre, sus nuevos amigos del Frente Popular de Judea y su novia feminista.");
        pelicula2.setImagen(R.drawable.brian);
        pelicula2.addDirectores("Terry Jones");
        pelicula2.addActores("Graham Chapman");
        pelicula2.addActores("Terry Gilliam");
        pelicula2.addActores("John Cleese");
        pelicula2.addActores("Michael Palin");
        pelicula2.addActores("Eric idle");
        pelicula2.addActores("Terry Jones");
        pelicula2.addActores("George Harrison");
        pelicula2.addActores("Spike Milligan");
    }

    private void crearPelicula3(){
        pelicula3 = new Pelicula();

        pelicula3.setTitulo("Como entrenar a tu dragón");
        pelicula3.setSinopsis("Hipo, un vikingo adolescente, comienza las clases de entrenamiento con dragones, y ve por fin una oportunidad para demostrar que es capaz de convertirse en guerrero, cuando hace amistad con un dragón herido.");
        pelicula3.setImagen(R.drawable.dragon);
        pelicula3.addDirectores("Dean DeBlois");
        pelicula3.addDirectores("Chris Sanders");
        pelicula3.addActores("Jay Baruchel");
        pelicula3.addActores("America Ferrera");
        pelicula3.addActores("Gerard Butler");
        pelicula3.addActores("Jonah Hill");
        pelicula3.addActores("Kristen Wiig");
        pelicula3.addActores("T. J. Miller");
        pelicula3.addActores("Christopher Mintz-Plasse");
        pelicula3.addActores("Craig Ferguson");
    }

    private void crearPelicula4(){
        pelicula4 = new Pelicula();

        pelicula4.setTitulo("Aterriza como puedas");
        pelicula4.setSinopsis("Durante un vuelo de Los Angeles a Chicago, gran parte de la tripulación de un avión comercial, incluyendo a los dos pilotos, cae gravemente enferma a consecuencia de una intoxicación alimentaria.");
        pelicula4.setImagen(R.drawable.aterriza);
        pelicula4.addDirectores("Jim Abrahams");
        pelicula4.addDirectores("David Zucker");
        pelicula4.addDirectores(" Jerry Zucker");
        pelicula4.addActores("Robert Hays");
        pelicula4.addActores("Julie Hagerty");
        pelicula4.addActores("Leslie Nielsen");
        pelicula4.addActores("Robert Stack");
        pelicula4.addActores("Lloyd Bridges");
        pelicula4.addActores("Peter Graves");
        pelicula4.addActores("Kareem Abdul-Jabbar y Lorna Patterson");
    }

    public Pelicula getPelicula1(){
        return pelicula1;
    }
    public Pelicula getPelicula2(){
        return pelicula2;
    }
    public Pelicula getPelicula3(){
        return pelicula3;
    }
    public Pelicula getPelicula4(){
        return pelicula4;
    }




}
