package edu.tecii.android.aplicacion2;

//Importando las librerias necesarias para esta aplicacion
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    //Se declaran los elementos que seran necesarios como las cajas de texto y los botones
    EditText edtxt1, edtxt2;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //Casteo de los elementos xml a los objetos declarados arriba
        edtxt1=(EditText)findViewById(R.id.editText5);
        edtxt2=(EditText)findViewById(R.id.editText4);
        btn1=(Button)findViewById(R.id.button6);
        btn2=(Button)findViewById(R.id.button7);

        //Escuchador de la caja de texto que no permite editar sobre esta misma
        edtxt2.setKeyListener(null);//https://stackoverflow.com/questions/3928711/how-to-make-edittext-not-editable-through-xml-in-android

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Uso del try para evitar el colapso del programa en caso de que el usuario introdusca otros caracteres
                try {
                    //Inicializacion de una variable string para capturar los datos de la caja de texto
                    String val = edtxt1.getText().toString();
                    //Uso del if para comprobar que el usuario haya introducido datos en la caja de texto
                    if (!val.isEmpty()){
                        int num = Integer.parseInt(val);//Variable num para recibir el valor del casteo de los datos
                        int a = -1;//Inicializacion de una variable nombrada "a" para la inicializacion del calculo de la serie numerica
                        for (int i=1; i<num+1; i++){//Ciclo for para recorrer todas las posiciones y realizar los calculos de cada posicion
                            if(i%2==0) { //Uso de un if para determinar si el numero es par
                                a = a+1;//Calculo correspondiente si el numero es par
                            } else { //Calculo correspondiente si el numero es impar
                                a = a+2;
                            }
                        }
                        edtxt2.setText(String.valueOf(a));//Imprimiendo el resultado en la caja de texto
                        //Mensaje para mostrar el resultado en pantalla
                        Toast.makeText(getApplicationContext(), "Según la posición \nel resultado es: "
                                + String.valueOf(a), Toast.LENGTH_SHORT).show();
                    } else {
                        //Mensaje de informacion por no tener datos en la caja de texto y haber presionado el boton
                        Toast.makeText(getApplicationContext(), "Por favor inserta una valor entero",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    //Mensaje de advertencia por haber introducido otro tipo de datos o un calculo fallido
                    Toast.makeText(getApplicationContext(), "Error en el tipo de datos ingresados" +
                            "\nSolo se aceptan numeros enteros", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Evento escuchador del boton "anterior" que se encargara de abrir la activity anterior
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funcion intent empleada para cambiar a la vista anterior de la aplicacion
                Intent intent = new Intent(view.getContext(), Activity2.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
