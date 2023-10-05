package com.example.lanchonetebes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recyclerView_items);

        // List list = Arrays.asList("Suco de Laranja", "X-Búrguer", "Pizza de Atum", "Refrigerante Zero", "Brigadeirão", "Açaí com Banana");

        List<Produto> lista = new ArrayList<>();

//        for(int i = 0; i < 10; i++) {
//            lista.add(new Produto("Produto "+i, "Descricao "+i, BigDecimal.TEN, "enderecoDaImagem"));
//        }

        Gson gson = new Gson();
        String json = gson.toJson(lista);

        // System.out.println(json);

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardapioService service = retrofit.create(CardapioService.class);

        Call<List<Produto>> produtos = service.produtos();

        final ItemAdapter adapter = new ItemAdapter(this, lista);

        produtos.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                for (Produto produto : response.body()) {
                    adapter.add(produto);
                }
                response.isSuccessful();
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                Log.d("TAG", "onFailure");
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}