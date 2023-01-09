package com.example.adriealle.kiosk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class testing extends AppCompatActivity  implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private static final int PICK_IMAGE_REQUEST = 234;
    private double re;
    private Button buttonChoose;
    byte[] imagesd;
    FileInputStream ftp;
    private Button upload;
    private ImageView imageView;
    private Uri filePath;
    String path;
    EditText name;
    int i3=1,j;
    Spinner cat,floor,shop,number;
LinearLayout root_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        buttonChoose = (Button) findViewById(R.id.buttonChoose);

        upload=(Button) findViewById(R.id.button5);
        imageView = (ImageView) findViewById(R.id.imagecollege);

        name=(EditText)findViewById(R.id.editText2);
        cat=findViewById(R.id.category);
        floor=findViewById(R.id.floor);
        shop=findViewById(R.id.Shop);
        number=findViewById(R.id.noofshops);
        buttonChoose.setOnClickListener(this);

        upload.setOnClickListener(this);

        floor.setOnItemSelectedListener(this);
        number.setOnItemSelectedListener(this);

        root_layout=findViewById(R.id.addnewspinner);



    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            path=data.getData().getPath();


            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);

                imagesd=stream.toByteArray();

//                ftp=new FileInputStream(path);
//                imagesd =new byte[ftp.available()];


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        @Override
    public void onClick(View view) {
        if (view == buttonChoose) {
            showFileChooser();
        }
        else if(view==upload){

            new AlertDialog.Builder(testing.this)
                    .setMessage("have you checked everything?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            final  testdata db = new testdata(testing.this);
                            db.addContact(name.getText().toString(),shop.getSelectedItem().toString(),floor.getSelectedItem().toString(),cat.getSelectedItem().toString(),imagesd);
                            for(j=1;j<=i3;j++)
                            {

                                Spinner sp=(Spinner)findViewById(j);
                                freeshops killer= new freeshops(testing.this);
                                killer.removefreeshop(name.getText().toString(),sp.getSelectedItem().toString());

                            }
                            Intent step3=new Intent(testing.this,MainActivity.class);
                            startActivity(step3);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


          }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int idd = view.getId();
        if (idd == R.id.floor) {
            freeshops dee=new freeshops(this);

            ArrayList<String> gee= dee.getfreenames(floor.getSelectedItem().toString());
            ArrayAdapter<String> geee=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gee);
            shop.setAdapter(geee);

        }
        if (idd == R.id.noofshops) {
            i3=Integer.parseInt(shop.getSelectedItem().toString());
            freeshops dee=new freeshops(this);

            ArrayList<String> gee= dee.getfreenames(floor.getSelectedItem().toString());
            ArrayAdapter<String> geee=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gee);

                for(j=1;j<=i3;j++)
                {
                    Spinner spin=new Spinner(testing.this);
                    spin.setId(j);
                    spin.setAdapter(geee);
      root_layout.addView(spin);//add this spinner to your layout(mLayout is object of your layout in xml)
                }


        }}



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

