import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MyServer
{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    public MyServer(int port)
    {
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client...");
            socket = server.accept();
            System.out.println("Client accepted");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            boolean jokemode = false;
            String line = "";
            while (!line.equalsIgnoreCase("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);

                    //Are you here?
                    if(line.equalsIgnoreCase("are you here?") || line.equalsIgnoreCase("are you there?")){
                        out.writeUTF("I'm listening.");
                    }

                    //Jokey-joke
                    else if(line.equalsIgnoreCase("knock knock")){
                        jokemode = true;
                        out.writeUTF("Who's there?");
                        if (jokemode){
                            line = in.readUTF();
                            out.writeUTF(line+" who?");
                            in.readUTF(); //necessary to avoid having the messages become out of sync of each other
                            out.writeUTF("*Groan*");
                            jokemode = false;
                        }
                    }

                    //Tell me a joke
                    else if(line.equalsIgnoreCase("tell me a joke") || line.equalsIgnoreCase("joke")){
                        out.writeUTF(joke());
                    }

                    //Calculator
                    else if(line.toLowerCase().contains("cal") && line.split(" ").length == 4) {
                        out.writeUTF(calc(line.split(" ")[1], line.split(" ")[2], line.split(" ")[3]));
                    }

                    else if(!line.equalsIgnoreCase("over")) //ignores "over"
                    {
                        out.writeUTF("(._.')"); //workaround for the blocking-call of read/write
                    }

                    out.flush();
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
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
        MyServer server = new MyServer(5000);
    }

    public String joke(){
        ArrayList<String> jokes = new ArrayList<>();
        Random rnd = new Random();
        jokes.add("What rock group has four men that don’t sing? Mount Rushmore.");
        jokes.add("A guy goes to his doctor because he can see into the future. The doctor asks him, " +
                "“How long have you suffered from that condition?” The guy tells him, “Since next Monday.”");
        jokes.add("Did you hear the rumor about butter? Well, I'm not going to spread it!");
        jokes.add("Want to hear a joke about construction? I'm still working on it!");
        jokes.add("How do you make a Kleenex dance? Put some boogie in it!");
        jokes.add("Why do vampires seem sick? They’re always coffin.");
        jokes.add("Did I tell you the time I fell in love during a backflip? I was heels over head!");
        jokes.add("The difference between a numerator and a denominator is a short line. Only a fraction of people will understand this!");
        jokes.add("I invented a new word today: Plagiarism!");
        jokes.add("My hotel tried to charge me ten dollars extra for air conditioning. That wasn't cool.");
        jokes.add("Why do trees seem suspicious on sunny days? They just seem a little shady!");
        jokes.add("I never buy pre-shredded cheese. Because doing it yourself is grate.");

        return jokes.get(rnd.nextInt(jokes.size()));
    }

    public String calc(String value1, String operator, String value2){
        double result = 0;
        if(operator.contains("+")){
            result = (Double.parseDouble(value1) + Double.parseDouble(value2));
        }
        if(operator.contains("-")){
            result = (Double.parseDouble(value1) - Double.parseDouble(value2));
        }
        if(operator.contains("*")){
            result = (Double.parseDouble(value1) * Double.parseDouble(value2));
        }
        if(operator.contains("/")){
            result = (Double.parseDouble(value1) / Double.parseDouble(value2));
        }
        return ""+result;
    }
}