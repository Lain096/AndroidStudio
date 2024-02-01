package dl.pmdm.fragmentdinamico;

import android.graphics.drawable.Drawable;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pelicula implements Serializable {

    private String titulo, sinopsis, codigo;
    private int imagen;
    private Float ratingScore = null;
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

    public void addListaDirectores(List<String> listaDir) {directores.addAll(listaDir);}

    public void addListaActores(List<String> listaActores) {actores.addAll(listaActores);}

    public ArrayList<String> getDirectores() {
        return directores;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setRating(Float rating) {
        this.ratingScore = rating; }

    public Float getRating() {
        return ratingScore; }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
