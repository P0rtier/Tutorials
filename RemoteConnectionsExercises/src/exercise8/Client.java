package exercise8;

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

            String msg = (String) inFromServer.readObject();
            System.out.println(msg);
            Scanner scanner = new Scanner(System.in);
            while(true){
                msg = (String) inFromServer.readObject();
                System.out.println(msg);
                String answer = scanner.nextLine();
                System.out.println("You: "+answer);
                if(answer.equals("stop"))
                    break;
                outToServer.writeObject(answer);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
