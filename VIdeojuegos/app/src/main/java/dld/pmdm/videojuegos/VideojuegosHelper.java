package dld.pmdm.videojuegos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VideojuegosHelper extends SQLiteOpenHelper {


    public VideojuegosHelper(@Nullable Context context) {
        super(context, "Videojuegos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE VIDEOJUEGOS (name TEXT, ano INTEGER, description TEXT, tipo TEXT, numJugadores INTEGER)");


        db.execSQL("INSERT INTO VIDEOJUEGOS (name, ano, description, tipo, numJugadores) VALUES " +
                "('Super Aventura', 2022, 'Emocionante viaje en un mundo fantástico', 'Aventura', 1), " +
                "('Juego de Disparos', 2023, 'Combate intenso con gráficos asombrosos', 'Disparos', 4), " +
                "('Simulador de Construcción', 2021, 'Construye tu propio imperio desde cero', 'Simulación', 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
