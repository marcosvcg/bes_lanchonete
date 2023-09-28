package com.example.lanchonetebes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recyclerView_items);

        // List list = Arrays.asList("Suco de Laranja", "X-Búrguer", "Pizza de Atum", "Refrigerante Zero", "Brigadeirão", "Açaí com Banana");

        List<Produto> lista = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            lista.add(new Produto("Produto "+i, "Descricao "+i, BigDecimal.TEN, "enderecoDaImagem"));
        }

        Gson gson = new Gson();
        String json = gson.toJson(lista);

        // System.out.println(json);

        RecyclerView.Adapter adapter = new ItemAdapter(this, lista);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}