package com.ahmadabuhasan.dicoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;

    ImageView imgPaket;
    EditText txtNama, txtNomor, txtHarga, txtKet;
    Button BtnSave, BtnBack;
    ProgressBar progressBar;

    private Uri filePath;
    private String fotoUrl;

    private static final int IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        imgPaket = findViewById(R.id.imageView);
        txtNama = findViewById(R.id.etNamaPaket);
        txtNomor = findViewById(R.id.etNomor);
        txtHarga = findViewById(R.id.etHarga);
        txtKet = findViewById(R.id.etKet);

        BtnBack = findViewById(R.id.buttonBack);
        BtnSave = findViewById(R.id.buttonSave);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);

        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        imgPaket.setOnClickListener(v -> takeImg());

        BtnSave.setOnClickListener(v -> uploadImg());

        BtnBack.setOnClickListener(v -> finish());
    }

    private void saveData(String nama, String nomor, String harga, String ket, String foto) {

        Map<String, Object> patunaData = new HashMap<>();

        patunaData.put("nama", nama);
        patunaData.put("nomor", nomor);
        patunaData.put("harga", harga);
        patunaData.put("ket", ket);
        patunaData.put("foto", foto);

        firebaseFirestore.collection("Patuna").document(nomor).set(patunaData).isSuccessful();
    }

    private void takeImg() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Choose img"), IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            Picasso.get().load(filePath).fit().centerInside().into(imgPaket);
        } else {
            Toast.makeText(this, "No img selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadImg() {
        if (filePath != null) {
            final StorageReference ref = storageReference.child(txtNomor.getText().toString());
            UploadTask uploadTask = ref.putFile(filePath);

            Task<Uri> uriTask = uploadTask.continueWithTask(task -> ref.getDownloadUrl()).addOnCompleteListener(task -> {
                Uri imagePath = task.getResult();

                fotoUrl = imagePath.toString();
                saveData(txtNama.getText().toString(),
                        txtNomor.getText().toString(),
                        txtHarga.getText().toString(),
                        txtKet.getText().toString(),
                        fotoUrl);

                progressBar.setProgress(0);
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(AddActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                finish();
            });

            uploadTask.addOnProgressListener(taskSnapshot -> {
                progressBar.setVisibility(View.VISIBLE);
                double progres = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                progressBar.setProgress((int) progres);
            }).addOnFailureListener(e -> {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(AddActivity.this, "Failed " + e.getMessage(), Toast.LENGTH_LONG).show();
            });
        }
    }
}