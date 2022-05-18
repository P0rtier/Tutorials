package exercise3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket sSocket = new ServerSocket(2190);
            System.out.println("Server started");
            Socket mainSocket = sSocket.accept();
            System.out.println("User connected");

            ObjectInputStream inFromClient = new ObjectInputStream(mainSocket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(mainSocket.getOutputStream());

            while(true) {
                outToClient.writeObject("Choose option: \n1.Upper case\n2.Lower case\n3.stop");
                String option = (String) inFromClient.readObject();
                outToClient.writeObject("Argument?: ");
                String message = (String) inFromClient.readObject();
                switch (option) {
                    case "Upper case":
                        message = message.toUpperCase();
                        break;
                    case "Lower case":
                        message = message.toLowerCase();
                        break;
                    case "stop":
                            mainSocket.close();
                            sSocket.close();
                            return;
                    default:
                        break;

                }
                outToClient.writeObject("Result " + message+"\n");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
