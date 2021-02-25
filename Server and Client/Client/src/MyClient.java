import java.net.*;
import java.io.*;
public class MyClient
{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    // constructor to put ip address and port
    public MyClient(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException u){
            System.out.println(u);
        }

        String line = "";
        String newLine = "";
        while (!line.equalsIgnoreCase("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
                out.flush();

                newLine = in.readUTF(); //throws exception (End of File)
                System.out.println(newLine);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        try
        {
            input.close();
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        MyClient client = new MyClient("127.0.0.1", 5000);
    }
}

