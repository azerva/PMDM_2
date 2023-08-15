package zerva.morneo.alexandre.squashedjuice.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import zerva.morneo.alexandre.squashedjuice.R;
import zerva.morneo.alexandre.squashedjuice.entidades.Snacks;

public class SnacksAdapter extends RecyclerView.Adapter<SnacksAdapter.VH> {

    ArrayList<Snacks>snacksList;

    public SnacksAdapter(ArrayList<Snacks> snacksList) {
        this.snacksList = snacksList;
    }
    onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClickListener(int position);
    }
    public void setOnitemClickListener(onItemClickListener listener){
        this.listener = listener;
    }



    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo,parent,false);
        return new VH(v,listener,snacksList);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Snacks s = snacksList.get(position);
        holder.img.setImageResource(s.getImg_snack());
        holder.nombreZumo.setText(s.getNombreSnack());
        holder.precio.setText(String.valueOf(s.getPrecioSnack())+" €");
        holder.cantidad.setText(String.valueOf(s.getCantidadSnack()));
    }

    @Override
    public int getItemCount() {
        return this.snacksList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView precio,nombreZumo,cantidad;
        Context context;
        ImageButton agregar;
        public VH(@NonNull View itemView,onItemClickListener listener,ArrayList<Snacks>snacks) {
            super(itemView);
            context = itemView.getContext();
            img = itemView.findViewById(R.id.imagen);
            nombreZumo = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);
            cantidad = itemView.findViewById(R.id.cantidad);
            agregar = itemView.findViewById(R.id.btn_agergar);

            agregar.setOnClickListener(v -> {
                snacks.get(getAdapterPosition()).getCantidadSnack();
                if (listener != null){
                    snacks.get(getAdapterPosition()).setCantidadSnack(snacks.get(getAdapterPosition()).getCantidadSnack()+1);
                    listener.onItemClickListener(getAdapterPosition());
                }
            });
        }

    }
}
