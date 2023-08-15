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
import java.util.List;

import zerva.morneo.alexandre.squashedjuice.R;
import zerva.morneo.alexandre.squashedjuice.entidades.Zumo;

public class ZumoAdapter extends RecyclerView.Adapter<ZumoAdapter.VH> {

    ArrayList<Zumo> zumoList;

    public ZumoAdapter(ArrayList<Zumo> zumoList) {
        this.zumoList = zumoList;
    }

    onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClickListener(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo,parent,false);
        return new VH(v,listener,zumoList);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Zumo z = zumoList.get(position);
        holder.img.setImageResource(z.getImg_zumo());
        holder.nombreZumo.setText(z.getNombreZumo());
        holder.precio.setText(String.format("%.2f",z.getPrecioZumo())+" €");
        holder.cantidad.setText(String.format("%d",z.getCantidadZumo()));


    }

    @Override
    public int getItemCount() {
        return this.zumoList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView precio,nombreZumo,cantidad;
        Context context;
        ImageButton agregar;
        public VH(@NonNull View itemView, onItemClickListener listener, ArrayList<Zumo> zumos) {
            super(itemView);
            context = itemView.getContext();
            img = itemView.findViewById(R.id.imagen);
            nombreZumo = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);
            cantidad = itemView.findViewById(R.id.cantidad);
            agregar = itemView.findViewById(R.id.btn_agergar);

            agregar.setOnClickListener(v -> {
                zumos.get(getAdapterPosition()).getCantidadZumo();
                if (listener != null){
                    zumos.get(getAdapterPosition()).setCantidadZumo(zumos.get(getAdapterPosition()).getCantidadZumo()+1);
                    listener.onItemClickListener(getAdapterPosition());
                }
            });

        }

    }
}
