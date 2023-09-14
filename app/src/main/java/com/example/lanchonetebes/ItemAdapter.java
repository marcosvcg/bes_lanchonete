package com.example.lanchonetebes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private List<Produto> lista;
    public ItemAdapter(Context context, List lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Produto produto = lista.get(position);
        holder.setTextView1(produto.getNome());
        holder.setTextView2(produto.getDescricao());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView1;
        private TextView textView2;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(this);
        }

        public void setTextView1(String title) {
            this.textView1.setText(title);
        }

        public void setTextView2(String subtitle) {
            this.textView2.setText(subtitle);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), this.textView1.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
