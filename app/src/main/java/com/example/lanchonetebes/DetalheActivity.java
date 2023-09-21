package com.example.lanchonetebes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Produto produto = (Produto) getIntent().getSerializableExtra("CHAVE");
        TextView textView = findViewById(R.id.detalhe_textView_nomeProduto);
        textView.setText(produto.getNome());

        ImageView imageView = findViewById(R.id.detalhe_imageView_imagem);
        Picasso.get().load("https://api.placid.app/u/qsraj?title[text]=Produto").into(imageView);
    }
}