package org.tanzuapps.guessnumber;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class JSGuessTheNumberClient {
    final static int ServerPort = 1234;

    public static void main(String args[]) throws UnknownHostException, IOException {

        // getting localhost ip
        InetAddress ip = InetAddress.getByName("192.168.86.31");

        // establish the connection
        Socket s = new Socket(ip, ServerPort);

        // obtaining input and out streams
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        // sendMessage thread
        Thread sendMessage = new Thread(new Runnable() {
            Scanner scn = new Scanner(System.in);

            @Override
            public void run() {
                boolean cont = true;
                while (cont) {
                    // read the message to deliver.
                    String msg = scn.nextLine();
                    try {
                        // write on the output stream
                        dos.writeUTF(msg);
                        if (msg.matches("(n|N|no|NO|Nope|nope|NOPE)"))
                            cont = false;
                    } catch (IOException e) {
                        cont = false;
                        break;
                        // e.printStackTrace();
                    }
                }
                scn.close();
                Thread.currentThread().interrupt();
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
                        if (msg.equals("#close")) {
                            s.close();
                            cont = false;
                        } else {
                            System.out.println(msg);
                        }
                    } catch (IOException ie) {
                        cont = false;
                        try {
                            s.close();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                        // e.printStackTrace();
                    }
                }
                Thread.currentThread().interrupt();
            }
        });
        sendMessage.start();
        readMessage.start();
    }

}