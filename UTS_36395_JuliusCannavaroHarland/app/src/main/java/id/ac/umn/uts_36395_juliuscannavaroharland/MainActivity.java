package id.ac.umn.uts_36395_juliuscannavaroharland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btn1 = findViewById(R.id.profile);
        btn2 = findViewById(R.id.library);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileView = new Intent(MainActivity.this, Profile.class);
                startActivity(profileView);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginView = new Intent(MainActivity.this, Login.class);
                startActivity(loginView);
            }
        });
    }
}