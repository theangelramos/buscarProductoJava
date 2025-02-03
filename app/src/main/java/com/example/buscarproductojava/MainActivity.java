package com.example.buscarproductojava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText productoInput;
    private RadioGroup categoriaRadioGroup;
    private Button buscarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        productoInput = findViewById(R.id.productoInput);
        categoriaRadioGroup = findViewById(R.id.categoriaRadioGroup);
        buscarButton = findViewById(R.id.buscarButton);

        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreProducto = productoInput.getText().toString();

                int radioId = categoriaRadioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(radioId);

                String categoria = "";
                if (radioButton != null) {
                    categoria = radioButton.getText().toString();
                }

                if (nombreProducto.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Por favor ingrese el nombre del producto",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (categoria.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Por favor seleccione una categoría",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                String mensaje = "Buscando: " + nombreProducto +
                        "\nCategoría: " + categoria;
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}