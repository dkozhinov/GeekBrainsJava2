package Lesson8.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Java. Level 2. Lesson 4. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 23.02.2019
 */


// Создать окно для клиентской части чата: большое текстовое поле для отображения переписки
// в центре окна. Однострочное текстовое поле для ввода сообщений и кнопка для отсылки
// сообщений на нижней панели. Сообщение должно отсылаться либо по нажатию кнопки на
// форме, либо по нажатию кнопки Enter. При «отсылке» сообщение перекидывается из нижнего
// поля в центральное.

public class ChatClientWindow extends JFrame {

    private JLabel labelCountOfClient = new JLabel();
    // Инициализация панели с блочным расположением
    private Box boxContent = new Box(BoxLayout.Y_AXIS);
    private Box boxContentForNickNameAndTextField = new Box(BoxLayout.X_AXIS);
    // Инициализация текстового поля для отображения переписки
    private JTextArea textArea = new JTextArea(15,40);
    // Инициализация однострочного текстового поля для ввода сообщений
    private JTextField textField = new JTextField("");
    // Инициализация однострочного текстового поля для имени пользователя
    private JTextField textNickName = new JTextField("");
    // Инициализация кнопки отправки сообщения
    private JButton button = new JButton("Отправить сообщение");

    private final String SERVER_HOST = "localhost";
    private final int SERVER_PORT = 8888;
    private Socket clientSocket;
    private Scanner inMsg;
    private PrintWriter outMsg;



    public ChatClientWindow() throws HeadlessException {

        super("Окно для клиентской части чата");

        try
        {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMsg = new Scanner(clientSocket.getInputStream());
            outMsg = new PrintWriter(clientSocket.getOutputStream());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        setDefaultCloseOperation( EXIT_ON_CLOSE );


        // Размещение в панели с блочным расположением
        boxContent.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
        labelCountOfClient.setText("Count of client in chat :");
        boxContent.add(labelCountOfClient, BorderLayout.NORTH);

        // Размещение текстового поля для отображения переписки
        textArea.setToolTipText("Окно для отображения переписки");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        boxContent.add(textAreaScrollPane);
        boxContent.add(Box.createVerticalStrut(20));


        // Делаем текстовое поле в одну строку
        final Dimension maxSize = textField.getMaximumSize();
        maxSize.height = textField.getPreferredSize().height;

        // Размещение однострочного текстового поля для ввода NickName
        textNickName.setToolTipText("Поле для ввода имени пользоватея");
        textNickName.setEditable(true);
        textNickName.setMaximumSize(maxSize);
        boxContentForNickNameAndTextField.add(textNickName);

        // Размещение однострочного текстового поля для ввода сообщений
        textField.setToolTipText("Поле для отправки сообщения");
        textField.setEditable(true);
        textField.setHorizontalAlignment(JTextField.LEFT);
        textField.setMaximumSize(maxSize);
        textField.requestFocus();
        textField.addActionListener(new ListenerAction());
        boxContentForNickNameAndTextField.add(textField);

        // Размещение кнопки отправки сообщения
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ListenerAction());
        boxContentForNickNameAndTextField.add(button);

        boxContent.add(boxContentForNickNameAndTextField);
        boxContent.add(Box.createVerticalStrut(10));



        // Вывод окна на экран
        setContentPane(boxContent);
        setSize(800, 600);
        setVisible(true);


        new Thread(new Runnable()
        {
            @Override
            public void run()
            {

                while (true)
                {
                    if (inMsg.hasNext())
                    {
                        String msg = inMsg.nextLine();
                        String clientInChat = "Count of client in chat :";
                        if (msg.indexOf(clientInChat) == 0)
                        {
                            labelCountOfClient.setText(msg);
                        }
                        else
                        {
                            textArea.append(msg + "\n");
                        }

                    }
                }
            }
        }).start();




    }

    // Общий внутренний класс (т.е. вложенный нестатический класс) обработки событий
    // для кнопки, а так же по нажатию Enter в однострочном текстовом поле
    class ListenerAction implements ActionListener {
        @Override
        public void actionPerformed ( ActionEvent e ) {
            sendMsg();
        }
    }





    private void sendMsg()
    {
        if (!textNickName.getText().trim().isEmpty() && !textField.getText().trim().isEmpty()) {
            LocalDateTime dateTime = LocalDateTime.now(); // gets the current date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            outMsg.println("[" + dateTime.format(formatter) + "] " + textNickName.getText() + ": " + textField.getText() + "\n");
            outMsg.flush();
            textField.setText("");
        }
    }


}


