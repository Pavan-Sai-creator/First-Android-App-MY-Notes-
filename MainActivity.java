package com.example.notes20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

// declaring all the variables//

    private Button btnStore, btnGetall;
    private Uri mImageUri;
    private EditText etTitle, etnoteDetails;
    private DatabaseHelper databaseHelper;
    private Button addImage;
    private ImageView objectImageView;
    private ImageView result;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing all the declared members//

        databaseHelper = new DatabaseHelper(this);
        objectImageView = (ImageView) findViewById(R.id.image21);
        result = (ImageView)findViewById(R.id.image21);
        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetall = (Button) findViewById(R.id.btnget);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etnoteDetails = (EditText) findViewById(R.id.etNoteDetails);
        addImage = (Button) findViewById(R.id.addImage);

        //This is onCLick Listener for btnStore. This button will save the note that you entered into the database//

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addUserDetail(etTitle.getText().toString(), etnoteDetails.getText().toString());
                etTitle.setText("");
                etnoteDetails.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        // You can also click on "Show all notes button to view you notes. This is the onClick Listener for that button"

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GetAllUsersActivity.class);
                startActivity(intent);
            }
        });

        //You can add a backgroud image of your choice to make your app look better.{ Clicking on this button will connect to
        // a remotr server via HTTP framework and download the image from the URL and display it on the home page//

        //This is the onClick Listener for that button//

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageownloader myTask = new imageownloader();
                Bitmap bitmapImage;
                // String link = enterURL.getText().toString();
                try {
                    bitmapImage = myTask.execute("https://www.google.com/logos/doodles/2020/india-independence-day-2020-6753651837108500.3-l.png").get();
                    objectImageView.setImageBitmap(bitmapImage);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    //This class uses AsyncTask Framework to connect with internet and download the image//

    public class imageownloader extends AsyncTask<String,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //return bitmap;
            return null;
        }
    }
}
