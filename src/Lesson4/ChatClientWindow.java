package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    // Инициализация панели с блочным расположением
    private Box boxContents = new Box(BoxLayout.Y_AXIS);
    // Инициализация текстового поля для отображения переписки
    private JTextArea textArea = new JTextArea(15,40);
    // Инициализация однострочного текстового поля для ввода сообщений
    private JTextField textField = new JTextField("");
    // Инициализация кнопки отправки сообщения
    private JButton button = new JButton("Отправить сообщение");

    public ChatClientWindow() {
        super("Окно для клиентской части чата");
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // Размещение в панели с блочным расположением
        boxContents.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));

        // Размещение текстового поля для отображения переписки
        textArea.setToolTipText("Окно для отображения переписки");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        boxContents.add(textAreaScrollPane);
        boxContents.add(Box.createVerticalStrut(20));

        // Размещение однострочного текстового поля для ввода сообщений
        textField.setToolTipText("Поле для отправки сообщения");
        textField.setEditable(true);
        textField.setHorizontalAlignment(JTextField.LEFT);
        // Делаем текстовое поле в одну строку
        final Dimension maxSize = textField.getMaximumSize();
        maxSize.height = textField.getPreferredSize().height;
        textField.setMaximumSize(maxSize);
        textField.requestFocus();
        textField.addActionListener(new ListenerAction());
        boxContents.add(textField);
        boxContents.add(Box.createVerticalStrut(10));


        // Размещение кнопки отправки сообщения
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ListenerAction());
        boxContents.add(button);

        // Вывод окна на экран
        setContentPane(boxContents);
        setSize(800, 600);
        setVisible(true);

    }

    // Общий внутренний класс (т.е. вложенный нестатический класс) обработки событий
    // для кнопки, а так же по нажатию Enter в однострочном текстовом поле
    class ListenerAction implements ActionListener {
        @Override
        public void actionPerformed ( ActionEvent e ) {
            if (textField.getText() != null && !textField.getText().trim().isEmpty()) {
                LocalDateTime dateTime = LocalDateTime.now(); // gets the current date and time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                textArea.append("[" + dateTime.format(formatter) + "] " + textField.getText() + "\n");
                textField.setText("");
            }
        }
    }

}


