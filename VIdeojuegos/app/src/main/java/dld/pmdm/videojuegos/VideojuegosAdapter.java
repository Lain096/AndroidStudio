package dld.pmdm.videojuegos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideojuegosAdapter extends RecyclerView.Adapter<VideojuegosAdapter.ViewHolder> {

    private List<Videojuego> listaVideojuegos;
    private Context context;


    public VideojuegosAdapter(Context context, List<Videojuego> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VideojuegosAdapter.ViewHolder holder, int position) {


        holder.titulo.setText(listaVideojuegos.get(position).getName());
        holder.numJugadores.setText(String.valueOf(listaVideojuegos.get(position).getNumJugadores()));
        holder.tipo.setText(listaVideojuegos.get(position).getTipo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                androidx.fragment.app.FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                bundle.putSerializable("videojuego", listaVideojuegos.get(position));

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, DatosVideojuego.class, bundle)
                        .commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        if (listaVideojuegos.size() == 0) {
            return 0;
        } else {
            return listaVideojuegos.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView numJugadores;
        private TextView tipo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tituloMostrar);
            numJugadores = itemView.findViewById(R.id.numJugadoresMostrar);
            tipo = itemView.findViewById(R.id.tipoMostrar);

        }
    }
}
