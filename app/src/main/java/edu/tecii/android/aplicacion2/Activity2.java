package edu.tecii.android.aplicacion2;

//Importando las librerias necesarias para esta aplicacion
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import java.util.Arrays;

public class Activity2 extends AppCompatActivity {

    //Se declaran los elementos que seran necesarios como las cajas de texto y los botones
    EditText edtxt1, edtxt2;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Casteo de los elementos xml a los objetos declarados arriba
        edtxt1 = (EditText)findViewById(R.id.editText2);
        edtxt2 = (EditText)findViewById(R.id.editText3);
        btn1 = (Button)findViewById(R.id.button5);
        btn2 = (Button)findViewById(R.id.button3);
        btn3 = (Button)findViewById(R.id.button4);

        //Escuchador de la caja de texto que no permite editar sobre esta misma
        edtxt2.setKeyListener(null);//https://stackoverflow.com/questions/3928711/how-to-make-edittext-not-editable-through-xml-in-android

        //Creacion del evento escuhador onclick para la accion de imprimir el resultado en la caja de texto
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uso del try para evitar el colapso del programa en caso de que el usuario introdusca otros caracteres
                try {
                    //Inicializacion de una variable string para capturar los datos de la caja de texto
                    String val = edtxt1.getText().toString();
                    //Uso del if para comprobar que el usuario haya introducido datos en la caja de texto
                    if (!val.isEmpty()){
                        String[] s = val.split(" ");//Arreglo "s" de strings para guardar el arreglo formado gracias al metodo split()
                        // el cual acomoda los cararacteres identificandolos por un simbolo o en este caso un espacio " " declarado dentro de este
                        int[] num = new int[s.length];//Arreglo de enteros para guardar los numeros
                        for (int i=0; i<s.length; i++) {//For para recorrer el arreglo y guardar sus datos en el arreglo de enteros
                            num[i] = Integer.parseInt(s[i]);//Guardando dato por dato en el arreglo de enteros
                        }
                        Arrays.sort(num);//Acomodando los numeros del arreglo en orden con la funcion Arrays.sort()
                        String r = "";//Declarando un string para mostrar el resultado final
                        for (int i=0; i<num.length; i++){//for para guardar dato por dato en el string anterior
                            r = r+num[i]+" ";
                        }
                        edtxt2.setText(r);//Imprimiendo el string resultante en la caja de texto
                        //Mensaje para mostrar la serie ordenada en pantalla
                        Toast.makeText(getApplicationContext(), "Serie con los datos ordenados: " +
                                "\n"+r, Toast.LENGTH_SHORT).show();
                    } else {
                        //Mensaje de informacion por no tener datos en la caja de texto y haber presionado el boton
                        Toast.makeText(getApplicationContext(), "Por favor inserta una " +
                                        "\nserie de numeros", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        //Evento escuchador del boton "siguiente" que se encargara de abrir la siguiente activity
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Funcion intent empleada para cambiar a la siguiente vista de la aplicacion
                Intent intent = new Intent(view.getContext(), Activity3.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
