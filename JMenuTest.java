

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JMenuTest extends JFrame
{
    JButton button = new JButton("Тест 1");
    JButton button2 = new JButton("Тест 2");
    JTextField jta1 = new JTextField("Введите сюда что-нибудь!",30);
    //--------------------------------------------------------
    /**
     * Конструктор класса
     */
    public JMenuTest()
    {
        super("Задание №3");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        // Создание строки главного меню
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню  
        menuBar.add(createFileMenu());
        menuBar.add(createViewMenu());
        menuBar.add(createHelpMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);
        setLayout(new FlowLayout());
        add(button);
        add(button2);
        add(jta1);
        // Открытие окна
        setSize(400, 300);
        setVisible(true);
    }
    //--------------------------------------------------------
    /**
     * Функция создания меню "Файл"
     * @return
     */
    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Сохранить");
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem(new ExitAction());
        // Добавление к пункту меню изображения
        // Добавим в меню пункта open
        file.add(open);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);

        open.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
            }
        });
        return file;
    }
    //--------------------------------------------------------
    // создадим забавное меню
    /**
     * Функция создания меню 
     * @return
     */
    private JMenu createViewMenu()
    {
        // создадим выпадающее меню
        JMenu viewMenu = new JMenu("Правка");
        // меню-флажки
        JMenuItem copy  = new JMenuItem("Копировать");
        JMenuItem cut  = new JMenuItem("Вырезать");
        JMenuItem insert = new JMenuItem("Вставить");
        // добавим все в меню
        viewMenu.add(copy);
        viewMenu.add(cut);
        viewMenu.add(insert);
        return viewMenu;
    }

    private JMenu createHelpMenu()
    {
        // создадим выпадающее меню
        JMenu helpMenu = new JMenu("Справка");
        return helpMenu;
    }
    //--------------------------------------------------------
    /**
     * Вложенный класс завершения работы приложения 
     */
    class ExitAction extends AbstractAction
    {
        ExitAction() {
            putValue(NAME, "Выход");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    //--------------------------------------------------------
    public static void main(String[] args)
    {
        new JMenuTest();
    }
}

