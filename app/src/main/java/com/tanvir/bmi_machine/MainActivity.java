package com.tanvir.bmi_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight, height_inch, height_ft;
        Button btn_calculate;
        TextView result;

        weight = findViewById(R.id.weight);
        height_ft = findViewById(R.id.height_ft);
        height_inch = findViewById(R.id.height_inch);
        btn_calculate = findViewById(R.id.btn_calculate);
        result = findViewById(R.id.result);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int htFt = Integer.parseInt(height_ft.getText().toString());
                int inch = Integer.parseInt(height_inch.getText().toString());
                double totalInch = htFt * 12 + inch;
                double totalCent = totalInch * 2.53;
                double totalMeter = totalCent/100;
                double bmi = wt / (totalMeter * totalMeter);
                if(bmi > 25) {
                    result.setText(bmi +" = over_Weight");
                }else if(bmi < 18)
                    result.setText(bmi + " = under_Weight");
                else result.setText(bmi + " = normal_Weight");
            }
        });

    }
}