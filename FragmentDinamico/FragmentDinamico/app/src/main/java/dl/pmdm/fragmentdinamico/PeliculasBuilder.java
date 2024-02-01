package dl.pmdm.fragmentdinamico;

import java.util.ArrayList;
import java.util.Arrays;
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
        crearPelicula5();
        crearPelicula6();
        crearPelicula7();
        crearPelicula8();
        crearPelicula9();
        crearPelicula10();

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

    private void crearPelicula5(){

        Pelicula p = new Pelicula();

        p.setImagen(R.drawable.secreto);
        p.setSinopsis("Una sátira sobre las películas de espías, en la cual una estrella de rock se ve envuelta en una red de espionaje.");
        p.setCodigo("secreto");
        p.setTitulo("Top Secret!");
        p.addListaDirectores(new ArrayList<String>(Arrays.asList("Jim Abrahams",
                "David Zucker",
                "Jerry Zucker")));
        p.addListaActores(new ArrayList<>(Arrays.asList("Val Kilmer",
                        "Lucy Gutteridge",
                        "Omar Sharif",
                        "Peter Cushing",
                        "Michael Gough",
                        "Jeremy Kemp",
                        "Christopher Villiers"))
               );

        listaPelis.add(p);


    }

    private void crearPelicula6(){
        Pelicula p = new Pelicula();

        p.setImagen(R.drawable.bruno);
        p.setTitulo("Brüno");
        p.setCodigo("bruno");
        p.setSinopsis("Brüno es un gay algo excéntrico que está obsesionado con la moda y el culto al cuerpo. Trabaja en la televisión, presentando un programa nocturno de tendencias, pero su sueño es llegar a ser una celebridad. Su estrategia para conseguirlo está clara: convertirse en reportero de moda y asistir a las fiestas y desfiles de los diseñadores más importantes. Así es como Brüno inicia un viaje por lo largo y ancho del mundo con la esperanza de encontrar la fama y, por qué no decirlo, también el amor.");
        p.addListaActores(new ArrayList<>(Arrays.asList("Sacha Baron Cohen",
                "Gustaf Hammarsten",
                "Clifford Bañagale",
                "Chibundu Orukwowu y Chigozie Orukwowu",
                "Josh Meyers",
                "Toby Hoguin", "Roberto Clatza Alvarez", "Gilbert Rosales", "Thomas Rosales Jr." , "Marco Xavier",
                "Bono",
                "Sting",
                "Slash",
                "Snoop Dogg",
                "Elton John",
                "Chris Martin")));

        p.addListaDirectores(new ArrayList<>(Arrays.asList("Larry Charles")));
        listaPelis.add(p);

    }

    public void crearPelicula7(){
        Pelicula p = new Pelicula();

        p.setTitulo("Starship Troopers");
        p.setSinopsis("En una sociedad futura, se arenga a los estudiantes para que se alisten en el ejército y se conviertan en ciudadanos. Johnny Rico se alista para seguir a su novia, pero acabará participando en una cruenta guerra contra los insectos del planeta Klendathu, tras la muerte de sus padres, a causa de un meteoro lanzado por esos insectos contra su ciudad natal.");
        p.setCodigo("trooper");
        p.setImagen(R.drawable.trooper);
        p.addListaDirectores(new ArrayList<>(Arrays.asList("Paul Verhoeven")));
        p.addListaActores(new ArrayList<>(Arrays.asList("Casper Van Dien",
                "Dina Meyer",
                "Dina Meyer",
                "Denise Richards",
                "Denise Richards",
                "Clancy Brown",
                "Clancy Brown",
                "Jake Busey",
                "Jake Busey",
                "Dean Norris",
                "Dean Norris",
                "Neil Patrick Harris",
                "Neil Patrick Harris",
                "Michael Ironside",
                "Michael Ironside")));
        listaPelis.add(p);

    }

    public void crearPelicula8(){

        Pelicula p = new Pelicula();

        p.setTitulo("Agárralo como puedas");
        p.setCodigo("pistola");
        p.setSinopsis("Tras quedar gravemente herido su compañero Nordberg en un tiroteo protagonizado por una banda de narcotraficantes, el incompetente teniente Frank Drebin busca al jefe de la organización para vengarse. Sospecha del magnate naviero Vincent Ludwig, pero no tiene pruebas para inculparlo. Sin embargo, de manera inesperada, consigue la ayuda de Jane Spencer, la asistente de Ludwig.");
        p.setImagen(R.drawable.pistola);
        p.addListaActores(new ArrayList<>(Arrays.asList("Leslie Nielsen",
                "Priscila Presley",
                "George Kennedy",
                "Ricardo Montalbán",
                "O.J. Simpson",
                "John Houseman",
                "Nancy Marchand",
                "Susan Beaubian")));
        p.addListaDirectores(new ArrayList<>(Arrays.asList("David Zucker")));
        listaPelis.add(p);
    }

    public void crearPelicula10(){

        Pelicula p = new Pelicula();

        p.setTitulo("La fiesta de las salchichas");
        p.setSinopsis("Todos los alimentos del supermercado ansían ser elegidos por los humanos e ir a la tierra prometida. Sin embargo, Frank, la salchicha, descubre el horrible destino que les espera a todos: ser comidos. Tras avisar a sus compañeros, idea un plan para escapar.");
        p.setCodigo("salchicha");
        p.setImagen(R.drawable.salchicha);
        p.addListaActores(new ArrayList<>(Arrays.asList("Seth Rogen",
                "Kristen Wiig",
                "Nick Kroll",
                "Michael Cera",
                "Jonah Hill",
                "Edward Norton",
                "David Krumholtz",
                "Danny McBride",
                "Salma Hayek")));
        p.addListaDirectores(new ArrayList<>(Arrays.asList("Conrad Vernon",
                "Greg Tiernan")));
        listaPelis.add(p);

    }

    public void crearPelicula9(){

        Pelicula p = new Pelicula();
        p.setTitulo("Ted");
        p.setCodigo("ted");
        p.setSinopsis("John Bennett y su oso de peluche Ted han sido siempre inseparables, pero su amistad se pondrá a prueba cuando Lori, la novia de John de cuatro años, pida más de su relación.");
        p.setImagen(R.drawable.ted);
        p.addListaActores(new ArrayList<>(Arrays.asList("Mark Wahlberg",
                "Mila Kunis",
                "Joel McHale",
                "Giovanni Ribisi",
                "Patrick Warburton",
                "Matt Walsh",
                "Jessica Barth",
                "Aedin Mincks")));
        p.addListaDirectores(new ArrayList<>(Arrays.asList("Seth MacFarlane")));
        listaPelis.add(p);

    }



}
