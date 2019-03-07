package Lesson7;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Java. Level 2. Lesson 7. Homework.
 *
 * @modify by Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 07.03.2019
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-04
 *
 */

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Server server;
    private PrintWriter outMsg;
    private Scanner inMsg;
    private static int clientCount = 0;
    private String name;

    private final String regexStartOfLineWithNickName = "^/[wW] \\w+";


    public String getName() {
        return this.name;
    }

    public ClientHandler(Socket clientSocket, Server server)
    {
        try
        {
            clientCount++;
            this.clientSocket = clientSocket;
            this.server = server;
            this.outMsg = new PrintWriter(clientSocket.getOutputStream());
            this.inMsg = new Scanner(clientSocket.getInputStream());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        try
        {
            server.notificationAllClientWithNewMessage("New client in our chat");
            server.notificationAllClientWithNewMessage("In our chat = " + clientCount + "clients!");


            while (true)
            {
                if (inMsg.hasNext())
                {
                    String clientMsg = inMsg.nextLine();
                    if (clientMsg.equalsIgnoreCase("QUIT"))
                    {
                        break;
                    }
                    else if (clientMsg.matches(regexStartOfLineWithNickName))
                    {
                        String[] array = clientMsg.split("\\s+");
                        String userName = array[1];
                        array = clientMsg.split(regexStartOfLineWithNickName);
                        String textMessage = array[1];
                        System.out.println(clientMsg + " (userName=" + userName + " textMessage=" + textMessage + ")");
                        if (server.notificationClientWithNewMessage(textMessage, userName)) {
                            System.out.println("Message was sent successfully to " + userName + ".");
                        }
                        else {
                            System.out.println("Message was not sent to " + userName + ".");
                        }
                    }
                    else {
                        System.out.println(clientMsg);
                        System.out.println("Message was sent successfully to all users.");
                        server.notificationAllClientWithNewMessage(clientMsg);
                    }
                }
            }

            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            exitFromChat();
        }

    }

    private void exitFromChat()
    {
        clientCount--;
        server.notificationAllClientWithNewMessage("Client exited. In out chat = " + clientCount + " clients!");
        server.removeClient(this);
    }

    public void sendMessage(String msg)
    {
        try
        {
            outMsg.println(msg);
            outMsg.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
