import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MyClient
{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private String line = "";

    // constructor to put ip address and port
    public MyClient(String address, int port) throws InterruptedException {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u) //although it is a sub-IOException, this is used to catch specifically UnknownHost
        {
            System.out.println(u);
        }
        catch(IOException u){
            System.out.println(u);
        }

        Scanner scanner = new Scanner(System.in);

        Thread outThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!line.equalsIgnoreCase("Over")) {
                    line = scanner.nextLine();
                    try {
                        out.writeUTF(line);
                        out.flush();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });

        Thread inThread = new Thread(new Runnable(){
            @Override
            public void run(){
                while(!line.equalsIgnoreCase("Over")) {
                    try {
                        String receivedLine = in.readUTF();
                        System.out.println(receivedLine);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });

        outThread.start();
        inThread.start();

        if(line.equals("Over")) {
            try {
                input.close();
                in.close();
                out.close();
                socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        MyClient client = new MyClient("127.0.0.1",5000);
    }
}
