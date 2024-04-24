package org.example.Prekes;

import java.time.LocalDate;

public class Produktas {
    private int kodas;
    private String pavadinimas;
    private double kaina;
    private LocalDate galiojimoLaikas;

    public Produktas(int kodas, String pavadinimas, double kaina, LocalDate galiojimoLaikas) {
        this.kodas = kodas;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.galiojimoLaikas = galiojimoLaikas;
    }

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public LocalDate getGaliojimoLaikas() {
        return galiojimoLaikas;
    }

    public void setGaliojimoLaikas(LocalDate galiojimoLaikas) {
        this.galiojimoLaikas = galiojimoLaikas;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", this.kodas, this.pavadinimas, this.kaina, this.galiojimoLaikas);
    }
}
