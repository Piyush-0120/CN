package UDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
        while(true){
            String inp = sc.nextLine();
            buf = inp.getBytes();
            DatagramPacket dpSend = new DatagramPacket(buf, buf.length,ip,6000);
            ds.send(dpSend);
            if(inp.equals("bye"))
                break;
        }

        ds.close();
        sc.close();
    }
}
