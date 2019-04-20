package Domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Inchiriere extends Entity {
    private String idMasina;
    private int numberOfDays;
    private double kilometriParcursi;

    public Inchiriere(String id, String idMasina, int numberOfDays, double kilometriParcursi) {
        super(id);
        this.idMasina = idMasina;
        this.numberOfDays = numberOfDays;
        this.kilometriParcursi = kilometriParcursi;
    }


    @Override
    public String toString() {
        return "Inchiriere1{" +
                "idMasina='" + idMasina + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", kilometriParcursi=" + kilometriParcursi +
                '}';
    }

    public String getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(String idMasina) {
        this.idMasina = idMasina;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getKilometriParcursi() {
        return kilometriParcursi;
    }

    public void setKilometriParcursi(double kilometriParcursi) {
        this.kilometriParcursi = kilometriParcursi;
    }
}



