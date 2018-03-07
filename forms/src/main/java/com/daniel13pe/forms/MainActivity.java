package com.daniel13pe.forms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText lado1, lado2, lado3, radioc;
    RadioButton cua, tria, cir, cub;
    TextView resul1,resul2,resul3,resul4;
    String data="", uno, dos, tres, cuatro;
    ImageView imagen_Appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen_Appbar = (ImageView) findViewById(R.id.imagen1);
        imagen_Appbar.setImageResource(R.drawable.metatron);

        cua = findViewById(R.id.rcuadrado);
        tria = findViewById(R.id.rtriangulo);
        cir = findViewById(R.id.rcirculo);
        cub = findViewById(R.id.rcubo);
        lado1 = findViewById(R.id.lado1b);
        lado2 = findViewById(R.id.lado2h);
        lado3 =  findViewById(R.id.lado3c);
        radioc =  findViewById(R.id.radio);
        resul1 = findViewById(R.id.lavelarea);
        resul2 = findViewById(R.id.resultadoarea);
        resul3 = findViewById(R.id.lavelperi);
        resul4 = findViewById(R.id.resultadoperi);
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();

        if(id == R.id.rcuadrado){
            imagen_Appbar.setImageResource(R.drawable.cuadrado);
            lado1.setEnabled(true);
            lado2.setEnabled(false);
            lado3.setEnabled(false);
            radioc.setEnabled(false);
            data="Cuadrado";
            resul1.setText("");
            resul2.setText("");
            resul3.setText("");
            resul4.setText("");
        }else if(id == R.id.rtriangulo){
            imagen_Appbar.setImageResource(R.drawable.triangulo);
            lado1.setEnabled(true);
            lado2.setEnabled(true);
            lado3.setEnabled(true);
            radioc.setEnabled(false);
            data="Triangulo";
            resul1.setText("");
            resul2.setText("");
            resul3.setText("");
            resul4.setText("");
        }else if(id == R.id.rcirculo){
            imagen_Appbar.setImageResource(R.drawable.circulo);
            lado1.setEnabled(false);
            lado2.setEnabled(false);
            lado3.setEnabled(false);
            radioc.setEnabled(true);
            data="Circulo";
            resul1.setText("");
            resul2.setText("");
            resul3.setText("");
            resul4.setText("");
        }else if(id == R.id.rcubo){
            imagen_Appbar.setImageResource(R.drawable.cubo);
            lado1.setEnabled(true);
            lado2.setEnabled(false);
            lado3.setEnabled(false);
            radioc.setEnabled(false);
            data="Cubo";
            resul1.setText("");
            resul2.setText("");
            resul3.setText("");
            resul4.setText("");
        }else{
            imagen_Appbar.setImageResource(R.drawable.metatron);
        }
    }

    public void boton(View view) {
        //int id = view.getId();
        uno = lado1.getText().toString();
        dos = lado2.getText().toString();
        tres = lado3.getText().toString();
        cuatro = radioc.getText().toString();

        Double n1,n2,n3,n4,area,peri,volum;

        //if(id == R.id.calculo){
            switch (data){
                case("Cuadrado"):{

                    if(uno.equals("")){
                        lado1.setError("No value");
                    }
                    else{
                        n1 = Double.parseDouble(lado1.getText().toString());
                        area = n1*n1;
                        peri = 4.0*n1;
                        resul1.setText(data+"\n*Area:");
                        resul2.setText(String.valueOf(area));
                        resul3.setText("*Perimetro:");
                        resul4.setText(String.valueOf(peri));
                        lado1.setText("");
                    }
                }break;
                case("Triangulo"):{
                    if(uno.equals("")){
                        lado1.setError("No value");
                    }
                    if(dos.equals("")){
                        lado2.setError("No value");
                    }
                    if(tres.equals("")){
                        lado3.setError("No value");
                    }else{
                        n1 = Double.parseDouble(lado1.getText().toString());
                        n2 = Double.parseDouble(lado2.getText().toString());
                        n3 = Double.parseDouble(lado3.getText().toString());
                        peri = n1+n2+n3;
                        area = Math.sqrt((peri/2)*((peri/2)-n1)*((peri/2)-n2)*((peri/2)-n3)) ;
                        resul1.setText(data+"\n*Area(cm2):");
                        resul2.setText(String.valueOf(area));
                        resul3.setText("*Perimetro(cm):");
                        resul4.setText(String.valueOf(peri));
                        lado1.setText("");
                        lado2.setText("");
                        lado3.setText("");
                    }
                }break;
                case("Circulo"):{
                    if(cuatro.equals("")){
                        radioc.setError("No value");
                    }else{
                        n4 = Double.parseDouble(radioc.getText().toString());
                        peri = 2*3.14159*n4;
                        area = 3.14159*n4*n4;
                        resul1.setText(data+"\n*Area(cm2):");
                        resul2.setText(String.valueOf(area));
                        resul3.setText("*Perimetro(cm):");
                        resul4.setText(String.valueOf(peri));
                        radioc.setText("");
                    }
                }break;
                case("Cubo"):{
                    if(uno.equals("")){
                        lado1.setError("No value");
                    }else{
                        n1 = Double.parseDouble(lado1.getText().toString());
                        area = 6*n1*n1;
                        volum = n1*n1*n1;
                        resul1.setText(data+"\n*Area(cm2):");
                        resul2.setText(String.valueOf(area));
                        resul3.setText("*Volumen(cm3):");
                        resul4.setText(String.valueOf(volum));
                        lado1.setText("");
                    }
                }break;
                default:{
                    resul2.setText("Selecciona una Figura!");
                }break;
            }
        //}
    }
}
