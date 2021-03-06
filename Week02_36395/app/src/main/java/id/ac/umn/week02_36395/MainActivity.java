package id.ac.umn.week02_36395;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText angka1, angka2;
    TextView hasil;
    Button btnTambah, btnKurang, btnKali, btnBagi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = this.findViewById(R.id.angka1);
        angka2 = this.findViewById(R.id.angka2);
        hasil = this.findViewById(R.id.hasil);
        btnTambah = this.findViewById(R.id.btnTambah);
        btnKurang = this.findViewById(R.id.btnKurang);
        btnBagi = this.findViewById(R.id.btnBagi);
        btnKali = this.findViewById(R.id.btnKali);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('+');
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('-');
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('*');
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('/');
            }
        });
    }

    protected void hitung(char operator){
        double operand1 = Double.parseDouble(angka1.getText().toString());
        double operand2 = Double.parseDouble(angka2.getText().toString());
        double result = 0.0;

        switch (operator){
            case('+') : result = operand1 + operand2; break;
            case('-') : result = operand1 - operand2; break;
            case('*') : result = operand1 * operand2; break;
            case('/') : result = operand1 / operand2; break;
        }
        hasil.setText(String.valueOf(result));
    }
}