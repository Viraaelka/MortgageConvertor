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
      //  textOffer.setBounds(null);
        labelLoan.setBounds(30,300,220,100);
        labelMonthlyPayment.setBounds(30,360,220,100);
        labelRate.setBounds(30,360,220,100);
        warningMessage.setFont(font);

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
      //  popup = popupFactory.getPopup(frame, panel, 180, 100);


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
                warningMessage.setVisible(false);
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
                if(textValue.getText().equals("")){
                    warningMessage.setBounds(30, 90, 220,19);
                    warningMessage.setBackground(Color.orange);
                 //   warningMessage.setEditable(false);
                    warningMessage.setVisible(true);
                    warningMessage.setText("Введите значение");
                }
                else if(downPayment.getText().equals("")){
                    warningMessage.setBounds(30, 150, 220, 19);
                    warningMessage.setBackground(Color.pink);
                  //  warningMessage.setEditable(false);
                    warningMessage.setVisible(true);
                    warningMessage.setText("Введите значение");
                }
                else{
                    int k = Integer.parseInt(term.getText());
                    if(k < 5){
                        warningMessage.setBounds(30,230,220,19);
                        warningMessage.setText("Срок не может быть меньше 5 лет");
                        warningMessage.setVisible(true);
                        warningMessage.setEditable(false);
                    }
                    else if (k > 100){
                        warningMessage.setBounds(30,230,220,19);
                        warningMessage.setText("Срок не может быть выше 100 лет");
                        warningMessage.setVisible(true);
                        warningMessage.setEditable(false);
                    }
                    else {
                        warningMessage.setVisible(false);
                        valueMonthlyPayment.setText(String.valueOf(Calculation.getMonthlyPayment(valueRate.getText(),
                                term.getText(),textValue.getText())));
                    }
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
      alafToggle.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if(alafToggle.isSelected()) {
                   try {
                       valueRate.setText(AlfaParcer.getAlfaRate().toString());
                       System.out.println(AlfaParcer.getAlfaRate().toString());
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
                      System.out.println(TinkoffParcer.getTinkoffRate().toString());
                  }catch(IOException ee){}
              }
          }
      });
    }
   // String[]massive = new String[]{"Альфа", "Тинькофф", "Сбербанк", "ВТБ"};
    //  JComboBox<String> comboBox = new JComboBox<>(massive);
    JLabel interestRate = new JLabel("Калькулятор кредитования");

    JLabel labelValue = new JLabel("Стоимость недвижимости");
    JLabel labelDownPayment = new JLabel("Первоначальный взнос");
    JLabel labelTerm = new JLabel("Срок кредитования");


    JTextField textValue = new JTextField();
    JTextField downPayment = new JTextField();
    JTextField term = new JTextField();


   // JTextField loan = new JTextField("");
  //  JTextField monthlyPayment = new JTextField();

    JPanel panel = new JPanel();

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
    JTextField warningMessage = new JTextField();
    Font font = new Font("George", Font.ITALIC, 12);

    ButtonGroup bt = new ButtonGroup();
    Popup popup;
    PopupFactory popupFactory = new PopupFactory();

    public static void main(String[] args) throws IOException{
        new FrameClass();
       // System.out.println(SberParcer.getSberRateInBuilded());
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