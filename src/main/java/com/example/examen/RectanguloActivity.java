package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class RectanguloActivity extends AppCompatActivity {
    private TextView lblDatos1;
    private TextView lblDatos2;
    private TextView lblDatos3;
    private TextView lblRes1;
    private TextView lblRes2;
    private RadioButton rbArea;
    private RadioButton rbPerimetro;
    private Button btnCalcular;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        lblDatos1 = (TextView) findViewById(R.id.lblDatos1);
        lblDatos2 = (TextView) findViewById(R.id.lblDatos2);
        lblDatos3 = (TextView) findViewById(R.id.lblDatos3);
        lblRes1 = (TextView) findViewById(R.id.lblRes);
        lblRes2 = (TextView) findViewById(R.id.lblRes2);
        rbArea = (RadioButton) findViewById(R.id.rbArea);
        rbPerimetro = (RadioButton) findViewById(R.id.rbPerimetro);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        final Bundle datos = getIntent().getExtras();
        lblDatos1.setText(datos.getString("nombre"));
        lblDatos2.setText(datos.getString("altura"));
        lblDatos3.setText(datos.getString("base"));
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float altura = Integer.parseInt(lblDatos2.getText().toString());
                final float base = Integer.parseInt(lblDatos3.getText().toString());
                final Rectangulo c = new Rectangulo(base, altura);
                if(rbArea.isChecked() == false && rbPerimetro.isChecked() == false){
                    lblRes1.setText("Debe marcar una opcion");
                }
                if(rbArea.isChecked() == true){
                    lblRes1.setText("El area es: ");
                    lblRes2.setText(""+c.calcularArea());
                }else if(rbPerimetro.isChecked() == true){
                    lblRes1.setText("El perimetro es: ");
                    lblRes2.setText(""+c.calcularPerimetro());
                }
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });
    }

    private void Regresar(){
        AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
        confirmar.setTitle("¿Deseas regresar?");
        confirmar.setPositiveButton("Confirmar",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){

            }
        });
        confirmar.show();
    }
}
