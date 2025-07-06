package br.ufrgs.inf.tcp.tcheorganiza.model.ru;


//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import java.io.IOException;

public class ScraperMenuRU {
    public static void main(String[] args) {
        String url = "https://www.ufrgs.br/prae/cardapio-ru/";

//        try {
//            // gets the HTML content of the page
//            Document doc = Jsoup.connect(url).get();
//
//            // select all table elements from the page
//            Elements tables = doc.select("table");
//
//            int countRU = 0;
//            int countTable = 0;
//            // iterate through all tables
//            for (Element table : tables) {
//
//                countTable++;
//                if (countTable == 5) {
//                    countRU++;
//                    System.out.println();
//                    System.out.println("============ RU0" + countRU + " ============");
//                    System.out.println("+++++++++ ALMOÇO +++++++++++");
//                    countTable++;
//                } else {
//                    if (countTable % 2 == 0) {
//                        System.out.println();
//                        System.out.println("+++++++++ JANTAR +++++++++++");
//                    } else {
//                        countRU++;
//                        System.out.println();
//                        System.out.println("============ RU0" + countRU + " ============");
//                        System.out.println("+++++++++ ALMOÇO +++++++++++");
//                    }
//                }
//
//                // gets all rows in the table
//                Elements rows = table.select("tr");
//
//                // iterate through all rows
//                for (Element row : rows) {
//                    // gets the columns (td or th) in the row (days of the week)
//                    Elements cols = row.select("td, th");
//
//                    // iterate through all columns and print their text content
//                    for (Element col : cols) {
//                        System.out.print(col.text() + " | ");
//                    }
//                    System.out.println();
//                }
//
//            }
//        } catch (IOException e) {
//            System.out.println("Error fetching the website: " + e.getMessage());
//        }
    }
}
