package traductorudp;

import java.util.Scanner;

public class dataTRC {

    Scanner sc = new Scanner(System.in);

    public String tipo() {

        System.out.println("***Bienvenido al traductor UDP***\n");
        System.out.println("1) Ingles - Espaniol");
        System.out.println("2) Espaniol - Ingles");
        System.out.println("3) Salir");
        System.out.println("Opcion--->");
        String opc = sc.nextLine();

        return opc;
    }

    public String palabra() {

        System.out.print("\nIngrese la palabra: ");
        String opc = sc.nextLine();

        return opc;
    }
}
