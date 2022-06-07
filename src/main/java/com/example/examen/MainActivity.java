package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtBase;
    private EditText txtAltura;
    private Button btnLimpiar;
    private Button btnSig;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSig = (Button) findViewById(R.id.btnSig);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("") || txtBase.getText().toString().matches("") || txtAltura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Existe un dato invalido",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("nombre", txtNombre.getText().toString());
                    bundle.putSerializable("base", txtBase.getText().toString());
                    bundle.putSerializable("altura", txtAltura.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtBase.setText("");
                txtAltura.setText("");
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cerrar();
            }
        });
    }

    private void Cerrar(){
        AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
        confirmar.setTitle("¿Cerrar APP?");
        confirmar.setMessage("Se descartara toda la informacion ingresada");
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