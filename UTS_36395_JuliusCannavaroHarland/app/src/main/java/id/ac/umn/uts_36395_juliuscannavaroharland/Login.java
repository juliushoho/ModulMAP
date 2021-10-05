package id.ac.umn.uts_36395_juliuscannavaroharland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText) findViewById(R.id.input);
                String username = input.getText().toString();

                if(TextUtils.isEmpty(username)){
                    input.setError("Harap Diisi");
                    return;
                }else {
                    Intent libraryView = new Intent(Login.this, Library.class);
                    libraryView.putExtra("Username", username);
                    startActivity(libraryView);
                }
            }
        });
    }
}