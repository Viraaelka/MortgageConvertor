package ru.frame;

import javax.swing.*;

public class FrameClass {
    JFrame frame;
    public FrameClass(){
        frame = new JFrame();
        frame.setTitle("MortageConvertor");
/*
        for(int i = 0; i < 4; i++){
            jtoggle[i] = new JToggleButton("i: ");
            jtoggle[i].setBounds(10+i, 10+i, 10,10);
            frame.add(jtoggle[i]);

        }
*/
        interestRate.setBounds(70, 20, 220, 20);
        labelValue.setBounds(30, 60, 220, 20);
        textValue.setBounds(30,90,220,20);
        labelDownPayment.setBounds(30, 120, 220, 20);
        downPayment.setBounds(30,150, 220, 20);
        labelTerm.setBounds(30, 180, 220, 20);
        term.setBounds(30, 210, 220, 20);
        labelLoan.setBounds(30, 240, 220,20);

        frame.add(textValue);
        frame.add(downPayment);
        frame.add(term);
        frame.add(interestRate);
        frame.add(labelValue);
        frame.add(labelDownPayment);
        frame.add(labelTerm);

        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JToggleButton[] jtoggle;
    JLabel interestRate = new JLabel("Welcome to this app");

    JLabel labelValue = new JLabel("Стоимость недвижимости");
    JLabel labelDownPayment = new JLabel("Первоначальный взнос");
    JLabel labelTerm = new JLabel("Срок кредитования");


    JTextField textValue = new JTextField();
    JTextField downPayment = new JTextField();
    JTextField term = new JTextField();


    JTextField loan = new JTextField("");
    JTextField monthlyPayment = new JTextField();

    JLabel labelLoan = new JLabel("");
    JLabel labelMonthlyPayment = new JLabel("Ежемесячный платеж");

}
