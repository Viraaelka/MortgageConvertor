package ru.pack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.calculation.Calculation;

import java.io.IOException;
import java.net.URL;

/*---------------------------Parsing the loan interest rate for VTB bank-----------------------------------------*/

public class VTBparcer {
    static String linkBuilded = "https://www.vtb.ru/personal/ipoteka/novostrojki/";

    public static Double getVTBRate()throws IOException{
        Document document = Jsoup.parse(new URL(linkBuilded), 3000);
        Element elem = document.select("div [class = media-slider__inner clear-after]").first();
        Element tdElem = elem.select("li").first();
        String kup = tdElem.text();
        kup = Calculation.getRegexString(kup);
        return Double.parseDouble(kup);
    }
}
