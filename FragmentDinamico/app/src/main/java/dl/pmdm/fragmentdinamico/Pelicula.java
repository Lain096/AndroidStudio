package dl.pmdm.fragmentdinamico;

import android.graphics.drawable.Drawable;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {

    private String titulo, sinopsis, codigo;
    private int imagen;
    private float ratingScore = 0;
    private ArrayList<String> directores;
    private ArrayList<String> actores;


    public Pelicula() {
        directores = new ArrayList<>();
        actores = new ArrayList<>();
    }

    public void setImagen(int img) {
        imagen = img;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void addActores(String actor) {
        actores.add(actor);
    }

    public void addDirectores(String director) {
        directores.add(director);
    }

    public ArrayList<String> getDirectores() {
        return directores;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setRating(float rating) {
        this.ratingScore = rating; }

    public float getRating() {
        return ratingScore; }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
