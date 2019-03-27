package ru.pack;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.ru.calculation.Calculation;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SberParcer {
    static String linkBuilded = "https://www.sberbank.ru/ru/person/credits/home/buying_complete_house";
    static String linkInProcessBuinding = "https://www.sberbank.ru/ru/person/credits/home/buying_project";

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
    /* Extra method similar to the above - it extracts the rate for apartments that are in the process of building:

        public static Double getSberLinkInProcessBuilding()throws IOException{
        Document page = Jsoup.parse(new URL(SberParcer.linkInProcessBuinding), 3000);
        Element elem = page.select("div[class = sbrf-rich-outer]").first();
        Element pElem = elem.select("p[style = text-align: center;]").last();
        String kup = pElem.text().replaceAll(",", ".");
        kup = Calculation.getRegexString(kup);
        return Double.parseDouble(kup);
    } */
}
