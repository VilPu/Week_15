package com.example.week15;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView txtItem, txtInfo;
    EditText etItem, etInfo;
    ImageButton btnEdit, btnDelete;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        txtItem = itemView.findViewById(R.id.txtItem);
        txtInfo = itemView.findViewById(R.id.txtInfo);
        etItem = itemView.findViewById(R.id.etItem);
        etInfo = itemView.findViewById(R.id.etInfo);

        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnDelete = itemView.findViewById(R.id.btnDelete);


    }
}
