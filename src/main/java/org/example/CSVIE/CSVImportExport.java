package org.example.CSVIE;

import org.example.Prekes.Produktas;

import java.util.List;

public interface CSVImportExport {

    List<Produktas> importuotiIsCSV();
    void pridetiProduktaICSV(Produktas produktas);
    void pasalintiProduktaIsCSV(int produktoKodas);
    void eksportuotiICSV(List<Produktas> produktuSarasas);
}
