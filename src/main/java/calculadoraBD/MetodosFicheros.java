package calculadoraBD;

import java.io.*;
import java.util.Scanner;

public class MetodosFicheros {




    // metodo para sumar
    public static void sumar() {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0,suma = 0;

        System.out.println("Ingrese el primer numero: ");
        num1 = sc.nextInt();


        // se obtiene el segundo numero de un fichero y en caso de no haber un numero en el fichero se suma 0
        FileWriter fw = null;

        try {
            File archivo = new File("suma.txt");
            if (archivo.exists()) {
                // El archivo existe, puedes leerlo
                FileReader fr = new FileReader(archivo);
                num2 = fr.read();
                System.out.print(num2);
                fr.close();
            } else {
                // El archivo no existe, puedes manejar el error
                num2 = 0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        suma = num1 + num2;
        System.out.println("El resultado es: " + (suma));
    }




    // metodo para guardar en memoria
    public static void guardarEnMemoria() {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2= 0,suma = 0;

        System.out.println("Ingrese el primer numero: ");
        num1 = sc.nextInt();

        // se obtiene el segundo numero de un fichero y en caso de no haber un numero en el fichero se suma 0
        FileWriter fw = null;
        try {
            File archivo = new File("suma.txt");
            if (archivo.exists()) {
                // El archivo existe, puedes leerlo
                FileReader fr = new FileReader(archivo);
                num2 = fr.read();
                System.out.print(num2);
                fr.close();
            } else {
                // El archivo no existe, puedes manejar el error
                num2 = 0;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        suma = num1 + num2;
        System.out.println("El resultado es: " + (suma));

        // se guarda el resultado en el fichero sustituyendo el anterior
        try {
            fw = new FileWriter("suma.txt");
            fw.write(suma);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
