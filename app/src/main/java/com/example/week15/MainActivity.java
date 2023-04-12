package com.example.week15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.sql.Date;
import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private ItemAdapter itemAdapter = new ItemAdapter(this, ItemStorage.getInstance().getItems());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);

    }

    public void sortByTime(View view) {
        ItemStorage.getInstance().getItems().sort(Item.itemTimeComparator);
        itemAdapter.notifyDataSetChanged();
    }

    public void sortByAlphabet(View view) {
        ItemStorage.getInstance().getItems().sort(Item.itemAlphabetComparator);
        itemAdapter.notifyDataSetChanged();
    }
    public void addItem(View view) {
        ItemStorage.getInstance().addItem(new Item(null, null, Date.from(Instant.now())));
        itemAdapter.notifyDataSetChanged();
    }


}