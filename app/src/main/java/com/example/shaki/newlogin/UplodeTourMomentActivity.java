package com.example.shaki.newlogin;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class UplodeTourMomentActivity extends AppCompatActivity {
    private Button selectImage,uplodeImage;
    private ProgressBar progressBar;
    private ImageView imageView;
    private EditText editText;
    private Uri imageUri;
    private static final int IMAGE_REQUEST = 1;
    private StorageReference mStorageRef;
    private DatabaseReference myRef;
    StorageTask storageTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplode_tour_moment);

        selectImage = findViewById(R.id.selectImageId);
        progressBar = findViewById(R.id.prgressbarId);
        imageView = findViewById(R.id.Image_UplodeId);
        editText = findViewById(R.id.edit_textId);
        uplodeImage=findViewById(R.id.uplode_imageId);
        myRef = FirebaseDatabase.getInstance().getReference("User");
        mStorageRef = FirebaseStorage.getInstance().getReference("User");


        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChosser();

            }
        });

        uplodeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(storageTask != null && storageTask.isInProgress())
                {
                    Toast.makeText(getApplicationContext(),"Uploading is Progress..",Toast.LENGTH_LONG).show();
                } else
                    {
                       uplodeImageToFirebase();
                    }


            }

        });

    }
    private void openFileChosser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data!= null && data.getData()!= null);
        {
            imageUri = data.getData();
            Picasso.get().load(imageUri).into(imageView);
        }
    }


    // geting the extention of image......
    public String getImageExtention(Uri imageUri)
    {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
    }

    private void uplodeImageToFirebase()
    {
        final String imageDes = editText.getText().toString().trim();
        if(imageDes.isEmpty())
        {
           editText.setError("Enter the Image Description");
           editText.requestFocus();
           return;
        }
        StorageReference ref = mStorageRef.child(System.currentTimeMillis()+"."+getImageExtention(imageUri));
        ref.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(getApplicationContext(), "Image Uplode is ok...", Toast.LENGTH_SHORT).show();
                        Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!urlTask.isSuccessful());
                        Uri downloadUrl = urlTask.getResult();

                        UplodeImage uplodeImage = new UplodeImage(imageDes,downloadUrl.toString());
                        String uplodeKey = myRef.push().getKey();
                        myRef.child(uplodeKey).setValue(uplodeImage);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(getApplicationContext(), "Image Uplode isn't ok...", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
