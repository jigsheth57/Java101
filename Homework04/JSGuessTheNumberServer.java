import java.io.*;
import java.util.*;
import java.net.*;

public class JSGuessTheNumberServer {

    // Vector to store active clients
    static Vector<ClientHandler> ar = new Vector<>();

    // counter for clients
    static int i = 0;

    public static void main(String[] args) {
        try {
            // server is listening on port 1234
            ServerSocket ss = new ServerSocket(1234);

            Socket s;
            System.out.println("Server started on port 1234.");

            // running infinite loop for getting
            // client request
            while (true) {
                // Accept the incoming request
                s = ss.accept();

                System.out.println("New client request received : " + s);

                // obtain input and output streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Creating a new handler for this client...");

                // Create a new handler object for handling this request.
                ClientHandler mtch = new ClientHandler(s, "client " + i, dis, dos);

                // Create a new Thread with this object.
                Thread t = new Thread(mtch);

                System.out.println("Adding this client to active client list");

                // add this client to active clients list
                ar.add(mtch);

                // start the thread.
                t.start();

                // increment i for new client.
                // i is used for naming only, and can be replaced
                // by any naming scheme
                i++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

// ClientHandler class
class ClientHandler implements Runnable {
    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    // constructor
    public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin = true;
    }

    @Override
    public void run() {

        int[] range = new int[] { 5, 10 };
        JSGuessTheNumber jsGuessTheNumber = new JSGuessTheNumber(range[0], range[1]);
        String received;
        while (true) {
            try {
                boolean matched = false;
                dos.writeUTF("name: " + name);
                boolean cont = false;
                do {
                    jsGuessTheNumber.newNumber2Guess();
                    System.out.println("guessnumber: " + jsGuessTheNumber.getNumber2Guess());
                    do {
                        dos.writeUTF("Guess the number between " + range[0] + ":" + range[1]);
                        received = dis.readUTF();
                        System.out.println(received);
                        int userGuess = Integer.parseInt(received);
                        matched = jsGuessTheNumber.isMatch(userGuess);
                    } while (!matched);
                    dos.writeUTF("You guessed it!");
                    dos.writeUTF("Do you want to play a new game? (yes/no)"); // prompt user to input yes or no
                    received = dis.readUTF();
                    cont = received.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
                } while (cont);
                dos.writeUTF("#close");
                this.s.close();
                break;
            } catch (IOException e) {
                // e.printStackTrace();
            }

        }
        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
}
