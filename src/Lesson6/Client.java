package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("Localhost",80);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Thread inputService1 = new Thread(()->{
            while (true) {
                try {
                    String message = in.readUTF();
                    if (message.equals("quit")) {
                        System.out.println("Shut Down");
                        break;
                    }
                    System.out.println("Message from client " + message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        inputService1.setDaemon(true);
        inputService1.start();
        Scanner input = new Scanner(System.in);
        while (true && !inputService1.isInterrupted()) {
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
        socket.close();
    }
}
