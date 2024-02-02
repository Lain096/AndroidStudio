package dl.pmdm.fragmentdinamico;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {


    private List<Pelicula> listaPelis;
    private Boolean isTablet = false;
    private FragmentManager fm;


    public PeliculaAdapter (List<Pelicula>listaPelis, FragmentManager fragmento, Boolean isTablet){

        this.listaPelis = listaPelis;
        this.fm = fragmento;
        this.isTablet = isTablet;


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

            ((TextView) holder.itemView.findViewById(R.id.txtTituloPeli)).setText(peli.getTitulo());
            ((TextView) holder.itemView.findViewById(R.id.idSinopsisPeli)).setText(peli.getSinopsis());
          //  ((ImageView) holder.itemView.findViewById(R.id.imgPeli)).setImageResource(peli.getImagen());
            Context context = holder.itemView.getContext();
            ((ImageView)holder.itemView.findViewById(R.id.imgPeli)).setBackgroundResource(context.getResources().getIdentifier(peli.getCodigo(), "drawable", context.getPackageName()));
            ((RatingBar) holder.itemView.findViewById(R.id.ratingPeli)).setVisibility(View.GONE);


            if(peli.getRating() != null){
                ((RatingBar) holder.itemView.findViewById(R.id.ratingPeli)).setVisibility(View.VISIBLE);
                ((RatingBar) holder.itemView.findViewById(R.id.ratingPeli)).setRating(peli.getRating());

                ((TextView) holder.itemView.findViewById(R.id.txtRatingPeli)).setText(String.valueOf(peli.getRating()));
            } else{
                ((RatingBar) holder.itemView.findViewById(R.id.ratingPeli)).setVisibility(View.GONE);
            }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isTablet){

                   // Fragment fragment = FragmentInfo.newInstance(peli.getCodigo(), position);
                  //  Fragment fragment = FragmentInfo.newInstance(peli, position);
                    Fragment fragment = FragmentInfo.newInstance(peli);

                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentContainerViewTablet, fragment);
                    ft.commit();


                }else {

                    Intent intent = new Intent(MainActivity.contexto, ActivityFragment.class);
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("peli", peli);

                    bundle.putString("pelicula", peli.getCodigo());
                    bundle.putInt("pos", position);

                    intent.putExtras(bundle);

                    MainActivity.contexto.startActivity(intent);
                }

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
