package com.example.pruebatcnica_fc5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Registros extends AppCompatActivity {

    String usuario;
    Button btnAceptar;

    FloatingActionButton btnAgregar;
    ArrayList<Contacto> listContacts;
    ListAdapter adapter;

    EditText newNombre, newApellido, newCelular, newParentesco, newNumTel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        usuario = getIntent().getStringExtra("user");

        RecyclerView recyclerV = findViewById(R.id.lista);;
        recyclerV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(listContacts, this);
        recyclerV.setAdapter(adapter);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Registros.this);
                dialog.setContentView(R.layout.activity_new_contacto);

                newNombre = dialog.findViewById(R.id.txtNewNom);
                newApellido = dialog.findViewById(R.id.txtNewApe);
                newCelular = dialog.findViewById(R.id.txtNewCel);
                newParentesco = dialog.findViewById(R.id.txtNewParent);
                newNumTel = dialog.findViewById(R.id.txtNewTel);

                btnAceptar = dialog.findViewById(R.id.btnGuardar);
                btnAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nombre = newNombre.getText().toString();
                        String apellido = newApellido.getText().toString();
                        String celular = newCelular.getText().toString();
                        String parentesco = newParentesco.getText().toString();
                        String telefono = newNumTel.getText().toString();
                        if(nombre.isEmpty() || apellido.isEmpty() || celular.isEmpty() || parentesco.isEmpty() || telefono.isEmpty())
                            Toast.makeText(Registros.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                        else
                            listContacts.add(new Contacto(nombre, apellido, celular, parentesco, telefono));

                        adapter.notifyItemInserted(listContacts.size());
                        recyclerV.scrollToPosition(listContacts.size());
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        crearContactos();
    }

    private void crearContactos()
    {
        listContacts = new ArrayList<>();
        if(usuario.equals("andrea.rios.sic@gmail.com"))
        {
            listContacts.add(new Contacto("Manuel", "Villegas", "6671173573", "Esposo", "8563458762"));
            listContacts.add(new Contacto("Julio", "Cejudo", "6674626752", "Compañero", "4585896123"));
            listContacts.add(new Contacto("Valeria", "Nicols", "6671258743", "Amiga", "5574645789"));
            listContacts.add(new Contacto("Paula", "Beltran", "6674569875", "Sobrina", "3571597896"));
            listContacts.add(new Contacto("Santiel", "Benitez", "6677891235", "Sobrino", "1236547213"));
        }
        else if(usuario.equals("oswaldors@outlook.com"))
        {
            listContacts.add(new Contacto("Teresa", "Sicairos", "6672521877", "Madre", "4562789543"));
            listContacts.add(new Contacto("Angelo", "Vizcarra", "6678526541", "Amigo", "9512365412"));
            listContacts.add(new Contacto("Anabel", "Benitez", "6675621854", "Tia", "7413698542"));
            listContacts.add(new Contacto("Jose", "Candiles", "6672138459", "Amigo", "4568423597"));
            listContacts.add(new Contacto("America", "Solis", "6672458976", "Sobrina", "6542789543"));
        }
        else if(usuario.equals("manuelvillegas08@hotmail.com"))
        {
            listContacts.add(new Contacto("Pedro", "Perez", "6674563257", "Compañero", "7543268514"));
            listContacts.add(new Contacto("Andres", "Costilla", "6674578965", "Amigo", "7456895234"));
            listContacts.add(new Contacto("Perla", "Perez", "6675478965", "Amiga", "6587459876"));
            listContacts.add(new Contacto("Luis", "Iribe", "6674568759", "Tio", "6854759832"));
            listContacts.add(new Contacto("Angel", "Cardenas", "6674578965", "Hermano", "9578632457"));
        }
        else if(usuario.equals("teresasicairos1@gmail.com"))
        {
            listContacts.add(new Contacto("Karla", "Castro", "6674527896", "Prima", "6524635632"));
            listContacts.add(new Contacto("Karely", "Chavez", "6675321468", "Tia", "5321456985"));
            listContacts.add(new Contacto("Alfonso", "Soto", "6674213950", "Amigo", "7531204568"));
            listContacts.add(new Contacto("Maria", "Ruiz", "6672054863", "Cuñada", "8563210457"));
            listContacts.add(new Contacto("Patricia", "Arredondo", "6672521877", "Sobrina", "7589654215"));
        }
        else if(usuario.equals("19170666@itculiacan.edu.mx"))
        {
            listContacts.add(new Contacto("Ricardo", "Rodriguez", "6675421803", "Compañero", "7593541256"));
            listContacts.add(new Contacto("Miguel", "Corrales", "6672458631", "Amigo", "7854269514"));
            listContacts.add(new Contacto("Astrid", "De la Paz", "6675473201", "Amiga", "8745963201"));
            listContacts.add(new Contacto("Alfredo", "Martinez", "6673201842", "Sobrino", "9853201457"));
            listContacts.add(new Contacto("Andrea", "Sicairos", "6671524896", "Cuñada", "8456327591"));
        }

        ListAdapter listAdapter = new ListAdapter(listContacts, this);
        RecyclerView recyclerView = findViewById(R.id.lista);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Registros.this, R.style.CustomAlertDialog);
                builder.setIcon(R.drawable.cancel);
                builder.setTitle("Eliminar Contacto");
                builder.setMessage("¿Desea eliminar este contacto?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listContacts.remove(position);
                                listAdapter.notifyItemRemoved(position);
                            }
                        });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }


}