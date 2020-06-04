package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        System.out.println(server.getInetAddress());
        Socket connected = server.accept();
        DataInputStream in = new DataInputStream(connected.getInputStream());
        DataOutputStream out = new DataOutputStream(connected.getOutputStream());
        Scanner input =new Scanner(System.in);

        Thread inputService = new Thread(()->{
            while (true) {
                String clientMessage = null;
                try {
                    clientMessage = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (clientMessage.equals("quit")) {
                    System.out.println("Shut Down");
                    break;
                }
                System.out.println("Message from client " + clientMessage);
            }
        });
        inputService.setDaemon(true);
        inputService.start();


        while (true) {
            String message = input.nextLine();
            if (message.equals("quit")) {
                System.out.println("Finished");
                out.writeUTF(message);
                out.flush();
                break;
            }
            out.writeUTF(message);
            out.flush();
        }
        server.close();
        connected.close();
    }
}