package WSClient;

import WSClient.controller.ClientRequestController;
import java.util.Scanner;

public class ClientMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        ClientRequestController cc = new ClientRequestController();
        int opcion = 0;
        do {
            System.out.println("\n\n --- Elija una opcion ---");
            System.out.println("1. Ver todos los paseos");
            System.out.println("2. Eliminar un paseo");
            System.out.println("3. Editar origen y destino de un paseo");
            System.out.println("4. Crear paseo");
            System.out.println("5. Salir");
            System.out.println("============================================");
            opcion = scanner.nextInt();
            System.out.println();
            switch (opcion)
            {
                case 1:
                    cc.findAll();
                    break;
                case 2:
                    cc.deletePaseo();
                    break;
                case 3:
                    cc.updatePaseo();
                    break;
                case 4:
                    cc.createPaseo();
                    break;
                default:
                    opcion=5;
            }
        } while(opcion!=5);
    }




}
