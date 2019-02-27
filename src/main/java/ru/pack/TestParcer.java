package ru.pack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestParcer {

    private static Document getPage() throws IOException {
        String url = "http://www.pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        // css query language
        Element tableWth = page.select("table[class = wt]").first();
        System.out.println(tableWth);
        Elements names = tableWth.select("tr[class = wth]");
        Elements values = tableWth.select("tr[valign=top");
        int index = 0;

        for (Element name : names) {
            String dateString = name.select("th[id=dt]").text();
            String date = getDateFromString(dateString);
            System.out.println(date);
            printFourValues(values, index);
        }

        // System.out.println("     Явления    Температура     Давл     Влажность       Ветер");
    }

    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher match = pattern.matcher(stringDate);
        if (match.find()) {
            return match.group();
        }
        throw new Exception("Can't extract date from the string");
    }

    private static void printFourValues(Elements values, int index) {
        if (index == 0) {
            Element valueL = values.get(0);
            boolean isMorning = valueL.text().contains("Утро");
            int iterationCount = 4;
            if (isMorning) {
                iterationCount = 3;
            }
            for (int i = 0; i < iterationCount; i++) {
                Element valueLine = values.get(index + i);
                for (Element td : valueLine.select("td")) {
                    System.out.print(td.text() + "    ");
                }
            } } else{
            for(int i = 0; i < 4; i++){
                Element valueLine = values.get(index);
                for(Element td : valueLine.select("td")){
                    System.out.println(td.text() + "    ");
                }
                System.out.println();
            }
        }
    }
}
