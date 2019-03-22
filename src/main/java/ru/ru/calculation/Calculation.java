package ru.ru.calculation;

import ru.frame.FrameClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {

    /* method to calculate mortage monthlypayment
     the source for calculation is represented here - https://www.mtgprofessor.com/formulas.htm
     the same formula was listed here - https://pocketsense.com/manually-calculate-mortgage-4913261.html
     M = P [(R/12)(1 + (R/12))^n ] / [ (1 + (R/12))^n - 1], where M = the monthly payment, P = the principal on the loan, R = the annual interest rate, and n = the number of months to pay off loan
    */

    public static int getMonthlyPayment(String rateInpStr, String termInpStr, String sumStr){
        double rateInp = Double.parseDouble(rateInpStr);
        int termInp = Integer.parseInt(termInpStr);
        int sum = Integer.parseInt(sumStr);
        int term = termInp * 12;
        double rate = rateInp / 1200; // делим на 12 месяцев и переводим из процентов, то есть делим на 100 = 1200ж
        return (int) ((sum * (rate*(Math.pow((1 + rate), term)))) / (Math.pow((1 + rate), term) -1));
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher("String to be changed");
        String newString = matcher.replaceAll("");
        //   System.out.println("newString " + newString);
        System.out.println(getMonthlyPayment("10.19", "25", "2000000"));
        new FrameClass();
    }
}