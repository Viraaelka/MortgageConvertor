package ru.frame;

import ru.pack.AlfaParcer;
import ru.pack.SberParcer;
import ru.pack.TinkoffParcer;
import ru.pack.VTBparcer;
import ru.calculation.Calculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/*-----------------------------------GUI class to make the frame for calculator---------------------------------------*/

public class FrameClass {
    JFrame frame;
    int sum = 0;
    public FrameClass() {
        frame = new JFrame();
        frame.setTitle("Ипотечный калькулятор");
        sberToggle.setBounds(30, 50, 100, 20);
        vtbToggle.setBounds(30, 70, 100, 20);
        alafToggle.setBounds(140, 50, 100, 20);
        tinkoffToggle.setBounds(140, 70, 100, 20);

        interestRate.setBounds(35, 15, 220, 20);
        labelValue.setBounds(30, 100, 220, 20); //
        textValue.setBounds(30, 120, 220, 20);
        labelDownPayment.setBounds(30, 150, 220, 20);
        downPayment.setBounds(30, 170, 220, 20);
        labelTerm.setBounds(30, 200, 220, 20);
        term.setBounds(30, 220, 220, 20);
        labelLoan.setBounds(30, 240, 220, 20);
        panel.setBounds(30, 270, 220, 250);

        textOffer.setBounds(30, 300, 220, 100);
        labelLoan.setBounds(30, 300, 220, 100);
        labelMonthlyPayment.setBounds(30, 360, 220, 100);
        labelRate.setBounds(30, 360, 220, 100);
        interestRate.setFont(fontFotTitles);
        warningMessage.setFont(fontForPoppedUpMes);
        textValue.setFont(font);
        downPayment.setFont(font);
        term.setFont(font);
        textOffer.setFont(fontFotTitles);
        labelLoan.setFont(font);
        valueLoan.setFont(font);
        labelMonthlyPayment.setFont(font);
        valueMonthlyPayment.setFont(font);
        labelRate.setFont(font);
        valueRate.setFont(font);
        labelValue.setFont(font);
        labelDownPayment.setFont(font);
        labelTerm.setFont(font);
        alafToggle.setFont(font);
        tinkoffToggle.setFont(font);
        vtbToggle.setFont(font);
        sberToggle.setFont(font);


        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        frame.add(textValue);
        frame.add(downPayment);
        frame.add(term);
        frame.add(interestRate);
        frame.add(labelValue);
        frame.add(labelDownPayment);
        frame.add(labelTerm);
        frame.add(warningMessage);

        panel.add(textOffer);
        panel.add(labelLoan);
        panel.add(valueLoan);
        panel.add(labelMonthlyPayment);
        panel.add(valueMonthlyPayment);
        panel.add(labelRate);
        panel.add(valueRate);

        panel.getComponent(0).setBounds(10, 10, 220, 30);
        for (int i = 1; i <= 6; i++) {
            panel.getComponent(i).setBounds(10, 10 * i + 20 * (i - 1), 220, 100);
        }

        bt.add(alafToggle);
        bt.add(sberToggle);
        bt.add(vtbToggle);
        bt.add(tinkoffToggle);

        frame.add(alafToggle);
        frame.add(tinkoffToggle);
        frame.add(sberToggle);
        frame.add(vtbToggle);
        frame.add(panel);

        frame.setSize(300, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*---------------------------LISTENERS--------------------------------------------------*/

        try {
            textValue.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    textValue.setText("");
                    warningMessage.setVisible(false);
                }
            });
            textValue.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                    if (sum >= 0) {
                        valueLoan.setText(getNewOutputOfString(String.valueOf(sum)).trim());
                        valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(), textValue.getText()))).trim());
                    } else {
                        valueLoan.setText("0");
                        valueMonthlyPayment.setText("0");
                    }
                    sum = 0;
                }

                // to enter only digits
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    char c = e.getKeyChar();
                    if (textValue.getText().length() > 9)
                           e.consume();
                    if (!Character.isDigit(c))
                            e.consume();

                }
            });
            downPayment.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                    if (sum >= 0) {
                        valueLoan.setText(getNewOutputOfString(String.valueOf(sum)).trim());
                        valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(), String.valueOf(sum)))).trim());
                    } else {
                        valueLoan.setText("0");
                        valueMonthlyPayment.setText("0");
                    }
                    sum = 0;
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyPressed(e);
                    char c = e.getKeyChar();
                    if(!Character.isDigit(c)){
                        e.consume();
                    }
                    if (downPayment.getText().length() > 7)
                        e.consume();
                }
            });
            term.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    String temp = textValue.getText();
                    if (textValue.getText().equals("")) {
                        warningMessage.setBounds(30, 120, 220, 19);
                        warningMessage.setBackground(Color.orange);
                        warningMessage.setVisible(true);
                     //   warningMessage.setText("Введите значение");
                        warningMessage.setText("Input the value");
                        valueLoan.setText("0");
                        valueMonthlyPayment.setText("0");
                    } else if (downPayment.getText().equals("")) {
                        warningMessage.setBounds(30, 170, 220, 19);
                        warningMessage.setBackground(Color.pink);
                        warningMessage.setVisible(true);
                     //   warningMessage.setText("Введите значение");
                        warningMessage.setText("Input the value");
                        valueLoan.setText("0");
                        valueMonthlyPayment.setText("0");
                    }  else {
                        int k = Integer.parseInt(term.getText());
                        if (k < 5) {
                            warningMessage.setBounds(30, 240, 220, 19);
                        //    warningMessage.setText("Срок не может быть меньше 5 лет");
                            warningMessage.setText("The term cannot be less than 5 years");
                            warningMessage.setVisible(true);
                            warningMessage.setEditable(false);
                            valueLoan.setText("0");
                            valueMonthlyPayment.setText("0");
                            warningMessage.setBackground(Color.orange);
                        } else if (k > 100) {
                            warningMessage.setBounds(30, 240, 220, 19);
                         //   warningMessage.setText("Срок не может быть выше 100 лет");
                            warningMessage.setText("The term cannot be more than 100 years");
                            warningMessage.setVisible(true);
                            warningMessage.setEditable(false);
                            valueLoan.setText("0");
                            valueMonthlyPayment.setText("0");
                            warningMessage.setBackground(Color.orange);
                        } else{

                            warningMessage.setVisible(false);
                            valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                    term.getText(), temp))).trim());
                            valueLoan.setText(getNewOutputOfString(temp).trim());
                    }}
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    char c = e.getKeyChar();
                    if(!Character.isDigit(c)){
                        e.consume();
                    }
                }
            });
            downPayment.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    downPayment.setText("");
                    warningMessage.setVisible(false);
                }
            });
            term.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    term.setText("");
                    warningMessage.setVisible(false);
                }
            });
            
            /*---------------Setting listeners for Toggle buttons----------------------------*/

            alafToggle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (alafToggle.isSelected()) {
                    try {
                        valueRate.setText(AlfaParcer.getAlfaRate().toString().trim());
                        valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(), textValue.getText()))).trim());
                        sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                        valueLoan.setText(getNewOutputOfString(String.valueOf(sum)).trim());
                    }catch(IOException ee){}
                        sum = 0;
                    }
                }
            });
            vtbToggle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (vtbToggle.isSelected()) {
                    try{
                        valueRate.setText(VTBparcer.getVTBRate().toString());
                        valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(), textValue.getText()))).trim());
                        sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                        valueLoan.setText(getNewOutputOfString(String.valueOf(sum)).trim());
                    }catch(IOException ee){}
                        sum = 0;
                    }
                }
            });
            sberToggle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (sberToggle.isSelected()) {
                    try{
                        valueRate.setText(SberParcer.getSberRateInBuilded().toString());
                        valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(), textValue.getText()))).trim());
                        sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                        valueLoan.setText(getNewOutputOfString(String.valueOf(sum)).trim());
                    }catch(IOException ee){}
                    sum = 0;
                    }
                }
            });
            tinkoffToggle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (tinkoffToggle.isSelected()) {
                    try{
                        valueRate.setText(TinkoffParcer.getTinkoffRate().toString());
                        valueMonthlyPayment.setText(getNewOutputOfString(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(), textValue.getText()))).trim());
                        sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                        valueLoan.setText(getNewOutputOfString(String.valueOf(sum)).trim());
                    }catch(IOException ee){}
                    }
                    sum = 0;
                }
            });
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    JTextField textValue = new JTextField();
    JTextField downPayment = new JTextField();
    JTextField term = new JTextField();

    JPanel panel = new JPanel();

