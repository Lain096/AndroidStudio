package dl.pmdm.fragmentdinamico;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// El ORM utilizado por AndroidStudio es Room
public class PeliculasHelper extends SQLiteOpenHelper {

    private Context context;

    public PeliculasHelper(@Nullable Context context) {
        super(context, "peliculas.db", null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE PELICULAS ( " +
                "code TEXT PRIMARY KEY, " +
                "title TEXT NOT NULL, " +
                "IMG BLOB, "+
                "sinopsis TEXT NOT NULL, " +
                "ratingScore NUMERIC, " +
                "director TEXT NOT NULL, " +
                "casting TEXT NOT NULL,"+
                "watched INTEGER NOT NULL)");

        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('bojack', 'Bojack Horseman', 'BoJack Horseman gira en torno a un caballo humanoide BoJack que bebe whisky sin parar (Will Arnett) y que se ocupa de sus crisis personales con la ayuda de su compañero humano Todd (Aaron Paul) y el agente y examante felino Princess Caroline (Amy Sedaris)', 'Raphael Bob-Waksberg', 'Will Arnett, Aaron Paul, Amy Sedaris, Alison Brie, Paul F.Tompkins, J. K. Simmons, Kristen Schaal', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('brian', 'La vida de Brian', 'Durante la época bíblica, un hombre parece ser el Mesías y se ve puesto como líder de un movimiento religioso. Su vida estará marcada por su castrante madre, sus nuevos amigos del Frente Popular de Judea y su novia feminista.', 'Terry Jones', 'Graham Chapman, Terry Gilliam, John Cleese, Michael Palin, Eric idle, Terry Jones, George Harrison, Spike Milligan', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('dragon', 'Como entrenar a tu Dragón',  'Hipo, un vikingo adolescente, comienza las clases de entrenamiento con dragones, y ve por fin una oportunidad para demostrar que es capaz de convertirse en guerrero, cuando hace amistad con un dragón herido.', 'Chris Sanders, Dean DeBlois', 'Jay Baruchel, America Ferrera, Gerard Butler, Jonah Hill, Kristen Wiig, T. J. Miller, Christopher Mintz-Plasse, Craig Ferguson', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('aterriza', 'Aterriza como puedas',  'Durante un vuelo de Los Angeles a Chicago, gran parte de la tripulación de un avión comercial, incluyendo a los dos pilotos, cae gravemente enferma a consecuencia de una intoxicación alimentaria.', 'Jim Abrahams, David Zucker, Jerry Zucker', 'Robert Hays, Julie Hagerty, Leslie Nielsen, Robert Stack, Lloyd Bridges, Peter Graves, Kareem Abdul-Jabbar y Lorna Patterson', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('secreto', 'Top Secret!',  'Una sátira sobre las películas de espías, en la cual una estrella de rock se ve envuelta en una red de espionaje.', 'Jim Abrahams, David Zucker, Jerry Zucker', 'Val Kilmer, Lucy Gutteridge, Omar Sharif, Peter Cushing, Michael Gough, Jeremy Kemp, Christopher Villiers', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('bruno', 'Brüno',  'Brüno es un gay algo excéntrico que está obsesionado con la moda y el culto al cuerpo. Trabaja en la televisión, presentando un programa nocturno de tendencias, pero su sueño es llegar a ser una celebridad. Su estrategia para conseguirlo está clara: convertirse en reportero de moda y asistir a las fiestas y desfiles de los diseñadores más importantes. Así es como Brüno inicia un viaje por lo largo y ancho del mundo con la esperanza de encontrar la fama y, por qué no decirlo, también el amor.', 'Larry Charles', 'Sacha Baron Cohen, Gustaf Hammarsten, Clifford Bañagale, Chibundu Orukwowu y Chigozie Orukwowu, Josh Meyers, Toby Hoguin, Roberto Clatza Alvarez, Gilbert Rosales, Thomas Rosales Jr., Marco Xavier, Bono, Sting, Slash, Snoop Dogg, Elton John, Chris Martin','0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('trooper', 'Starship Troopers',  'En una sociedad futura, se arenga a los estudiantes para que se alisten en el ejército y se conviertan en ciudadanos. Johnny Rico se alista para seguir a su novia, pero acabará participando en una cruenta guerra contra los insectos del planeta Klendathu, tras la muerte de sus padres, a causa de un meteoro lanzado por esos insectos contra su ciudad natal.', 'Paul Verhoeven', 'Casper Van Dien, Dina Meyer, Denise Richards, Clancy Brown, Jake Busey, Dean Norris, Neil Patrick Harris, Michael Ironside', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('pistola', 'Agárralo como puedas',  'Tras quedar gravemente herido su compañero Nordberg en un tiroteo protagonizado por una banda de narcotraficantes, el incompetente teniente Frank Drebin busca al jefe de la organización para vengarse. Sospecha del magnate naviero Vincent Ludwig, pero no tiene pruebas para inculparlo. Sin embargo, de manera inesperada, consigue la ayuda de Jane Spencer, la asistente de Ludwig.', 'David Zucker', 'Leslie Nielsen, Priscila Presley, George Kennedy, Ricardo Montalbán, O.J. Simpson, John Houseman, Nancy Marchand, Susan Beaubian', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('salchicha', 'La fiesta de las salchichas',  'Todos los alimentos del supermercado ansían ser elegidos por los humanos e ir a la tierra prometida. Sin embargo, Frank, la salchicha, descubre el horrible destino que les espera a todos: ser comidos. Tras avisar a sus compañeros, idea un plan para escapar.', 'Conrad Vernon, Greg Tiernan', 'Seth Rogen, Kristen Wiig, Nick Kroll, Michael Cera, Jonah Hill, Edward Norton, David Krumholtz, Danny McBride, Salma Hayek', '0')");
        db.execSQL("INSERT INTO PELICULAS (code, title, sinopsis, director, casting, watched) VALUES('ted', 'Ted',  'John Bennett y su oso de peluche Ted han sido siempre inseparables, pero su amistad se pondrá a prueba cuando Lori, la novia de John de cuatro años, pida más de su relación.', 'Seth MacFarlane', 'Mark Wahlberg, Mila Kunis, Joel McHale, Giovanni Ribisi, Patrick Warburton, Matt Walsh, Jessica Barth, Aedin Mincks', '0')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
