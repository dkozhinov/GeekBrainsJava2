package Lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Java. Level 2. Lesson 6. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 03.03.2019
 */

public class ServerChat {
    private ServerSocket serverSocket;
    private Socket socket;
    private final int SERVER_PORT = 3345 ;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private BufferedReader bufferedReader;
    private String readingMessage, writingMessage;




    public void start() {

        // Open Chat connection
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Reading from DataInputStream
        Thread readingServerTread = new ServerChat.ReadingServerThread();
        readingServerTread.start();

/*
        // Writing to the DataOutputStream
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                if (bufferedReader.ready()) {
                    writingMessage = bufferedReader.readLine();

                    dataOutputStream.writeUTF(writingMessage);
                    dataOutputStream.flush();
                    System.out.println("Server sent message [" + writingMessage + "]");
                    Thread.sleep(1000);

                    if (writingMessage.equalsIgnoreCase("quit")) {
                        System.out.println("Server kill connection.");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

*/
        // Close Chat connection
        try {
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    private void openConnection() throws Exception {
        serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is started.");
        // We waiting connection with client.
        Socket socket = serverSocket.accept();
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Thread.sleep(3000);
        System.out.println("Connection was successful statemented.");

    }


    private void closeConnection() throws Exception {
        Thread.sleep(3000);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        System.out.println("Connection is closed.");
        System.out.println("Server is stopped.");

    }


    // Internal class Thread for reading from DataInputStream
    class ReadingServerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    readingMessage = dataInputStream.readUTF();
                    System.out.println("Read info from client [" + readingMessage + "]");
                    Thread.sleep(1000);
                    if (readingMessage.equalsIgnoreCase("quit"))
                    {
                        System.out.println("Received [quit] message from client and session will be closed.");
                        dataOutputStream.writeUTF("Received [quit] message from client and session will be closed.");
                        dataOutputStream.flush();
                        break;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new ServerChat().start();
    }

}
