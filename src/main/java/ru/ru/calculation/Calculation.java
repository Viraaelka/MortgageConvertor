package ru.ru.calculation;

import ru.frame.FrameClass;

public class Calculation {

    public static int getMonthlyPayment(String rateInpStr, String termInpStr, String sumStr){
        double rateInp = Double.parseDouble(rateInpStr);
        int termInp = Integer.parseInt(termInpStr);
        int sum = Integer.parseInt(sumStr);
        int term = termInp * 12;
        double rate = rateInp / 1200; // делим на 12 месяцев и переводим из процентов, то есть делим на 100 = 1200ж
        return (int) (sum * ((rate * Math.pow((1 + rate), term))/ (Math.pow((1 + rate), term) -1)));
    }
}