/*-------------------RUSSIAN labels-----------------------------------*/
    /*
    JLabel textOffer = new JLabel("Наше предложение");
    JLabel labelLoan = new JLabel("Сумма кредита");
    JLabel valueLoan = new JLabel();
    JLabel labelMonthlyPayment = new JLabel("Ежемесячный платеж");
    JLabel valueMonthlyPayment = new JLabel();
    JLabel labelRate = new JLabel("Процентная ставка");
    JLabel valueRate = new JLabel();
    JRadioButton alafToggle = new JRadioButton("Альфа");
    JRadioButton tinkoffToggle = new JRadioButton("Тинькофф");
    JRadioButton vtbToggle = new JRadioButton("ВТБ");
    JRadioButton sberToggle = new JRadioButton("Сбербанк");

    JLabel interestRate = new JLabel("Калькулятор кредитования");
    JLabel labelValue = new JLabel("Стоимость недвижимости");
    JLabel labelDownPayment = new JLabel("Первоначальный взнос");
    JLabel labelTerm = new JLabel("Срок кредитования");

    */
/*-------------------ENGLISH labels-----------------------------------*/

    JLabel textOffer = new JLabel("Our offer");
    JLabel labelLoan = new JLabel("Load sum");
    JLabel valueLoan = new JLabel();
    JLabel labelMonthlyPayment = new JLabel("Monthly payment");
    JLabel valueMonthlyPayment = new JLabel();
    JLabel labelRate = new JLabel("Interest");
    JLabel valueRate = new JLabel();
    JRadioButton alafToggle = new JRadioButton("Alfa");
    JRadioButton tinkoffToggle = new JRadioButton("Tinkoff");
    JRadioButton vtbToggle = new JRadioButton("VTB");
    JRadioButton sberToggle = new JRadioButton("Sberbank");

    JLabel interestRate = new JLabel("Mortgage calculator");
    JLabel labelValue = new JLabel("Property value");
    JLabel labelDownPayment = new JLabel("Initial instalment");
    JLabel labelTerm = new JLabel("Credit period"); // in months

    JTextField warningMessage = new JTextField();
    Font fontForPoppedUpMes = new Font("Cambria", Font.ITALIC, 12);
    Font fontFotTitles = new Font("Cambria", Font.BOLD, 16);
    Font font = new Font("Cambria", 1, 13);
    ButtonGroup bt = new ButtonGroup();


    public static void main(String[] args) {
        new FrameClass();
    }

    /*----Below two methods allow input data in following format '000 000 000' for user convenience*/

    public  String getThreeViewOfTheString(String textValue){
        String temp = "";
        for (int i = 0; i < textValue.length(); i += 3) {
            temp += textValue.substring(i, i + 3) + " ";
        }
        return temp;
    }
    public String getNewOutputOfString(String textValue){
        String temp = "";
        if(textValue.length()%3 != 0) {
            for (int i = 3 - textValue.length() % 3; i > 0; i--) {
                textValue = " " + textValue;
            }
        }
        temp = getThreeViewOfTheString(textValue);
        return temp;
    }
}