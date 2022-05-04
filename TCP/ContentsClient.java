package TCP;
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
        OutputStream oStream = socket.getOutputStream();
        PrintWriter pWriter = new PrintWriter(oStream,true);
        pWriter.println(fName);
        InputStream iStream = socket.getInputStream();
        BufferedReader sockeReader = new BufferedReader(new InputStreamReader(iStream));

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