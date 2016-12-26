package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MyMenu extends JFrame{

    int choose = 0;

    WorkWithBase workWithBase = new WorkWithBase();


    public MyMenu(String title, Connection con) throws HeadlessException {
        super(title);
        setSize(300, 400);
        //менеджер кнопок
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5,1,4,5));

        //добавляем кнопки и обработчик событий
        JButton watch = new JButton("Вывод базы");
        watch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) throws NumberFormatException {
                choose = 0;
                super.mouseClicked(e);
                do {
                    String a = JOptionPane.showInputDialog(null, " 1 таблица Actor\n 2 таблица category\n 3 таблица adress");
                    try {
                        choose = Integer.parseInt(a);
                    } catch (NumberFormatException e1){
                        choose = 0;
                    }
                } while (choose == 0);
                switch (choose) {
                    case 1:
                        try {
                            workWithBase.seeAllActors(con);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            workWithBase.seeAllCategory(con);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            workWithBase.seeAllAddress(con);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        JButton search = new JButton("Поиск");
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //что-то делает
            }
        });

        JButton remove = new JButton("Удаление");
        JButton update = new JButton("Изменить");
        JButton add = new JButton("Добавление");

        //добавляем кнопки на окно
        jPanel.add(watch);
        jPanel.add(remove);
        jPanel.add(search);
        jPanel.add(add);
        jPanel.add(update);
        add(jPanel);
    }
}
