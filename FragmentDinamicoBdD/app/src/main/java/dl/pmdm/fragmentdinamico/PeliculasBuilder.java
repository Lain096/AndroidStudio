package dl.pmdm.fragmentdinamico;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeliculasBuilder {

     private static Pelicula pelicula;
     private static PeliculasBuilder crear;
//    public static void crearPeliculas() {
//
//
//            crear = new PeliculasBuilder();
//    }
//
//    public static PeliculasBuilder getPeliculas(){
//        if (crear == null) {
//
//           crearPeliculas();
//
//        }
//
//        return crear;
//    }



    public static List<Pelicula> getListaPelisDB(Context contexto){
        List<Pelicula> list = new ArrayList<>();
        PeliculasHelper peliH = new PeliculasHelper(contexto);
        SQLiteDatabase db = peliH.getReadableDatabase();

        Cursor cs = db.rawQuery("SELECT * FROM PELICULAS", null);

        while(cs.moveToNext()){
            pelicula = new Pelicula();

            pelicula.setTitulo(cs.getString(cs.getColumnIndex("title")));
            pelicula.setCodigo(cs.getString(cs.getColumnIndex("code")));
            pelicula.setSinopsis(cs.getString(cs.getColumnIndex("sinopsis")));
            pelicula.addDirectores(cs.getString(cs.getColumnIndex("director")));
            pelicula.addActores(cs.getString(cs.getColumnIndex("casting")));



            if(!cs.isNull(cs.getColumnIndex("ratingScore"))){

            pelicula.setRating(cs.getFloat((cs.getColumnIndex("ratingScore"))));
            } else{
                pelicula.setRating(null);
            }

            Integer i = cs.getColumnIndex("watched");
            int value = 0;
            if(i != -1){
                value = cs.getInt(i);
            }

            if(value == 0){
                pelicula.setEsVista(false);
            } else{
                pelicula.setEsVista(true);
            }

            list.add(pelicula);

        }

        return list;
    }

    public static void insertPelicula(Pelicula peli){
        PeliculasHelper peliH = new PeliculasHelper(MainActivity.contexto);
        SQLiteDatabase db = peliH.getWritableDatabase();

        String sql = "INSERT INTO PELICULAS (title, code, sinopsis, director, casting, watched) VALUES " +
                "('" + peli.getTitulo() + "', '" + peli.getCodigo() + "', '" + peli.getSinopsis() + "', '" + peli.getDirectores() + "', '" + peli.getActores().get(0) + "', " +  "0" + ")";
        db.execSQL(sql);
    }

    public static void eliminarPelicula(Pelicula peli){

        PeliculasHelper peliH = new PeliculasHelper(MainActivity.contexto);
        SQLiteDatabase db = peliH.getWritableDatabase();

        String sql = "DELETE FROM PELICULAS WHERE code = '" + peli.getCodigo() + "'";
        db.execSQL(sql);
    }

    public static void modificarRatingPelicula(Pelicula peli, float valor) {

        PeliculasHelper ph = new PeliculasHelper(MainActivity.contexto);

        SQLiteDatabase sb = ph.getWritableDatabase();

        sb.execSQL("UPDATE PELICULAS " +
                "SET ratingScore = " + valor +
                " WHERE code LIKE '" + peli.getCodigo() + "'");


    }

    public static void modificarVistaPelicula(Pelicula peli, boolean vista) {

        PeliculasHelper ph = new PeliculasHelper(MainActivity.contexto);

        SQLiteDatabase sb = ph.getWritableDatabase();

        int valor = 0;

        if (vista) {
            valor = 1;
        }

        sb.execSQL("UPDATE PELICULAS " +
                "SET watched = " + valor +
                " WHERE code LIKE '" + peli.getCodigo() + "'");


    }



}
