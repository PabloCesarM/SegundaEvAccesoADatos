package calculadoraBD;

import java.sql.*;
import java.util.Properties;

public class DbManager {

    //establecer los parametros de conexion
    static String URL = "jdbc:mysql://localhost:3306/bdejCaluculadora";
    static String USER = "user";
    static String PASSWORD = "user";
    static Connection conn = null;



    // metodo para obtener datos de properties
    public  void init() {
        Properties properties = new Properties();
        try {
            //properties.load(new File);


        }catch ( Exception e){

        }

        //pasar lo siguiente a otro metodo para realizar la conexion
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }


    //metodo para realizar las consultas
    private static int selectNumero(){
        int num2 = 0;

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            if (conn != null) {
                String query = "SELECT * FROM NumeroGuardado ";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, 1);



                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    num2 = rs.getInt("numero");
                    System.out.println("NumeroGuardado = " + num2);
                }
            }


        }catch (Exception e){
            showExecptionMessage("No se ha podido realizar la consulta");
        }

        return num2;
    }

    private static void showExecptionMessage(String message){
        System.out.println(message);
    }

    // metodo para cerrar la conexion
    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
