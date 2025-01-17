package calculadoraBD;

import java.util.Scanner;

public interface InterfazMenu {

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
                    MetodosFicheros.sumar();
                    break;
                case 2:
                    MetodosFicheros.guardarEnMemoria();
                    break;

                default:
                    System.out.println("Opción introducida no valida");
                    break;
            }
        }while (opcion != 0);

    }
}
