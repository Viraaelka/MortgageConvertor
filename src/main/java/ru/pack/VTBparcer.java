package ru.pack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class VTBparcer {
    static String linkBuilded = "https://www.vtb.ru/personal/ipoteka/novostrojki/";
    static String linkInProcessBuinding = "https://www.vtb.ru/personal/ipoteka/vtorichnoe-zhile/#calc_0#";

    public static Double getVTBRate()throws IOException{
        Document document = Jsoup.parse(new URL(linkBuilded), 3000);
        Element elem = document.select("div [class = media-slider__inner clear-after]").first();
        Element tdElem = elem.select("li").first();
        String kup = tdElem.text();
        kup = getPattern(kup);
        return 0.0;
    }
    public static String getPattern(String str){
        return null;
    }
}
