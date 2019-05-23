package ru.pack;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.calculation.Calculation;

import java.io.IOException;
import java.net.URL;

/*---------------------------Parsing the loan interest rate for ALFA bank-----------------------------------------*/

public class AlfaParcer {
    public static String link = "https://alfabank.ru/get-money/mortgage/programs/digital-ab/";

    public static Double getAlfaRate() throws IOException{
        Document page = Jsoup.parse(new URL(link), 3000);

        Element elem = page.select("p[class = value__2DqcQ]").get(2);
        Element elemStrong = elem.selectFirst("strong");
        String kup = Calculation.getRegexString(elemStrong.text());
        return Double.parseDouble(kup);
    }
}


// Just for myself:

 /*   This snippet throws the error due to unreachable selection via "class = heading__bitK5 size-h1__13jm2 theme-white__pN1fX heading__27isq":

            Element elem = page.select("h1[class = heading__bitK5 size-h1__13jm2 theme-white__pN1fX heading__27isq").first();
        //
             System.out.println(elem);
             output: <h1 class="heading__bitK5 size-h1__13jm2 theme-white__pN1fX heading__27isq">Ипотека от&nbsp;10,19&nbsp;%</h1>
             System.out.println(elem.text());
             output: Ипотека от 10,19 %
        //
            System.out.println(elem);
            String[] value = elem.toString().split("&nbsp;");
            try{
                 return Double.parseDouble(value[1]);
            }catch (NumberFormatException e){
                 return Double.parseDouble(value[1].replace(",","."));
        } */