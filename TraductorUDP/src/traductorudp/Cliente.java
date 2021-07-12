package traductorudp;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws Exception {

        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(null);

            String mens = "listo";
            DatagramPacket dp0 = new DatagramPacket(mens.getBytes(), mens.length(), ip, 3000);
            ds.send(dp0);

            byte[] buf = new byte[1024];
            DatagramPacket dp3 = new DatagramPacket(buf, 1024);

            dataTRC obj = new dataTRC();
            String tipo = obj.tipo();

            DatagramPacket dp = new DatagramPacket(tipo.getBytes(), tipo.length(), ip, 3000);
            ds.send(dp);

            if (tipo.equals("1")) {
                System.out.print("\n***Traducir del Ingles al Espaniol***");

                String palabra = obj.palabra();

                DatagramPacket dp2 = new DatagramPacket(palabra.getBytes(), palabra.length(), ip, 3000);
                ds.send(dp2);

                ds.receive(dp3);
                String resp = new String(dp3.getData(), 0, dp3.getLength());
                System.out.println("Respuesta: " + resp);

            } else {
                if (tipo.equals("2")) {
                    System.out.print("\n***Traducir del Espaniol al Ingles***");

                    String palabra = obj.palabra();

                    DatagramPacket dp2 = new DatagramPacket(palabra.getBytes(), palabra.length(), ip, 3000);
                    ds.send(dp2);

                    ds.receive(dp3);
                    String resp = new String(dp3.getData(), 0, dp3.getLength());
                    System.out.println("Respuesta: " + resp);

                } else {
                    if (tipo.equals("3")) {
                        System.out.println("\nSe ha detenido la conexion con el servidor!");
                        ds.close();
                    }
                }
            }

        } catch (SocketException e) {
            System.out.println(e);
        }

    }
}
