package AccesoDatos;

import java.sql.*;

public class DbManager {

    //establecer los parametros de conexion
    static String URL = "jdbc:mysql://localhost:3306/bdejCaluculadora";
    static String USER = "user";
    static String PASSWORD = "user";
    private Connection conn = null;

    //metodo para realizar las consultas
    private static int selectNumero(){

        int num2 = 0;

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            if (conn != null) {
                String query = "SELECT * FROM NumeroGuardado ";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, 1);

                System.out.println("CONSULTA ===> " + stmt.toString());

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    num2 = rs.getInt("numero");
                    System.out.println("NumeroGuardado = " + rs.getObject("numero"));

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
