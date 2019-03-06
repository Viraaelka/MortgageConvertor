package ru.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameClass {
    JFrame frame;
    public FrameClass(){
        frame = new JFrame();
        frame.setTitle("MortageConvertor");

        interestRate.setBounds(70, 20, 220, 20);
        labelValue.setBounds(30, 60, 220, 20);
        textValue.setBounds(30,90,220,20);
        labelDownPayment.setBounds(30, 120, 220, 20);
        downPayment.setBounds(30,150, 220, 20);
        labelTerm.setBounds(30, 180, 220, 20);
        term.setBounds(30, 210, 220, 20);
        labelLoan.setBounds(30, 240, 220,20);
        panel.setBounds(30, 270, 220, 250);

        textOffer.setBounds(30,300,220,100);
        labelLoan.setBounds(30,330,220,100);
        labelMonthlyPayment.setBounds(30,360,220,100);
        labelRate.setBounds(30,360,220,100);

        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        frame.add(textValue);
        frame.add(downPayment);
        frame.add(term);
        frame.add(interestRate);
        frame.add(labelValue);
        frame.add(labelDownPayment);
        frame.add(labelTerm);
       /* frame.add(textOffer);
        frame.add(labelLoan);
        frame.add(labelMonthlyPayment);
        frame.add(labelRate); */
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

        frame.setSize(300, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                textValue.setText("");
            }
        });
        textValue.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c))
                { e.consume(); }
            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {

            }
        });

        downPayment.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        downPayment.setText("");
                    }
                });
       term.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               super.mousePressed(e);
               term.setText("");
           }
       });

    }
    String[]massive = new String[]{"Альфа", "Тинькофф", "Сбербанк", "ВТБ"};
    //  JComboBox<String> comboBox = new JComboBox<>(massive);
    JLabel interestRate = new JLabel("Калькулятор кредитования");

    JLabel labelValue = new JLabel("Стоимость недвижимости");
    JLabel labelDownPayment = new JLabel("Первоначальный взнос");
    JLabel labelTerm = new JLabel("Срок кредитования");


    JTextField textValue = new JTextField();
    JTextField downPayment = new JTextField();
    JTextField term = new JTextField();


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


    public static void main(String[] args) {
        new FrameClass();
        try {
            String temp = "", textValue = " 019298192891";
            for (int i = 0; i < textValue.length(); i += 3) {
                temp += textValue.substring(i, i + 3) + " ";
            }
            System.out.println(temp);
        }catch(StringIndexOutOfBoundsException e){
            
        }
    }
}