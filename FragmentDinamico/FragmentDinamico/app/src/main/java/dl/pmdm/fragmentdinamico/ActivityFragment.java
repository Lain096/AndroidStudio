package dl.pmdm.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;

public class ActivityFragment extends AppCompatActivity  {



    FragmentInfo.interfaceFragmento fragmento;
    String pelicula;
    Intent intentMain;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        intentMain = getIntent();

        if(intentMain.hasExtra("bojack")){
            pelicula = "bojack";
        }

        if(intentMain.hasExtra("brian")){
            pelicula = "brian";
        }

        if(intentMain.hasExtra("dragon")){
            pelicula = "dragon";
        }

        if(intentMain.hasExtra("aterriza")){
            pelicula = "aterriza";
        }

        fragment = FragmentInfo.newInstance(pelicula);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragmentContainerView2, fragment);
        ft.commit();




    }

}