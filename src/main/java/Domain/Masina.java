package Domain;

public class Masina extends Entity {
    private String model;
    private double kilometrajAchiz;
    private double pretInchiriereZi;



    public Masina(String id, String model, double kilometrajAchiz, double pretInchiriereZi) {
        super(id);
        this.model = model;
        this.kilometrajAchiz = kilometrajAchiz;
        this.pretInchiriereZi = pretInchiriereZi;
    }


    @Override
    public String toString() {
        return "Masina{" +
                ", model='" + model + '\'' +
                ", kilometrajAchiz='" + kilometrajAchiz + '\'' +
                ", pretInchiriereZi" + pretInchiriereZi +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getKilometrajAchiz() {
        return kilometrajAchiz;
    }

    public void setKilometrajAchiz(double kilometrajAchiz) {
        this.kilometrajAchiz = kilometrajAchiz;
    }

    public double getPretInchiriereZi() {
        return pretInchiriereZi;
    }

    public void setPretInchiriereZi(double pretInchiriereZi) {
        this.pretInchiriereZi = pretInchiriereZi;
    }
}

