package com.ahmadabuhasan.dicoding;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
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
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        txtNama.setText(document.getString("nama"));
                        txtKet.setText(document.getString("ket"));
                        fotoUrl = document.getString("foto");

                        assert fotoUrl != null;
                        if (!fotoUrl.equals("")) {
                            Picasso.get().load(fotoUrl).fit().into(imgPaket);
                        } else {
                            Picasso.get().load(R.drawable.icon_img).fit().into(imgPaket);
                        }
                    }
                } else {
                    Toast.makeText(DetailActivity.this, "Error getting documents", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}