package ru.calculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*--------------------------------------Class to calculate the monthly payment---------------------------------------*/

public class Calculation {

    /* Formula to calculate the mortgage monthly payment:
        - the source for calculation is represented here - https://www.mtgprofessor.com/formulas.htm
        - the same formula was listed here - https://pocketsense.com/manually-calculate-mortgage-4913261.html

     M = P [(R/12)(1 + (R/12))^n ] / [ (1 + (R/12))^n - 1], where M = the monthly payment,
            P = the principal on the loan, R = the annual interest rate, and n = the number of months to pay off loan
    */

    public static int getMonthlyPayment(String rateInpStr, String termInpStr, String sumStr){
        double rateInp = Double.parseDouble(rateInpStr);
        int termInp = Integer.parseInt(termInpStr);
        int sum = Integer.parseInt(sumStr);
        int term = termInp * 12;
        double rate = rateInp / 1200; // divide into 12 months and 100% = 1200;
        return (int) ((sum * (rate*(Math.pow((1 + rate), term)))) / (Math.pow((1 + rate), term) -1));
    }

    // This method should output data without 00 at the beginning of number
    public static String getRegexString(String kup) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(kup);
        String newString = matcher.replaceAll("");
        return String.format("%s.%s", newString.substring(0, 2), newString.substring(2, newString.length()));
    }
}