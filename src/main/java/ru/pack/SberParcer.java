package ru.pack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.calculation.Calculation;

import java.io.IOException;
import java.net.URL;

/*---------------------------Parsing the loan interest rate for SBERBANK -----------------------------------------*/
public class SberParcer {
    static String linkBuilded = "https://www.sberbank.ru/ru/person/credits/home/buying_complete_house";

   public static Double getSberRateInBuilded() throws IOException {

        Document page = Jsoup.parse(new URL(linkBuilded), 3000);
        Element elem = page.select("div[class = sbrf-rich-outer]").get(1);
/* Description of the various outputs:

     System.out.println(elem);
     OUTPUT:
    <div class="sbrf-rich-outer">
    <p style="text-align: center;">Первоначальный взнос<br /></p>
    <p style="text-align: center;"><span style="color:rgb(0, 128, 0); font-size:24px">от 15%</span></p>
    </div>

    System.out.println(elem.text());
    OUTPUT:
    Первоначальный взнос от 15%
*/
        Element pElem = elem.select("p[style = text-align: center;]").get(1);
        String kup = pElem.text().replace(",", ".");
        kup = Calculation.getRegexString(kup);
        return Double.parseDouble(kup);
    }
}
