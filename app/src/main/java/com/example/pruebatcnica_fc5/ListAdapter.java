package com.example.pruebatcnica_fc5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{

    private Context context;
    private List<Contacto> listContacto;
    private LayoutInflater mInflater;

    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener = clickListener;
    }

    public ListAdapter(List<Contacto> listContacto, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listContacto = listContacto;
    }

    @Override
    public int getItemCount()
    {
        return listContacto.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.info_contactos, null);
        return new ListAdapter.ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position)
    {
        holder.binData(listContacto.get(position));
    }

    public void setItems(List<Contacto> items)
    {
        listContacto = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView nombre, apellido, celular, parentesco, numero;
        ImageView eliminar;

        ViewHolder(View itemView, OnItemClickListener listener)
        {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombre);
            apellido = itemView.findViewById(R.id.txtApellido);
            celular = itemView.findViewById(R.id.txtCelular);
            parentesco = itemView.findViewById(R.id.txtParentesco);
            numero = itemView.findViewById(R.id.txtNum);
            eliminar = itemView.findViewById(R.id.btnEliminar);

            eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

        void binData(final Contacto item)
        {
            nombre.setText(item.getNombre());
            apellido.setText(item.getApellido());
            celular.setText("Celular: "+item.getCelular());
            parentesco.setText("Parentesco: "+item.getParentesco());
            numero.setText("Num. Telefono: "+item.getNumero());
        }
    }

}
