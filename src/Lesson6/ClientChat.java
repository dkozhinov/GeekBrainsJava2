package Lesson6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Java. Level 2. Lesson 6. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 03.03.2019
 */

public class ClientChat {
    public static void main(String[] args)
    {
        try (Socket s = new Socket("localhost", 3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(s.getInputStream()))
        {

            System.out.println("Client connected with server.");

            while (!s.isOutputShutdown())
            {
                if (br.ready())
                {
                    String msg = br.readLine();

                    dataOutputStream.writeUTF(msg);
                    dataOutputStream.flush();
                    System.out.println("Client sent message=" + msg);

                    if (msg.equalsIgnoreCase("quit")) {
                        System.out.println("Client kill connection.");
                        break;
                    }

                }
            }

            System.out.println("Connection is closed.");
        }
        catch (Exception e)
        {

        }

    }

}
