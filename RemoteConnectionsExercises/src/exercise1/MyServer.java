package exercise1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class MyServer {
    public static void main(String[] args) {
        try {
            // -Creating-ServerSocket-and-handling-with-creation-
            ServerSocket welcome = new ServerSocket(2190);
            System.out.println("Server started");
            Socket socket = welcome.accept();
            System.out.println("Client connected");

            //-Instatiating-Streams
            ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

            //-Core-of-the-program-(Zamiana wiadomosci na uppercase)
            String msg = (String) inFromClient.readObject();
            System.out.println("Received " + msg);
            msg = msg.toUpperCase();
            System.out.println("Sending msg: " + msg);

            //Sending-the-result-to-the-remote-client
            outToClient.writeObject(msg);


            System.out.println("Client disconnected");

        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
