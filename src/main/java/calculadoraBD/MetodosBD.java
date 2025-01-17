package calculadoraBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static calculadoraBD.DbManager.conn;

public class MetodosBD {

    // metodo para sumar en una base de datos
    public static void sumarDB() {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0, suma = 0;

        System.out.println("Ingrese el primer numero: ");
        num1 = sc.nextInt();


        // se obtiene el segundo numero de una tabla y en caso de no haber un numero en la tabla se suma 0
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM suma;");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                num2 = rs.getInt("numero");
                System.out.println("NumeroGuardado = " + num2);

            }
            suma = num1 + num2;
            System.out.println("La suma es: " + suma);
        } catch (Exception e) {

        }

    }
}
