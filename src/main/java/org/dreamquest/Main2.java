package org.dreamquest;

import org.dreamquest.enums.Stopwatch;
import org.dreamquest.enums.ThreadColor;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

//        Stopwatch stopwatch = new Stopwatch();
//        Thread purpleThread = new Thread(stopwatch::countdown, ThreadColor.ANSI_PURPLE.name());
//        Thread yellowThread = new Thread(() -> stopwatch.countdown(10), ThreadColor.ANSI_YELLOW.name());
//        Thread redThread = new Thread(stopwatch::countdown, ThreadColor.ANSI_RED.name());
//
//        purpleThread.start();
//        yellowThread.start();
//        redThread.start();
//        purpleThread.join();
//        yellowThread.join();
//        redThread.join();


        String a = "-{!join from  catalog_number_s to = catalog_number_s v = 'card_type_s:CC AND erp_type_s:(%s)'}";
        String abc = "sap_pr1";
        String format = String.format("-{!join from  catalog_number_s to = catalog_number_s v = 'card_type_s:CC AND erp_type_s:(%s)'}", abc);
        System.out.println(format);
        String FILTER_FIELD_CARD_TYPE ="v",FILTER_VALUE_DBC_CARD_TYPE = "a",ERP_TYPE = "1",targetsite ="2";
        String query = String.format("(%s %s AND %s %s) AND ", FILTER_FIELD_CARD_TYPE, FILTER_VALUE_DBC_CARD_TYPE, ERP_TYPE, targetsite);
        System.out.println(query + format);
    }
}

