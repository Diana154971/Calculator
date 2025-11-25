package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd, buttonSubtract, buttonDivade, buttonMultiply, buttonDegree, buttonClean;
    private TextView operation,result;
    private EditText number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonDivade = (Button) findViewById(R.id.buttonDivade);
        buttonMultiply =(Button) findViewById(R.id.buttonMultiply);
        buttonDegree =(Button) findViewById(R.id.buttonDegree);
        buttonClean = (Button) findViewById(R.id.buttonClean);
        operation= (TextView) findViewById(R.id.operation);
        result= (TextView) findViewById(R.id.result);
        number1= (EditText) findViewById(R.id.number1);
        number2= (EditText) findViewById(R.id.number2);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivade.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDegree.setOnClickListener(this);
        buttonClean.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    @Override
    public void onClick(View view) {
        float num1  = 0;
        float num2 = 0;
        float res = 0;

        num1 = Float.parseFloat(number1.getText().toString());
        num2= Float.parseFloat(number2.getText().toString());

        int id = view.getId();
        if (id == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        } else if (id == R.id.buttonSubtract){
            operation.setText("-");
            res = num1 - num2;
        } else if (id == R.id.buttonDivade){
            operation.setText("/");
            res = num1 / num2;
        } else if (id == R.id.buttonMultiply){
            operation.setText("*");
            res = num1 * num2;
        } else if (id == R.id. buttonDegree) {
            operation.setText("^");

            number1.setText("");
            operation.setText("");
            number2.setText("");
            result.setText("");
            return;
        }

        result.setText(String.valueOf(res));
    }
}