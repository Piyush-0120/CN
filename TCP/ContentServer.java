import java.io.*;
import java.net.*;

public class ContentServer {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server ready for connection");
        Socket socket = serverSocket.accept();
        System.out.println("Connection is successfull and waiting for chatting");

        BufferedReader filReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String fname = filReader.readLine();
        BufferedReader contentReader = new BufferedReader(new FileReader(fname));

        PrintWriter pWriter = new PrintWriter(socket.getOutputStream(),true);
        String str;
        while((str = contentReader.readLine())!=null){
            pWriter.println(str);
        }

        socket.close();
        serverSocket.close();
        pWriter.close();
        filReader.close();
        contentReader.close();

    }    
}
