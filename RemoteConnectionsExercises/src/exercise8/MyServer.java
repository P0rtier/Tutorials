package exercise8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2190);
            Socket mainSocket = serverSocket.accept();

            ObjectInputStream inFromClient = new ObjectInputStream(mainSocket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(mainSocket.getOutputStream());

            System.out.println("\nWitaj w Traugutosserze!\n\n");
            outToClient.writeObject("\nWitaj w Traugutosserze!\n\n");

            Scanner scanner = new Scanner(System.in);
            String answer,msg;
            while(true){
                msg = scanner.nextLine();
                if(msg.equals("stop"))
                    break;
                System.out.println("Server: "+msg);
                outToClient.writeObject("Server: "+msg);
                answer = (String) inFromClient.readObject();
                System.out.println("Client: "+answer);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
