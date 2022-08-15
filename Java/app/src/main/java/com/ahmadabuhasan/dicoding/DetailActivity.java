package com.ahmadabuhasan.dicoding;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;

    ImageView imgPaket;
    TextView txtNama, txtKet;
    ProgressBar progressBar;

    private String fotoUrl, nomorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail");

        imgPaket = findViewById(R.id.imageView);
        txtNama = findViewById(R.id.tvNamaPaket);
        txtKet = findViewById(R.id.tvKet);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);

        firebaseFirestore = FirebaseFirestore.getInstance();

        nomorId = Objects.requireNonNull(getIntent().getExtras()).getString("nomor");
        readData();

    }

    private void readData() {
        firebaseFirestore.collection("Patuna").whereEqualTo("nomor", nomorId)
                .get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            txtNama.setText(document.getString("nama"));
                            txtKet.setText(document.getString("ket"));
                            fotoUrl = document.getString("foto");

                            if (!Objects.equals(fotoUrl, "")) {
                                Picasso.get().load(fotoUrl).fit().into(imgPaket);
                            } else {
                                Picasso.get().load(R.drawable.icon_img).fit().into(imgPaket);
                            }
                        }
                    } else {
                        Toast.makeText(DetailActivity.this, "Error getting documents", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}