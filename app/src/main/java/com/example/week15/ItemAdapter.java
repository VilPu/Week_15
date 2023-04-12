package com.example.week15;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;

    private ArrayList<Item> items = new ArrayList<>();


    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.txtItem.setText(items.get(position).getName());
        holder.txtInfo.setText(items.get(position).getInfo());
        holder.btnEdit.setImageResource(R.drawable.editlogo);
        holder.btnDelete.setImageResource(R.drawable.deletelogo);

        holder.btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int index = holder.getAdapterPosition();
                ItemStorage.getInstance().deleteItemByIndex(index);
                notifyItemRemoved(index);
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int index = holder.getAdapterPosition();

                if (holder.etItem.getVisibility() == View.VISIBLE) {
                    ItemStorage.getInstance().getItemByIndex(index).setName(holder.etItem.getText().toString());
                    ItemStorage.getInstance().getItemByIndex(index).setInfo(holder.etInfo.getText().toString());

                    holder.txtItem.setText(ItemStorage.getInstance().getItemByIndex(index).getName());
                    holder.txtInfo.setText(ItemStorage.getInstance().getItemByIndex(index).getInfo());
                    holder.etItem.setVisibility(View.GONE);
                    holder.etInfo.setVisibility(View.GONE);
                } else {
                    holder.etItem.setText(ItemStorage.getInstance().getItemByIndex(index).getName());
                    holder.etInfo.setText(ItemStorage.getInstance().getItemByIndex(index).getInfo());
                    holder.etItem.setVisibility(View.VISIBLE);
                    holder.etInfo.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
