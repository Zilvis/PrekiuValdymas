package org.example.Prekes;

import java.time.LocalDate;

public class VaisiusImpl extends Produktas implements Vaisius {
    private boolean arEkologiskas;

    public VaisiusImpl(int kodas, String pavadinimas, double kaina, LocalDate galiojimoLaikas, boolean arEkologiskas) {
        super(kodas, pavadinimas, kaina, galiojimoLaikas);
        this.arEkologiskas = arEkologiskas;
    }

    public boolean isArEkologiskas() {
        return arEkologiskas;
    }

    public void setArEkologiskas(boolean arEkologiskas) {
        this.arEkologiskas = arEkologiskas;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.getKodas(), this.getPavadinimas(), this.getKaina(), this.getGaliojimoLaikas(), this.isArEkologiskas());
    }
}
