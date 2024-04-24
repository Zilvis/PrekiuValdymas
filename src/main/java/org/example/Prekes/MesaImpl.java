package org.example.Prekes;

import java.time.LocalDate;

public class MesaImpl extends Produktas implements Mesa {
    private String mesosRusis;

    public MesaImpl(int kodas, String pavadinimas, double kaina, LocalDate galiojimoLaikas, String mesosRusis) {
        super(kodas, pavadinimas, kaina, galiojimoLaikas);
        this.mesosRusis = mesosRusis;
    }

    public String getMesosRusis() {
        return mesosRusis;
    }

    public void setMesosRusis(String mesosRusis) {
        this.mesosRusis = mesosRusis;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.getKodas(), this.getPavadinimas(), this.getKaina(), this.getGaliojimoLaikas(), this.getMesosRusis());
    }
}
