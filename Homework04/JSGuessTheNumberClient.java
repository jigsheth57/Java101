import java.io.*;
import java.net.*;
import java.util.Scanner;

public class JSGuessTheNumberClient {
    final static int ServerPort = 1234;

    public static void main(String args[]) throws UnknownHostException, IOException {
        Scanner scn = new Scanner(System.in);

        // getting localhost ip
        InetAddress ip = InetAddress.getByName("localhost");

        // establish the connection
        Socket s = new Socket(ip, ServerPort);

        // obtaining input and out streams
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        // sendMessage thread
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    // read the message to deliver.
                    String msg = scn.nextLine();

                    try {
                        // write on the output stream
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        break;
                        // e.printStackTrace();
                    }
                }
            }
        });

        // readMessage thread
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean cont = true;
                while (cont) {
                    try {
                        // read the message sent to this client
                        String msg = dis.readUTF();
                        System.out.println(msg);
                        if (msg.equals("#close"))
                            cont = false;
                    } catch (IOException e) {
                        cont = false;
                        break;
                        // e.printStackTrace();
                    }
                }
                Thread.currentThread().interrupt();
                return;
            }
        });

        sendMessage.start();
        readMessage.start();
    }

}