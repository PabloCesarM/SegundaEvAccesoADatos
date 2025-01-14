package AccesoDatos;

import java.io.*;
import java.util.Scanner;

public class MetodoCalculadora {

    // metodo mostrar menu
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("0. Salir");
            System.out.println("1. Sumar");
            System.out.println("2. Guardar en memoria");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 0:
                    System.out.println("Saliendo de la aplicación");
                    break;
                case 1:
                    sumar();
                    break;
                case 2:
                    guardarEnMemoria();
                    break;

                default:
                    System.out.println("Opción introducida no valida");
                    break;
            }
        }while (opcion != 0);

    }


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

    // metodo para sumar en una base de datos
    public static void sumarDB() {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0,suma = 0;

        System.out.println("Ingrese el primer numero: ");
        num1 = sc.nextInt();

        // se obtiene el segundo numero de una tabla y en caso de no haber un numero en la tabla se suma 0
        try {

        } catch (Exception e) {
        }


        // NOEL TU HAS HECHO UNA UNA CLASE A PARTE PARA LAS CONEXIONES ?
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
