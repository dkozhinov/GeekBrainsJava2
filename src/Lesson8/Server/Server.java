package Lesson8.Server;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Java. Level 2. Lesson 8. Homework.
 *
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-04
 * @modify by Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 09.03.2019
 */


public class Server
{
    private List<ClientHandler> clientHandlers = new ArrayList<>();

    public Server()
    {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try
        {
            serverSocket = new ServerSocket(8899);
            System.out.println("Server launched");

            while (true)
            {
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clientHandlers.add(client);
                new Thread(client).start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                serverSocket.close();
                clientSocket.close();
                System.out.println("Server finished");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }

    public void notificationAllClientWithNewMessage(String msg)
    {
        for (ClientHandler clientHandler : clientHandlers)
        {
            clientHandler.sendMessage(msg);
        }

    }

    public void removeClient(ClientHandler clientHandler)
    {
        clientHandlers.remove(clientHandler);
    }


}
