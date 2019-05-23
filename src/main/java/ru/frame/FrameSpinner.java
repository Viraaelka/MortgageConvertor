package ru.frame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*---------------------It should have been another modification of the Convertor with Spinner -----------------------*/
/*-------------------------Not fully done (only partially implemented)-----------------------------------------------*/

public class FrameSpinner {

    JFrame frame;
    public FrameSpinner(){
        frame = new JFrame();
        frame.setTitle("Mortgage calculator");
        interestRate.setBounds(70, 20, 220, 20);
        labelValue.setBounds(30, 60, 220, 20);
        textValue.setBounds(30,90,220,20);
        labelDownPayment.setBounds(30, 120, 220, 20);
        slidedownPayment.setBounds(30,150, 220, 20);
        labelTerm.setBounds(30, 180, 220, 20);
        slideterm.setBounds(30, 210, 220, 20);
        labelLoan.setBounds(30, 240, 220,20);
        panel.setBounds(30, 270, 220, 250);

        textOffer.setBounds(30,300,220,100);
        labelLoan.setBounds(30,330,220,100);
        labelMonthlyPayment.setBounds(30,360,220,100);
        labelRate.setBounds(30,360,220,100);

        textValue.setPaintTicks(true);
        textValue.setMajorTickSpacing(20);
        textValue.setMinorTickSpacing(5);


        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        frame.add(textValue);
        frame.add(slidedownPayment);
        frame.add(slideterm);
        frame.add(interestRate);
        frame.add(labelValue);
        frame.add(labelDownPayment);
        frame.add(labelTerm);

        panel.add(textOffer);
        panel.add(labelLoan);
        panel.add(valueLoan);
        panel.add(labelMonthlyPayment);
        panel.add(valueMonthlyPayment);
        panel.add(labelRate);
        panel.add(valueRate);

        panel.getComponent(0).setBounds(10, 10, 220, 30);
        for(int i = 1; i <= 6; i++){
            panel.getComponent(i).setBounds(10, 10*i + 20*(i-1), 220,100);
        }

        frame.add(panel);

        listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                textValue = (JSlider)e.getSource();
                labelRate.setText(" " + textValue.getValue());
            }
        };

        frame.setSize(300, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    String[]massive = new String[]{"Альфа", "Тинькофф", "Сбербанк", "ВТБ"};
    JLabel interestRate = new JLabel("Калькулятор кредитования");

    JLabel labelValue = new JLabel("Стоимость недвижимости");
    JLabel labelDownPayment = new JLabel("Первоначальный взнос");
    JLabel labelTerm = new JLabel("Срок кредитования");

    JTextField loan = new JTextField("");
    JTextField monthlyPayment = new JTextField();

    JPanel panel = new JPanel();

    JLabel textOffer = new JLabel("Наше предложение");
    JLabel labelLoan = new JLabel("Сумма кредита");
    JLabel valueLoan = new JLabel("test");
    JLabel labelMonthlyPayment = new JLabel("Ежемесячный платеж");
    JLabel valueMonthlyPayment = new JLabel("test");
    JLabel labelRate = new JLabel("Процентная ставка");
    JLabel valueRate = new JLabel("test");

    JSlider textValue = new JSlider(0,1000,1);
    JSlider slidedownPayment = new JSlider();
    JSlider slideterm = new JSlider();
    ChangeListener listener;

    Font fontForPoppedUpMes = new Font("Cambria", Font.ITALIC, 12);
    Font fontFotTitles = new Font("Cambria", Font.BOLD, 16);
    Font font = new Font("Cambria", 1, 13);
}
