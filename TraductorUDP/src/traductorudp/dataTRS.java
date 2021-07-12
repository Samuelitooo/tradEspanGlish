package traductorudp;

import java.io.*;

public class dataTRS {

    public String traducir(String palabra, String dato) {
        String linea;
        int cent = 0;

        if (dato.equals("1")) {
            System.out.println("\nTraducir del Ingles al Espaniol");

            try (BufferedReader br = new BufferedReader(new FileReader("palabras.txt"))) {

                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("=");
                    cent++;

                    if (partes[1].equals(palabra)) {
                        System.out.println("\n***Palabra encontrada***\n");
                        System.out.println("Palabra: " + palabra);
                        System.out.println("Traduccion: " + partes[0] + "\n");
                        cent = -1;
                        return partes[0];
                    }
                }

                if (cent != -1) {
                    System.out.println("***Palabra no encontrada***\n");
                }
            } catch (IOException e) {
                System.out.println("No se pudo acceder al fichero");
                e.printStackTrace();
            }
        } else {
            if (dato.equals("2")) {
                System.out.println("\nTraducir del Espaniol al Ingles");

                try (BufferedReader br = new BufferedReader(new FileReader("palabras.txt"))) {

                    while ((linea = br.readLine()) != null) {
                        String[] partes = linea.split("=");

                        if (partes[0].equals(palabra)) {
                            System.out.println("***Palabra encontrada***\n");
                            System.out.println("Palabra: " + palabra);
                            System.out.println("Traduccion: " + partes[1] + "\n");
                            cent = -1;
                            return partes[1];
                        }
                    }

                    if (cent != -1) {
                        System.out.println("***Palabra no encontrada***\n");                        
                    }
                } catch (IOException e) {
                    System.out.println("No se pudo acceder al fichero");
                    e.printStackTrace();
                }

            } else {
                if (dato.equals("3")) {
                    System.out.println("Error!  Opcion incorrecta!");
                }
            }
        }

        return "";
    }
}
