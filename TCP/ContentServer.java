package TCP;
import java.io.*;
import java.net.*;

public class ContentServer {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server ready for connection");
        Socket socket = serverSocket.accept();
        System.out.println("Connection is successfull and waiting for chatting");
        InputStream iStream = socket.getInputStream();

        BufferedReader filReader = new BufferedReader(new InputStreamReader(iStream));
        String fname = filReader.readLine();
        BufferedReader contentReader = new BufferedReader(new FileReader(fname));

        OutputStream oStream = socket.getOutputStream();
        PrintWriter pWriter = new PrintWriter(oStream,true);

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
