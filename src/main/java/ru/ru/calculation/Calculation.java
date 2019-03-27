package ru.ru.calculation;

import ru.frame.FrameClass;
import ru.pack.AlfaParcer;
import ru.pack.SberParcer;
import ru.pack.VTBparcer;

import java.io.IOException;
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

    public static String getRegexString(String kup) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(kup);
        String newString = matcher.replaceAll("");
        return String.format("%s.%s", newString.substring(0, 2), newString.substring(2, newString.length()));
    }
}