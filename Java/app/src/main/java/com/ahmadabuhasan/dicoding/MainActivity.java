package com.ahmadabuhasan.dicoding;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;

    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        firebaseFirestore = FirebaseFirestore.getInstance();

        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        getData();
    }

    public static class PatunaHolder extends RecyclerView.ViewHolder {

        ImageView imgPaket;
        TextView txtNama, txtHarga;
        CardView cardView;


        PatunaHolder(@NonNull View itemView) {
            super(itemView);
            imgPaket = itemView.findViewById(R.id.imageViewList);
            txtNama = itemView.findViewById(R.id.tvNamaPaketList);
            txtHarga = itemView.findViewById(R.id.tvHargaList);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    private void getData() {
        Query query = firebaseFirestore.collection("Patuna");

        FirestoreRecyclerOptions<PatunaActivity> response = new FirestoreRecyclerOptions.Builder<PatunaActivity>()
                .setQuery(query, PatunaActivity.class).build();

        adapter = new FirestoreRecyclerAdapter<PatunaActivity, PatunaHolder>(response) {

            @NonNull
            @Override
            public PatunaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
                return new PatunaHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull PatunaHolder holder, int position, @NonNull final PatunaActivity model) {
                progressBar.setVisibility(View.GONE);
                if (model.getFoto() != null) {
                    Picasso.get().load(model.getFoto()).fit().into(holder.imgPaket);
                } else {
                    Picasso.get().load(R.drawable.icon_img).fit().into(holder.imgPaket);
                }
                holder.txtNama.setText(model.getNama());
                holder.txtHarga.setText(model.getHarga());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtra("nomor", model.getNomor());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(@NonNull FirebaseFirestoreException e) {
                Log.e("Not Found: ", Objects.requireNonNull(e.getMessage()));
            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aboutme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.AboutMe) {
            startActivity(new Intent(this, AboutActivity.class));
        }
        return true;
    }
}