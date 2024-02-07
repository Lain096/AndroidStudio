package dl.pmdm.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RatingBar;

public class ActivityFragment extends AppCompatActivity  {



    FragmentInfo.interfaceFragmento fragmento;
    ConstraintLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Intent intentMain = getIntent();
        Bundle bundle = intentMain.getExtras();

//        Pelicula peli = (Pelicula)intentMain.getSerializableExtra("peli");
//
//        String pelicula = intentMain.getExtras().getString("pelicula");
       // Integer posicion = intentMain.getExtras().getInt("pos");

//       // Fragment fragment = FragmentInfo.newInstance(peli, posicion);
//        Fragment fragment = FragmentInfo.newInstance(peli);
//       // Fragment fragment = FragmentInfo.newInstance(pelicula, posicion);
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();

        layout = findViewById(R.id.constraintActivity);

        SharedPreferences prefs = getSharedPreferences("file_fondo", Context.MODE_PRIVATE);
        int color = prefs.getInt("color", R.color.blueblack);
        layout.setBackgroundColor(ContextCompat.getColor(this, color));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, FragmentInfo.class, bundle)
                .commit();

//        ft.replace(R.id.fragmentContainerView, fragment);
//        ft.commit();

    }




}