package id.ac.umn.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String newNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            calc.setText("");
        isNewOp = false;
        String number = calc.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                number += "1";
                break;
            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu4:
                number += "4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
            case R.id.bu0:
                number += "0";
                break;
            case R.id.buComa:
                number += ".";
                break;
            case R.id.buPlusMinus:
                number = "-"+number;
                break;
        }
        calc.setText(number);
    }

    public void operatorEvent(View view){
        isNewOp = true;
        oldNumber = calc.getText().toString();

        switch (view.getId()){
            case R.id.buDivide: op = "/"; break;
            case R.id.buMultiply: op = "*"; break;
            case R.id.buPlus: op = "+"; break;
            case R.id.buMinus: op = "-"; break;
        }
    }

    public void equalEvent(View view){
        newNumber = calc.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
        }
        calc.setText(result+"");
    }

    public void clearEvent(View view){
        calc.setText("0");
        isNewOp = true;
    }

    public void clearemptyEvent(View view){
        calc.setText("0");
        isNewOp = true;
    }

    public void deleteEvent(View view){
        String str = calc.getText().toString();
        if(str.length() > 1){
            str = str.substring(0, str.length()-1);
            calc.setText(str);
        }
        else if (str.length() <= 1){
            calc.setText("0");
            isNewOp = true;
        }
    }
}