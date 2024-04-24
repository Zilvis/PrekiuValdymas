package org.example.CSVIE;

import org.example.Prekes.MesaImpl;
import org.example.Prekes.Produktas;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVImportExportImpl implements CSVImportExport{
    private String outputFilePath = "src/main/resources/Produktai.csv";
    @Override
    public List<Produktas> importuotiIsCSV() {
        List<Produktas> produktuSarasas = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(outputFilePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] lineValues = line.split(",");

                produktuSarasas.add(new MesaImpl(Integer.parseInt(lineValues[0]),lineValues[1],Double.parseDouble(lineValues[2]),
                        LocalDate.parse(lineValues[3]),lineValues[4]));
            }

            bufferedReader.close();
        } catch (NumberFormatException e){
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }

        catch (IOException e) {
            System.err.println("Nepavyko skaityti failo: " + e.getMessage());
        }

        return produktuSarasas;
    }

    @Override
    public void pridetiProduktaICSV(Produktas produktas) {
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(produktas.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Nepavyko rasyti failo: " + e.getMessage());
        }
    }

    @Override
    public void pasalintiProduktaIsCSV(int produktoKodas) {
        List<Produktas> produktuSarasas = importuotiIsCSV();
        produktuSarasas.removeIf(produktas -> produktas.getKodas() == produktoKodas);
        eksportuotiICSV(produktuSarasas);
    }

    public void eksportuotiICSV(List<Produktas> produktuSarasas) {
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Produktas produktas : produktuSarasas) {
                bufferedWriter.write(produktas.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Nepavyko rasyti failo: " + e.getMessage());
        }
    }
}
