package exercise1;

import java.io.IOException;
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

            outToServer.writeObject("Hello");
            String responsee = (String) inFromServer.readObject();
            System.out.println(responsee);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
