package Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import static java.util.Calendar.*;

public class StartStopClock extends JFrame implements ActionListener {
    private static final String START = "START";
    private static final String STOP = "STOP";

    private final JLabel clockLabel = new JLabel();
    private ClockThread clockThread = null;
    private TwoThread twoThread = null;

    public StartStopClock() {
        // Установить заголовок
        setTitle("ClockThread");

        // Выравнять метку по горизонтали - есть такой метод у Label
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для этого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);

        // Добавить метку на основную панель окна
        add(clockLabel);

        // Добавить кнопку для старта
        JButton start = new JButton(START);
        start.setActionCommand(START);
        start.addActionListener(this);
        add(start, BorderLayout.NORTH);

        // Добавить кнопку для становки
        JButton stop = new JButton(STOP);
        stop.setActionCommand(STOP);
        stop.addActionListener(this);
        add(stop, BorderLayout.SOUTH);

        // Установить размеры окна
        setBounds(400, 300, 300, 200);

    }

    public static void main(String[] args) {
        StartStopClock cl = new StartStopClock();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }

    public void setTime(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                clockLabel.setText(df.format(getInstance().getTime()));
            }
        });
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (START.equals(ae.getActionCommand())) {
            if (clockThread == null) {
                clockThread = new ClockThread(this);
                clockThread.start();
                twoThread = new TwoThread(this);
                twoThread.start();
            }
        }
        if (STOP.equals(ae.getActionCommand())) {
            if (clockThread != null) {
                clockThread.stopClock();
                clockThread = null;
                twoThread.stop();
                twoThread = null;
            }
        }
    }
}