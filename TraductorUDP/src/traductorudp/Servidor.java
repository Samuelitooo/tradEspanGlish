package traductorudp;

import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;

public class Servidor {

    public static void main(String[] args) throws Exception {
        try {
            while (true) {
                System.out.println("***Servidor activo***\n");
                DatagramSocket ds = new DatagramSocket(3000);
                
                byte[] buf0 = new byte[1024];//creamos un buffer
                DatagramPacket listo = new DatagramPacket(buf0, 1024);//datagrama para el paquete 1

                ds.receive(listo);//recibimos el tipo de traduccion
                String list = new String(listo.getData(), 0, listo.getLength());//desempaquetamos el paquete
                
                InetAddress ip = listo.getAddress();//obtenemos la ip del cliente
                int puerto = listo.getPort();//obtenemos el puerto
                
                System.out.println("Conexion establecida con el cliente!");

                byte[] buf = new byte[1024];//creamos un buffer
                DatagramPacket tipo = new DatagramPacket(buf, 1024);//datagrama para obtener el tipo de traduccion

                ds.receive(tipo);//recibimos el tipo de traduccion
                String tip = new String(tipo.getData(), 0, tipo.getLength());//desempaquetamos el paquete
                
                if(tipo.equals("3")){
                    ds.close();
                }

                DatagramPacket palabra = new DatagramPacket(buf, 1024);//datagrama para la palabra a traducir
                
                ds.receive(palabra);//recibimos la palabra
                String pal = new String(palabra.getData(), 0, palabra.getLength());//desempaquetamos el paquete
                
                dataTRS obj = new dataTRS();//creamos un constructor de la clase
                String resp = obj.traducir(pal, tip);//llamamos a un metodo de la clase y obtenemos el retorno
                
                byte[] buffertraduccion = resp.getBytes();
                DatagramPacket traduccion = new DatagramPacket(buffertraduccion, buffertraduccion.length,ip,puerto);//empaquetamos la respuesta
                ds.send(traduccion);//enviamos al respuesta
                
                ds.close();//cerramos la conexion

            }
        } catch (SocketException e) {
            System.out.println(e);
        }

    }
}
