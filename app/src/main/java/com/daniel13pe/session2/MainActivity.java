package com.daniel13pe.session2;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eCorreo, eNombre, eEmail, contra, email;
    String nombre, contra1, contra2, eMail,  data = "", date, lugar;
    String[] data2= new String[4];
    private Spinner spinner1;
    private ListView places;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    CheckBox cCine, cNadar, cGym, cSoc;
    RadioButton  rMasculino, rFemenino, radiosb;
    private TextView dateView;
    TextView datos1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        places = (ListView) findViewById(R.id.lugares);
        datos1 = (TextView) findViewById(R.id.textView4);
        ArrayAdapter spinadapter = ArrayAdapter.createFromResource(this,R.array.country_arrays,android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinadapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int pos, long id) {
                if(lista.getItemAtPosition(pos).equals("Bogota DC")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.country_arrays,android.R.layout.simple_list_item_activated_1);
                    places.setAdapter(listaAdapter);
                }
                if(lista.getItemAtPosition(pos).equals("Medellín")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.medellin,android.R.layout.simple_list_item_1);
                    places.setAdapter(listaAdapter);
                }
                if(lista.getItemAtPosition(pos).equals("Barranquilla")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.barranca,android.R.layout.simple_list_item_1);
                    places.setAdapter(listaAdapter);
                }
                if(lista.getItemAtPosition(pos).equals("Huila")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.huila,android.R.layout.simple_list_item_1);
                    places.setAdapter(listaAdapter);
                }
                if(lista.getItemAtPosition(pos).equals("Pasto")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.pasto,android.R.layout.simple_list_item_1);
                    places.setAdapter(listaAdapter);
                }
                if(lista.getItemAtPosition(pos).equals("Cali")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.cali,android.R.layout.simple_list_item_1);
                    places.setAdapter(listaAdapter);
                }
                if(lista.getItemAtPosition(pos).equals("Cucuta")){
                    ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.cucuta,android.R.layout.simple_list_item_1);
                    places.setAdapter(listaAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );
        eCorreo = findViewById(R.id.eCorreo);
        contra = findViewById(R.id.contra);
        eNombre = findViewById(R.id.eNombre);
        eEmail = findViewById(R.id.email);
        rFemenino = findViewById(R.id.rFemenino);
        rMasculino = findViewById(R.id.rMasculino);
        email = findViewById(R.id.email);
        cCine = findViewById(R.id.cCine);
        cNadar = findViewById(R.id.cNadar);
        cGym = findViewById(R.id.cGym);
        cSoc = findViewById(R.id.cSoc);
        rMasculino = findViewById(R.id.rMasculino);
        rFemenino = findViewById(R.id.rFemenino);
        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        addListenerOnSpinnerItemSelection();

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }



    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        //spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    public void guardar(View view) {

        int id = view.getId();

        if (id == R.id.bGuardar) {
            nombre = eNombre.getText().toString();
            contra1 = eCorreo.getText().toString();
            contra2 = contra.getText().toString();
            eMail = email.getText().toString();
            date = dateView.getText().toString();
            contra1 = eCorreo.getText().toString();
            contra2 = contra.getText().toString();
            if(nombre.equals("")){
                eNombre.setError("No value");
            }
            else if(contra1.equals("")){
                eCorreo.setError("No value");
                }
            else if(contra2.equals("")){
                contra.setError("No value");
                }
            else if(eMail.equals("")){
                email.setError("No value");
            }
            else if(!contra1.equals(contra2)) {
                Toast.makeText(getApplicationContext(), "No match Passwords", Toast.LENGTH_SHORT).show();
            }else {
                datos1.setText("*Nombre de Usuario: " + nombre + "\n*Contrasena: " + contra1 + "\n*E-mail: " + eMail +
                        "\n*Fecha de Cumple: " + date + "\n*Sexo: " + data + "\n*Pasatiempo(s):" + data2[0] + data2[1] + data2[2] + data2[3]);
                //Log.d("botton","Guardado"); forma de mostrar actividad en el LOGCAT
            }
        }

    }

    public void onRadioButtonClicked(View view) {

        int id = view.getId();
        if (id == R.id.rMasculino) {
            data = "Masculino";
        }else if(id == R.id.rFemenino) {
            data = "Femenino";
        }
    }

    public void onCheckBoxClicked(View view) {

        int id = view.getId();
        if (cCine.isChecked()) {
            data2[0] = "\n      Movies";
        }else {
            data2[0] = "";
        }
        if (cGym.isChecked()) {
            data2[2] = "\n      Gym";
        }else {
            data2[2] = "";
        }
        if (cSoc.isChecked()) {
            data2[3] = "\n      Soccer";
        }else {
            data2[3] = "";
        }
        if (cNadar.isChecked()) {
            data2[1] = "\n      Swim";
        }else {
            data2[1] = "";
        }
    }
}
