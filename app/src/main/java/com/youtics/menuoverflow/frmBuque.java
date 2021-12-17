package com.youtics.menuoverflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class frmBuque extends AppCompatActivity {

    EditText mat, nombreBuque, hp, cantTripulantes, armador, camtCombustible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_buque);

        mat = (EditText) findViewById(R.id.txtmatricula);
        nombreBuque = (EditText) findViewById(R.id.txtnombreBuque);
        hp = (EditText) findViewById(R.id.txthp);
        armador = (EditText) findViewById(R.id.txtarmador);
        cantTripulantes = (EditText) findViewById(R.id.txtcantTripulantes);
        camtCombustible = (EditText) findViewById(R.id.txtcantCombustible);
    }

    public void RegistrarBuque()
    {
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this);
        SQLiteDatabase BD = admin.getWritableDatabase();

        Buque buque =  new Buque();

        buque.setMatricula(mat.getText().toString());
        buque.setNombreBuque(nombreBuque.getText().toString());
        buque.setArmador(armador.getText().toString());
        buque.setCantCombustible(Integer.parseInt(camtCombustible.getText().toString()));
        buque.setCantTripulantes(Integer.parseInt(cantTripulantes.getText().toString()));
        buque.setPotenciaHP(Integer.parseInt(hp.getText().toString()));

        if(BuscarBuque(buque.getMatricula())==false) {
            if (!buque.getMatricula().isEmpty() && !buque.getNombreBuque().isEmpty() &&
                    !buque.getArmador().isEmpty()) {

                ContentValues registro = new ContentValues();
                registro.put("matricula", buque.getMatricula());
                registro.put("nombreBuque", buque.getNombreBuque());
                registro.put("armador", buque.getArmador());
                registro.put("cantCombustible", buque.getCantCombustible());
                registro.put("cantTripulantes", buque.getCantTripulantes());
                registro.put("hp", buque.getPotenciaHP());

                BD.insert("buques", null, registro);
                BD.close();
                //limpiar los campos;

                Toast.makeText(this, "Los datos fueron registrado con Éxito...", Toast.LENGTH_LONG).show();
                //Intent inicio = new Intent(this, MainActivity.class);
                //startActivity(inicio);
                finish();
            } else {

                Toast.makeText(this, "Error, posibles campos vacios...", Toast.LENGTH_LONG).show();
            }
        }



    }

    public boolean BuscarBuque(String matricula) {
        AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this);
        SQLiteDatabase BD = admin.getWritableDatabase();

        boolean encontrado=false;

        if (!matricula.isEmpty()) {
            Cursor fila = BD.rawQuery("SELECT * FROM buques WHERE matricula ='" + matricula + "'" , null);
            if (fila.moveToFirst()) {
                encontrado=true;
            }
        } else {
            Toast.makeText(this, "Error, Matricula Buque campo vacio...COMPLETAR", Toast.LENGTH_LONG).show();
        }
        BD.close();
        return encontrado;
    }
}