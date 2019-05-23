package ru.pack;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

/*---------------------------Parsing the loan interest rate for TINKOFF bank-----------------------------------------*/

public class TinkoffParcer {
    public static String link = "https://www.tinkoff.ru/loans/mortgage/";

    public static Double getTinkoffRate() throws IOException{
        Document doc = Jsoup.parse(new URL(TinkoffParcer.link), 3000);
        Element elem = doc.select("td[class = ui-table-properties__table-cell ui-table-properties__table-cell_body]").get(6);
        String k = elem.text().replace(",", ".");
        k = k.substring(0, k.length()-1);
        return Double.parseDouble(k);
    }

}
