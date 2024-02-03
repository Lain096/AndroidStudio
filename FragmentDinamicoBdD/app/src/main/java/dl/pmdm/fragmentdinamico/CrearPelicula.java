package dl.pmdm.fragmentdinamico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrearPelicula extends AppCompatActivity {

private View contenedor;
    private SharedPreferences prefs;
    private EditText titulo, sinopsis, director, actores;
    private Button btnGuardar, btnBuscarImagen;
    private ImageView imgCrearPelicula;
    private boolean isComplet = false;
    private final int CODIGO_FOTO = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pelicula);

        contenedor = findViewById(R.id.contenedorCrearPelicula);
        prefs = getSharedPreferences("file_fondo", MODE_PRIVATE);
        contenedor.setBackgroundColor(ContextCompat.getColor(this, prefs.getInt("color", R.color.white)));

        titulo = findViewById(R.id.txtTitulo);
        sinopsis = findViewById(R.id.txtSinopsis);
        director = findViewById(R.id.txtDirectores);
        actores = findViewById(R.id.txtActores);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnBuscarImagen = findViewById(R.id.btnBuscarImagen);
        imgCrearPelicula = findViewById(R.id.imgCrearPelicula);




        btnBuscarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent galeria = new Intent(Intent.ACTION_PICK);
                galeria.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galeria, CODIGO_FOTO);


            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPelicula();
            }
        });







    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == CODIGO_FOTO){
                imgCrearPelicula.setImageURI(data.getData());
            }

        }

    }

    public void guardarPelicula(){

    boolean existe = false;


        for (Pelicula p:  PeliculasBuilder.getListaPelisDB(MainActivity.contexto)){

            if(p.getCodigo().equals(titulo.getText().toString().trim())){
                existe = true;
            }
        }

        if(!existe){
            Pelicula peli = new Pelicula();
            peli.setTitulo(titulo.getText().toString());
            peli.setCodigo(titulo.getText().toString().trim());
            peli.setSinopsis(sinopsis.getText().toString());
            peli.addListaDirectores(new ArrayList<>(Arrays.asList(director.getText().toString())));
            peli.addListaActores( new ArrayList<>(Arrays.asList(actores.getText().toString())));


            PeliculasBuilder.insertPelicula(peli);

            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();

        } else{
            Toast.makeText(this, "La película ya existe", Toast.LENGTH_SHORT).show();
        }



    }

}