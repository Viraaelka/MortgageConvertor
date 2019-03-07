package ru.frame;

import ru.pack.AlfaParcer;
import ru.pack.SberParcer;
import ru.pack.TinkoffParcer;
import ru.pack.VTBparcer;
import ru.ru.calculation.Calculation;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameClass {
    JFrame frame;
    int sum = 0;
    public FrameClass(){
        frame = new JFrame();
        frame.setTitle("MortageConvertor");
        sberToggle.setBounds(30, 40, 50, 20);
        vtbToggle.setBounds(90, 40, 50, 20);
        alafToggle.setBounds(150, 40, 50, 20);
        tinkoffToggle.setBounds(210, 40, 50, 20);

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

        textValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                textValue.setText("");
            }
        });
        textValue.addKeyListener(new KeyAdapter() {
           @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
               sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                if(sum >= 0)
                    valueLoan.setText(String.valueOf(sum));
                else
                    valueLoan.setText("0");
            }
        });
        downPayment.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                sum = Integer.parseInt(textValue.getText()) - Integer.parseInt(downPayment.getText());
                if(sum >= 0)
                    valueLoan.setText(String.valueOf(sum));
                else
                    valueLoan.setText("0");
            }
        });
        term.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                // double rateInp, int termInp, int sum
                valueMonthlyPayment.setText(String.valueOf(Calculation.getMonthlyPayment(Double.parseDouble(valueRate.getText()),
                        Integer.parseInt(term.getText()),
                        Integer.parseInt(textValue.getText()))));
            }
        });


             /*    char c = ' ';
                String temp = "";
                while(e.isActionKey()) {
                    for (int i = 0; i < 3; i++) {
                        c = e.getKeyChar();
                        temp += "" + c;
                    }
                    temp += " ";
                    textValue.setText(" " + temp);
                } */


            /*
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String content =textValue.getText();
                if (!content.equals(""))
                    textValue.setEditable(false);
            } */;

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

      alafToggle.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if(alafToggle.isSelected()) {
                   try {
                       valueRate.setText(AlfaParcer.getAlfaRate().toString());
                   }catch(IOException ee){}
               }
           }
       });
      vtbToggle.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if(vtbToggle.isSelected()){
                  try{
                      valueRate.setText(VTBparcer.getVTBRate().toString());
                  }catch(IOException ee){}
              }
          }
      });
      sberToggle.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if(sberToggle.isSelected()) {
                  try{
                      valueRate.setText(SberParcer.getSberRateInBuilded().toString());
                  }catch(IOException ee){}
              }
          }
      });
      tinkoffToggle.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if(tinkoffToggle.isSelected()) {
                  try{
                      valueRate.setText(TinkoffParcer.getTinkoffRate().toString());
                  }catch(IOException ee){}
              }
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
    JRadioButton alafToggle = new JRadioButton("Альфа");
    JRadioButton tinkoffToggle = new JRadioButton("Тинькофф");
    JRadioButton vtbToggle = new JRadioButton("ВТБ");
    JRadioButton sberToggle = new JRadioButton("Сбербанк");

    ButtonGroup bt = new ButtonGroup();

    public static void main(String[] args) {
        new FrameClass();
     //   System.out.println(getNewOutputOfString("9192837"));
        }

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