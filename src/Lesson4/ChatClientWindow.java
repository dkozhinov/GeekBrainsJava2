package Lesson4;

import javax.swing.*;
import java.awt.*;

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
        super("Окно клиента чата");
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        /*
        // Устанавливаем последовательное расположение
        Container container = getContentPane();
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));
        // Простая кнопка
        JButton button = new JButton("Обычная кнопка");
        container.add(button);
        */

        // Размещение таблиц в панели с блочным расположением
        Box contents = new Box(BoxLayout.Y_AXIS);

        JTextArea textArea = new JTextArea(20,40);
        textArea.append("This is an non editable JTextArea.This is an non editable JTextArea.This is an non editable JTextArea.This is an non editable JTextArea.");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contents.add(Box.createVerticalStrut(20));
        contents.add(textAreaScrollPane);

        /*
        JTextField bigTextField = new JTextField("" , 25);
        bigTextField.setToolTipText("Текстовое поле для отображения переписки");
        bigTextField.setEditable(false);
        bigTextField.setHorizontalAlignment(JTextField.LEFT);
        contents.add(Box.createVerticalStrut(20));
        contents.add(bigTextField);
        */
        
        // Кнопка отправки сообщения
        JButton button = new JButton("Отправить сообщение");
        button.setAlignmentX(CENTER_ALIGNMENT);
        contents.add(Box.createVerticalStrut(20));
        contents.add(button);
        contents.add(Box.createVerticalStrut(20));

        // Вывод окна на экран
        setContentPane(contents);
        setSize(500, 400);
        setVisible(true);




    }
}
