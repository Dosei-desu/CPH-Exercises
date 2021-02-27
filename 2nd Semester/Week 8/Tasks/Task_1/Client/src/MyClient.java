/**
 * Skriv en klient som har 2 tråde. Den første tråd skal håndere indput fra serveren og den anden tråd skal sørge for at
 * tage imod input fra klienten. Altså en tråd til at sende og modtage med.
 *
 * Ekstra til denne opgave:
 *
 *     Implementer en loginfunktionalitet som vi allerede har talt om
 *     Sørg for at der ikke er race condition og deadlocks i koden
 *     Evt. overvej om I kan gemme brugernavne og passwords i filer på serveren
 */

import java.net.*;
import java.io.*;

public class MyClient
{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private boolean run = true;

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
        catch(IOException u){
            System.out.println(u);
        }

        while (run)
        {
            Thread outThread = new Thread(new OutThread());
            outThread.start();
            Thread inThread = new Thread(new InThread());
            inThread.start();
            outThread.join();
            inThread.join();
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

    class OutThread implements Runnable{
        @Override
        public void run(){
            try {
                String line = input.readLine();
                out.writeUTF(line);
                out.flush();
                if(line.equalsIgnoreCase("Over")){ //this is the alternative to using "line" to control the while loop
                    run = false;
                }
            }
            catch (IOException ex){
                System.out.println(ex);
            }
        }
    }

    class InThread implements Runnable{
        @Override
        public void run(){
            try {
                String line = in.readUTF(); //throws exception (End of File)
                System.out.println(line);
            }
            catch (IOException ex){
                System.out.println(ex);
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        MyClient client = new MyClient("127.0.0.1",5000);
    }
}
