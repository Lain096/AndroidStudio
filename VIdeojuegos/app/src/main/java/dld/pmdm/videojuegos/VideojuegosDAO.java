package dld.pmdm.videojuegos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class VideojuegosDAO {


    public VideojuegosDAO(){

    }
    public List<Videojuego> getVideojuegos(Context contexto){

        List<Videojuego> lista = new ArrayList<>();

        VideojuegosHelper videojuegosHelper = new VideojuegosHelper(contexto);

        SQLiteDatabase db = videojuegosHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM VIDEOJUEGOS", null);


        if(cs.getCount()==0){
            return null;
        } else {


            while (cs.moveToNext()) {
                Videojuego videojuego = new Videojuego();
                videojuego.setName(cs.getString(cs.getColumnIndex("name")));
                videojuego.setAno(cs.getInt(cs.getColumnIndex("ano")));
                videojuego.setDescription(cs.getString(cs.getColumnIndex("description")));
                videojuego.setTipo(cs.getString(cs.getColumnIndex("tipo")));
                videojuego.setNumJugadores(cs.getInt(cs.getColumnIndex("numJugadores")));
                lista.add(videojuego);
            }

        }

        return lista;

    }


    public void insertVideojuego(Context contexto, Videojuego videojuego){
        VideojuegosHelper videojuegosHelper = new VideojuegosHelper(contexto);
        SQLiteDatabase db = videojuegosHelper.getWritableDatabase();
        db.execSQL("INSERT INTO VIDEOJUEGOS (name, ano, description, tipo, numJugadores) VALUES ('"+videojuego.getName()+"', '"+videojuego.getAno()+"', '"+videojuego.getDescription()+"', '"+videojuego.getTipo()+"', '"+videojuego.getNumJugadores()+"')");
    }

    public void eliminarVideojuego(Context contexto, String nombre){
        VideojuegosHelper videojuegosHelper = new VideojuegosHelper(contexto);
        SQLiteDatabase db = videojuegosHelper.getWritableDatabase();
        db.execSQL("DELETE FROM VIDEOJUEGOS WHERE name = '"+nombre+"'");
    }

    public void modificarVideojuego(Context contexto, Videojuego videojuego, String tituloAntiguo){
        VideojuegosHelper videojuegosHelper = new VideojuegosHelper(contexto);
        SQLiteDatabase db = videojuegosHelper.getWritableDatabase();
        db.execSQL("UPDATE VIDEOJUEGOS SET ano = '"+videojuego.getAno()+"', description = '"+videojuego.getDescription()+"', tipo = '"+videojuego.getTipo()+"', numJugadores = '"+videojuego.getNumJugadores()+"' WHERE name = '"+tituloAntiguo+"'");
    }


}
