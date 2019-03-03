package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Java. Level 2. Lesson 6. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 03.03.2019
 */

public class ServerChat {

    public static void main(String[] args)
    {
        try
        {
            System.out.println("Server is started.");
            //Server starts on port 3345
            ServerSocket server = new ServerSocket(3345);

            // We waiting connection with client.
            Socket client = server.accept();
            System.out.println("Connection was successful statemented.");

            // Stream uses to send message
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            // Stream uses to receive message
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());

            while (!client.isClosed())
            {
                dataOutputStream.writeUTF("Server is waiting info from client...");
                dataOutputStream.flush();
                System.out.println("Server is waiting info from client...");

                String inputMessage = dataInputStream.readUTF();
                System.out.println("Read info from client [" + inputMessage + "]");
                dataOutputStream.writeUTF("Server accept message [" + inputMessage + "] from client.");
                dataOutputStream.flush();

                if (inputMessage.equalsIgnoreCase("quit"))
                {
                    System.out.println("Received [quit] message from client and session will be closed.");
                    dataOutputStream.writeUTF("Received [quit] message from client and session will be closed.");
                    dataOutputStream.flush();
                    break;
                }

            }

            System.out.println("Client disconnected");
            dataInputStream.close();
            dataOutputStream.close();
            client.close();
            System.out.println("Server is stopped.");

        }
        catch (IOException e)
        {
            System.out.println("Something is wrong!");
            e.printStackTrace();
        }
    }
}
