package com.example.pruebatcnica_fc5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button inicioSesion;
    EditText correo, contraseña;
    private ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicioSesion = (Button) findViewById(R.id.btnIniciarSesion);
        correo = (EditText) findViewById(R.id.txtCorreo);
        contraseña = (EditText) findViewById(R.id.txtContra);

        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
    }

    private void listaUsuarios()
    {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("andrea.rios.sic@gmail.com", "123abc34"));
        listaUsuarios.add(new Usuario("oswaldors@outlook.com", "riso5486"));
        listaUsuarios.add(new Usuario("manuelvillegas08@hotmail.com", "J04msiv1"));
        listaUsuarios.add(new Usuario("teresasicairos1@gmail.com", "teresa23"));
        listaUsuarios.add(new Usuario("19170666@itculiacan.edu.mx", "RISA001221"));
    }

    private void iniciarSesion()
    {
        listaUsuarios();
        String correoIS = correo.getText().toString();
        String contraIS = contraseña.getText().toString();
        boolean find = false;
        for(int i = 0; i < listaUsuarios.size(); i++)
        {
            if(correoIS.equals(listaUsuarios.get(i).getCorreo()) && contraIS.equals(listaUsuarios.get(i).getContraseña()))
            {
                find = true;
                Intent intent = new Intent(MainActivity.this, Registros.class);
                intent.putExtra("user", correoIS);
                startActivity(intent);
            }
            else if(correoIS.isEmpty() || contraIS.isEmpty())
                Toast.makeText(MainActivity.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
        }
        if (!find)
            Toast.makeText(MainActivity.this, "Correo o contraseña incorrecto", Toast.LENGTH_SHORT).show();
    }

}