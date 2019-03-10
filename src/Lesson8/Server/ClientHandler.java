package Lesson8.Server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Java. Level 2. Lesson 8. Homework.
 *
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-04
 * @modify by Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 09.03.2019
 */

public class ClientHandler implements Runnable
{
  private Socket clientSocket;
  private Server server;
  private PrintWriter outMsg;
  private Scanner inMsg;
  private static int clientCount = 0;


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
      server.notificationAllClientWithNewMessage("Count of client in chat :" + clientCount);


      while (true)
      {
        if (inMsg.hasNext())
        {
          String clientMsg = inMsg.nextLine();
          if (clientMsg.matches(".*[Qq][Uu][Ii][Tt]$"))
          {
            System.out.println("Client send QUIT!!!");
            break;
          }
          System.out.println(clientMsg);
          server.notificationAllClientWithNewMessage(clientMsg);
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
    server.notificationAllClientWithNewMessage("Client is out of our chat.");
    server.notificationAllClientWithNewMessage("Count of client in chat :" + clientCount);
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
