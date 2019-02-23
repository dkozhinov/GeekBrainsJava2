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
        super("Окно для клиентской части чата");
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // Размещение таблиц в панели с блочным расположением
        Box boxContents = new Box(BoxLayout.Y_AXIS);

        boxContents.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
        JTextArea textArea = new JTextArea(15,40);
        textArea.setToolTipText("Окно для отображения переписки");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        boxContents.add(textAreaScrollPane);
        boxContents.add(Box.createVerticalStrut(20));


        JTextField textField = new JTextField("" , 25);
        textField.setToolTipText("Поле для отправки сообщения");
        textField.setEditable(true);
        textField.setHorizontalAlignment(JTextField.LEFT);
        // Делаем текстовое поле в одну строку
        final Dimension maxSize = textField.getMaximumSize();
        maxSize.height = textField.getPreferredSize().height;
        textField.setMaximumSize(maxSize);
        //Размещаем текстовое поле в Box'е
        boxContents.add(textField);
        boxContents.add(Box.createVerticalStrut(20));


        // Кнопка отправки сообщения
        JButton button = new JButton("Отправить сообщение");
        button.setAlignmentX(CENTER_ALIGNMENT);
        boxContents.add(button);

        // Вывод окна на экран
        setContentPane(boxContents);
        setSize(800, 600);
        setVisible(true);




    }
}
