package edu.tecii.android.aplicacion2;

//Importando las librerias necesarias para esta aplicacion
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Se declaran los elementos que seran necesarios como las cajas de texto, las etiquetas y los botones
    EditText edtxt;
    Button btn1, btn2;
    TextView txtvw, txtvws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casteo de los elementos xml a los objetos declarados arriba
        edtxt=(EditText)findViewById(R.id.editText);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        txtvw=(TextView)findViewById(R.id.textView);
        txtvws=(TextView)findViewById(R.id.textView3);
        txtvws.setText("1, 1, 2, 3, 5, 8, 13, 21, 34");//Se imprime el texto en la etiqueta

        //Creacion del evento escuhador onclick para la accion que se le dara al boton
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Uso del try para evitar el colapso del programa en caso de que el usuario introdusca otros caracteres
                try {
                    //Inicializacion de una variable string para capturar los datos de la caja de texto
                    String val = edtxt.getText().toString();
                    //Uso del if para comprobar que el usuario haya introducido datos en la caja de texto
                    if (!val.isEmpty()){
                        long num = Integer.parseInt(val);//Variable num para recibir el valor del casteo de los datos
                        long a=1, b=0, c=0; //Variables auziliares para hacer los calculos de la serie
                        for (int i=0; i<num; i++){//Ciclo for para recorrer todas las posiciones y realizar los calculos de cada posicion
                            b=c;
                            c=a+b;
                            a=b;
                        }
                        //Imprimiendo el texto en la etiqueta
                        txtvw.setText("Según la posición el resultado \nes: "+ String.valueOf(c));
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

        //Evento escuchador del boton "siguiente" que se encargara de abrir la siguiente activity
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funcion intent empleada para cambiar a la siguiente vista de la aplicacion
                Intent intent = new Intent(view.getContext(), Activity2.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
