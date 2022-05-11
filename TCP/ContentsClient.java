import java.io.*;
import java.net.*;
public class ContentsClient
{
    public static void main(String args[])throws IOException
    {
        Socket socket = new Socket("127.0.0.1",4000);
        System.out.println("Enter the file name");
        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
        String fName = keyReader.readLine();
        
        PrintWriter pWriter = new PrintWriter(socket.getOutputStream(),true);
        pWriter.println(fName);

        BufferedReader sockeReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str;
        while((str = sockeReader.readLine())!=null){
            System.out.println(str);
        }
        pWriter.close();
        sockeReader.close();
        keyReader.close();
        socket.close();
    }
}