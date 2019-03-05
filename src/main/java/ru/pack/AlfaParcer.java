package ru.pack;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class AlfaParcer {
    public static String link = "https://alfabank.ru/get-money/mortgage/programs/digital-ab/";

    public static Double getAlfaRate(String link) throws IOException{

            link = AlfaParcer.link;
            Document page = Jsoup.parse(new URL(link), 3000);
            Element elem = page.select("h1[class = heading__bitK5 size-h1__13jm2 theme-white__pN1fX heading__27isq").first();
/*
            System.out.println(elem);
             output: <h1 class="heading__bitK5 size-h1__13jm2 theme-white__pN1fX heading__27isq">Ипотека от&nbsp;10,19&nbsp;%</h1>
            System.out.println(elem.text());
             output: Ипотека от 10,19 %
*/
            String[] value = elem.toString().split("&nbsp;");
            try{
                 return Double.parseDouble(value[1]);
             }catch (NumberFormatException e){
                 return Double.parseDouble(value[1].replace(",","."));
        }
    }
}
