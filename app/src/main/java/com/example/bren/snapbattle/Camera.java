package com.example.bren.snapbattle;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class Camera extends MainActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextFileName;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;

    private StorageTask mUploadTask;
    private StorageReference mStorage;
    private DatabaseReference mData;
    private static final int CAMERA_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);


        mButtonChooseImage = findViewById(R.id.btnFile);
        mButtonUpload = findViewById(R.id.btnUpload);
        mTextViewShowUploads = findViewById(R.id.tvUpload);
        mEditTextFileName = findViewById(R.id.tFile);
        mProgressBar = findViewById(R.id.progressBar);
        mImageView = findViewById (R.id.imageView);
        mStorage = FirebaseStorage.getInstance().getReference("uploads");
        mData = FirebaseDatabase.getInstance ().getReference ("uploads");


        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress ()) {
                    Toast.makeText (Camera.this, "Upload is already in progress", Toast.LENGTH_SHORT).show ();

                } else {
                    uploadFile ();

                }
            }
        });
        mTextViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();

            }
        });
        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        ImageView mImageView = (ImageView) findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_REQUEST_CODE);


            }
        });

    }

  /*  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){


            Uri uri = data.getData();
            StorageReference filepath = mStorage.child("Photos").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(Camera.this, "Photo uploaded", Toast.LENGTH_SHORT ).show();
                }
            });

        }
        }
*/


    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(mImageView);
        }


    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver ();
        MimeTypeMap mime = MimeTypeMap.getSingleton ();
        return mime.getExtensionFromMimeType (cR.getType (uri));
    }

    private void uploadFile(){
        if (mImageUri != null){
            StorageReference fileReference = mStorage.child (System.currentTimeMillis ()
            + "." + getFileExtension (mImageUri));

            mUploadTask = fileReference.putFile (mImageUri)
                    .addOnSuccessListener (new OnSuccessListener<UploadTask.TaskSnapshot> () {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed (new Runnable () {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            }, 500);

                            Toast.makeText (Camera.this, "Upload Successful", Toast.LENGTH_LONG).show ();
                            Upload upload = new Upload (mEditTextFileName.getText ().toString ().trim (),
                                    taskSnapshot.getUploadSessionUri ().toString ());
                            String uploadId = mData.push ().getKey ();
                            mData.child (uploadId).setValue (upload);

                        }
                    })
                    .addOnFailureListener (new OnFailureListener () {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText (Camera.this, e.getMessage (), Toast.LENGTH_SHORT).show ();

                        }
                    })
                    .addOnProgressListener (new OnProgressListener<UploadTask.TaskSnapshot> () {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred () / taskSnapshot.getTotalByteCount ());
                            mProgressBar.setProgress ((int)progress);
                        }
                    });

        } else {
            Toast.makeText (this, "No file selected", Toast.LENGTH_SHORT).show ();
        }

    }
        private void openImagesActivity(){
        Intent intent = new Intent(this, UploadView.class);
        startActivity (intent);
        }
}
