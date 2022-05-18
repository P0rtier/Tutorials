package exercise3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",2190);

            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            while(true) {
                System.out.println((String) inFromServer.readObject());
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                if(msg.equals("stop"))
                    break;
                outToServer.writeObject(msg);
                System.out.println((String) inFromServer.readObject());
                scanner.reset();
                msg = scanner.nextLine();
                outToServer.writeObject(msg);
                System.out.println((String) inFromServer.readObject());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
