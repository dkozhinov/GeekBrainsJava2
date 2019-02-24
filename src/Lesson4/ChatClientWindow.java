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

    public ChatClientWindow() {
        super("Окно для клиентской части чата");
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // Размещение в панели с блочным расположением
        Box boxContents = new Box(BoxLayout.Y_AXIS);
        boxContents.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));

        // Текстовое поле для отображения переписки
        JTextArea textArea = new JTextArea(15,40);
        textArea.setToolTipText("Окно для отображения переписки");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        boxContents.add(textAreaScrollPane);
        boxContents.add(Box.createVerticalStrut(20));

        // Однострочное текстовое поле для ввода сообщений
        JTextField textField = new JTextField("");
        textField.setToolTipText("Поле для отправки сообщения");
        textField.setEditable(true);
        textField.setHorizontalAlignment(JTextField.LEFT);
        // Делаем текстовое поле в одну строку
        final Dimension maxSize = textField.getMaximumSize();
        maxSize.height = textField.getPreferredSize().height;
        textField.setMaximumSize(maxSize);
        textField.requestFocus();
        textField.addActionListener(new ListenerAction(textArea, textField));
        boxContents.add(textField);
        boxContents.add(Box.createVerticalStrut(10));


        // Кнопка отправки сообщения
        JButton button = new JButton("Отправить сообщение");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ListenerAction(textArea, textField));
        boxContents.add(button);

        // Вывод окна на экран
        setContentPane(boxContents);
        setSize(800, 600);
        setVisible(true);

    }
}

// Общий класс обработки событий для кнопки и по нажатию Enter в однострочном текстовом поле
class ListenerAction implements ActionListener {

    private JTextArea textArea;
    private JTextField textField;

    public ListenerAction(JTextArea textArea, JTextField textField) {
        this.textArea = textArea;
        this.textField = textField;
    }

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
