package com.gomez.jhond.figurasgeometricas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tPerimetro, tArea, tVolumen, tLado1, tLado2, tLado3;
    RadioButton rCubo, rCuadrado, rTriangulo, rCirculo;
    EditText eLado1, eLado2, eLado3;
    Button bCalcular, bReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tPerimetro = findViewById(R.id.tPerimetro);
        tArea = findViewById(R.id.tArea);
        tVolumen = findViewById(R.id.tVolumen);
        tLado1 = findViewById(R.id.tLado1);
        tLado2 = findViewById(R.id.tLado2);
        tLado3 = findViewById(R.id.tLado3);
        rCuadrado = findViewById(R.id.rCuadrado);
        rCirculo = findViewById(R.id.rCirculo);
        rCubo = findViewById(R.id.rCubo);
        rTriangulo = findViewById(R.id.rTriangulo);
        eLado1 = findViewById(R.id.eLado1);
        eLado2 = findViewById(R.id.eLado2);
        eLado3 = findViewById(R.id.eLado3);
        bCalcular = findViewById(R.id.bCalcular);
        bReset = findViewById(R.id.bReset);

        rCuadrado.setChecked(true);
        tLado1.setText("Lado:");
        tLado2.setVisibility(View.GONE);
        tLado3.setVisibility(View.GONE);
        eLado2.setVisibility(View.GONE);
        eLado3.setVisibility(View.GONE);
        tVolumen.setVisibility(View.GONE);


    }

    public void reset(View view) {
        rCuadrado.setChecked(true);
        tLado1.setText("Lado:");
        tLado2.setVisibility(View.GONE);
        tLado3.setVisibility(View.GONE);
        eLado1.setText("");
        eLado2.setText("");
        eLado3.setText("");
        eLado2.setVisibility(View.GONE);
        eLado3.setVisibility(View.GONE);
        tVolumen.setVisibility(View.GONE);
    }

    public void calcular(View view) {

        double area = 0, perimetro = 0, volumen = 0;

        if (rCuadrado.isChecked() && !eLado1.getText().toString().isEmpty()) {
            area = Double.valueOf(eLado1.getText().toString()).doubleValue() * Double.valueOf(eLado1.getText().toString()).doubleValue();
            perimetro = Double.valueOf(eLado1.getText().toString()) * 4;
        } else if (rCirculo.isChecked() && !eLado1.getText().toString().isEmpty()) {
            double r = Double.valueOf(eLado1.getText().toString()).doubleValue();
            perimetro = 3.1416 * r * 2;
            area = 3.1416 * r * r;
        } else if (rTriangulo.isChecked() && !eLado1.getText().toString().isEmpty() && !eLado2.getText().toString().isEmpty() && !eLado3.getText().toString().isEmpty()) {
            double s, a, b, c;
            a = Double.valueOf(eLado1.getText().toString()).doubleValue();
            b = Double.valueOf(eLado2.getText().toString()).doubleValue();
            c = Double.valueOf(eLado3.getText().toString()).doubleValue();
            perimetro = a + b + c;
            s = perimetro / 2;
            area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        } else if (rCubo.isChecked() && !eLado1.getText().toString().isEmpty()) {
            area = Double.valueOf(eLado1.getText().toString()).doubleValue() * Double.valueOf(eLado1.getText().toString()).doubleValue() * 6;
            volumen = Double.valueOf(eLado1.getText().toString()).doubleValue() * Double.valueOf(eLado1.getText().toString()).doubleValue() * Double.valueOf(eLado1.getText().toString()).doubleValue();
            tVolumen.setVisibility(View.VISIBLE);
            tVolumen.setText("Volumen:" + String.valueOf(volumen));
        }
        tPerimetro.setText("Perimetro:" + perimetro);
        tArea.setText("Área:" + area);
    }

    public void onRadioButtonClicked(View view) {

        int id = view.getId();

        if (id == R.id.rCuadrado) {

            tLado1.setText("Lado:");
            tLado2.setVisibility(View.GONE);
            tLado3.setVisibility(View.GONE);
            eLado2.setVisibility(View.GONE);
            eLado3.setVisibility(View.GONE);
            tVolumen.setVisibility(View.GONE);
            tPerimetro.setVisibility(View.VISIBLE);
        }
        if (id == R.id.rCirculo) {

            tLado1.setText("Radio:");
            tLado2.setVisibility(View.GONE);
            tLado3.setVisibility(View.GONE);
            eLado2.setVisibility(View.GONE);
            eLado3.setVisibility(View.GONE);
            tVolumen.setVisibility(View.GONE);
            tPerimetro.setVisibility(View.VISIBLE);
        }
        if (id == R.id.rTriangulo) {

            tLado1.setText("Lado1:");
            tLado2.setText("Lado2:");
            tLado3.setText("Lado3:");
            tLado2.setVisibility(View.VISIBLE);
            tLado3.setVisibility(View.VISIBLE);
            eLado2.setVisibility(View.VISIBLE);
            eLado3.setVisibility(View.VISIBLE);
            tPerimetro.setVisibility(View.VISIBLE);
            tVolumen.setVisibility(View.GONE);
        }
        if (id == R.id.rCubo) {

            tLado1.setText("Lado:");
            tLado2.setVisibility(View.GONE);
            tLado3.setVisibility(View.GONE);
            eLado2.setVisibility(View.GONE);
            eLado3.setVisibility(View.GONE);
            tPerimetro.setVisibility(View.GONE);
            tVolumen.setVisibility(View.VISIBLE);
        }
    }
}
