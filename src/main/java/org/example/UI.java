package org.example;

import org.example.CSVIE.CSVImportExport;
import org.example.CSVIE.CSVImportExportImpl;
import org.example.Prekes.MesaImpl;
import org.example.Prekes.VaisiusImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI {
    private CSVImportExport csv = new CSVImportExportImpl();
    private Scanner scannerInt = new Scanner(System.in);
    private Scanner scannerStr = new Scanner(System.in);
    private String pasirinkimas;
    private boolean arAktyvus = true;

    public void run() {
        arAktyvus = true;
        while (arAktyvus){
            System.out.println("1. Sukurti produkta");
            System.out.println("2. Istrinti");
            System.out.println("3. Produktu sarasas");
            System.out.println("4. Iseiti");
            pasirinkimas = scannerInt.nextLine();
            switch (pasirinkimas){
                case "1":
                    sukurtiNauja();
                    arAktyvus = false;
                    break;
                case "2":
                    pasalinti ();
                    arAktyvus = false;
                    break;
                case "3":
                    arAktyvus = true;
                    csv.importuotiIsCSV();
                    break;
                case "4":
                    arAktyvus = false;
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nera!");
            }
        }
    }

    private void pasalinti (){
        System.out.println("Iveskite produkto ID: ");
        int id = scannerInt.nextInt();
        csv.pasalintiProduktaIsCSV(id);
        run();
    }

    private void sukurtiNauja() {
        arAktyvus = true;
        String tipas = "";
        while (arAktyvus){
            System.out.println("1. Mesa");
            System.out.println("2. Vaisius");
            pasirinkimas = scannerInt.nextLine();
            switch (pasirinkimas){
                case "1":
                    tipas = "1";
                    arAktyvus = false;
                    break;
                case "2":
                    tipas = "2";
                    arAktyvus = false;
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nera!");
            }
        }
        

        System.out.println("Iveskite produkto ID: ");
        int id = scannerInt.nextInt();


        System.out.println("Iveskite produkto pavadinima: ");
        String pavadinimas = scannerStr.nextLine();

        System.out.println("Iveskite produkto kaina:");
        double kaina = scannerInt.nextInt();

        System.out.println("Iveskite produkto galiojima: YYYY. MMM. dd");
        LocalDate galiojimas = LocalDate.of(scannerInt.nextInt(),scannerInt.nextInt(),scannerInt.nextInt());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
        System.out.println(galiojimas.format(dtf));

        if (tipas.equals("1")){
            System.out.println("Mesos rusis:");
            String rusis = scannerStr.nextLine();
            csv.pridetiProduktaICSV(new MesaImpl(id,pavadinimas,kaina,galiojimas,rusis));
        } else {
            System.out.println("Ar ekologiskas ? true / false");
            String arEkologiskas = scannerStr.nextLine();
            csv.pridetiProduktaICSV(new VaisiusImpl(id,pavadinimas,kaina,galiojimas,Boolean.parseBoolean(arEkologiskas)));
        }
        run();
    }
}