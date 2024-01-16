package dl.pmdm.fragmentdinamico;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.net.URI;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {


    private List<Pelicula> listaPelis;


    public PeliculaAdapter (List<Pelicula>listaPelis){

        this.listaPelis = listaPelis;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pelis_recycler_layout, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Pelicula peli = listaPelis.get(position);

        ((TextView)holder.itemView.findViewById(R.id.txtTituloPeli)).setText(peli.getTitulo());
        ((TextView)holder.itemView.findViewById(R.id.idSinopsisPeli)).setText(peli.getSinopsis());
        ((ImageView)holder.itemView.findViewById(R.id.imgPeli)).setImageResource(peli.getImagen());
        //((ImageView)holder.itemView.findViewById(R.id.imgPeli)).setImageURI(Uri.parse("android.resource://drawable/aterriza.jpg"));
        ((RatingBar)holder.itemView.findViewById(R.id.ratingPeli)).setRating(peli.getRating());
        ((TextView)holder.itemView.findViewById(R.id.txtRatingPeli)).setText(String.valueOf(peli.getRating()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.contexto, ActivityFragment.class);
                Bundle bundle = new Bundle();

                bundle.putString("pelicula", peli.getCodigo());
                bundle.putInt("pos", position);

                intent.putExtras(bundle);

                MainActivity.contexto.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return listaPelis.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //
//            TextView titulo = itemView.findViewById(R.id.txtTituloPeli);
//            TextView sinopsis = itemView.findViewById(R.id.idSinopsisPeli);
//            ImageView img = itemView.findViewById(R.id.imgPeli);
//            RatingBar ratingBar = itemView.findViewById(R.id.ratingPeli);
//            TextView txtRating = itemView.findViewById(R.id.txtRatingPeli);

        }
    }



}
