package com.example.adriealle.kiosk;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    String email;
    EditText email_id;
    EditText passwords;


    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);


        progressDialog = new ProgressDialog(this);
        Button login = (Button) findViewById(R.id.button1);
        email_id = (EditText) findViewById(R.id.editText1);
        passwords = (EditText) findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }
    public void register() {
        initialize();
        if(!validate()) {
            Toast.makeText(this,"Please fill the required fields",Toast.LENGTH_SHORT).show();

        }
        else{
            userLogin();

        }

    }
    public void initialize() {
        email = email_id.getText().toString().trim();
    }


    public boolean validate() {
        boolean valid=true;
        if(email.isEmpty()) {
            email_id.setError("Enter valid ID");
            valid=false;

        }

        return valid;

    }



    private void userLogin(){
        String email = email_id.getText().toString().trim();
        String password  = passwords.getText().toString().trim();

            if(email.equals("m3m")){

                if(password.equals("techsaints"))
                {

                    Toast.makeText(this, "Welcome Sir!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(adminlogin.this,admin.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(this, "Password Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
            else
                Toast.makeText(this, "ID incorrect", Toast.LENGTH_SHORT).show();




        }





}
