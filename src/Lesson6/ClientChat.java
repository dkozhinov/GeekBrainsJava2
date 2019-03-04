package Lesson6;

import java.io.*;
import java.net.Socket;

/**
 * Java. Level 2. Lesson 6. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 03.03.2019
 */

public class ClientChat {

    private final String SERVER_ADDRESS = "localhost" ;
    private final int SERVER_PORT = 3345 ;
    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private BufferedReader bufferedReader;
    private String outputMessage, inputMessage;





    public void start() {

        // Open Chat connection
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from DataInputStream
        Thread readingClientTread = new ReadingClientThread();
        readingClientTread.start();


        // Writing to the DataOutputStream
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (!socket.isOutputShutdown()) {
                if (bufferedReader.ready()) {
                    inputMessage = bufferedReader.readLine();

                    dataOutputStream.writeUTF(inputMessage);
                    dataOutputStream.flush();
                    System.out.println("Client sent message [" + inputMessage + "]");
                    Thread.sleep(1000);

                    if (inputMessage.equalsIgnoreCase("quit")) {
                        System.out.println("Client kill connection.");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Close Chat connection
        try {
            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Client connected with server.");
    }


    private void closeConnection() throws IOException {
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        System.out.println("Connection is closed.");
    }


    // Internal class Thread for reading from DataInputStream
    class ReadingClientThread extends Thread {
        @Override
        public void run() {
            try {
                while (!socket.isOutputShutdown()) {
                    outputMessage = dataInputStream.readUTF();
                    System.out.println("Read info from server [" + outputMessage + "]");
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
