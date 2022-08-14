package com.ahmadabuhasan.dicoding;

import android.content.Context;
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

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        firebaseFirestore = FirebaseFirestore.getInstance();

        getData();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AddActivity.class)));
    }

    private void getData() {
        Query query = firebaseFirestore.collection("Patuna");

        FirestoreRecyclerOptions<PatunaResponse> response = new FirestoreRecyclerOptions.Builder<PatunaResponse>()
                .setQuery(query, PatunaResponse.class).build();

        adapter = new FirestoreRecyclerAdapter<PatunaResponse, PatunaHolder>(response) {

            @NonNull
            @Override
            public PatunaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
                return new PatunaHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull PatunaHolder holder, int position, @NonNull final PatunaResponse model) {
                progressBar.setVisibility(View.GONE);
                if (model.getFoto() != null) {
                    Picasso.get().load(model.getFoto()).fit().into(holder.imgPaket);
                } else {
                    Picasso.get().load(R.drawable.icon_img).fit().into(holder.imgPaket);
                }
                holder.txtNama.setText(model.getNama());
                holder.txtHarga.setText(model.getHarga());

                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("nomor", model.getNomor());
                    startActivity(intent);
                });
            }

            @Override
            public void onError(@NonNull FirebaseFirestoreException e) {
                Log.e("Not Found: ", Objects.requireNonNull(e.getMessage()));
            }
        };
        recyclerView.setAdapter(adapter);
    }

    public static class PatunaHolder extends RecyclerView.ViewHolder {

        ImageView imgPaket;
        TextView txtNama, txtHarga;
        CardView cardView;

        public PatunaHolder(@NonNull View itemView) {
            super(itemView);
            imgPaket = itemView.findViewById(R.id.imageViewList);
            txtNama = itemView.findViewById(R.id.tvNamaPaketList);
            txtHarga = itemView.findViewById(R.id.tvHargaList);
            cardView = itemView.findViewById(R.id.cardView);
        }
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

    public static class WrapContentLinearLayoutManager extends LinearLayoutManager {

        public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                Log.e("TAG", "meet a I.O.O.B.E in RecyclerView");
            }
        }
    }
}