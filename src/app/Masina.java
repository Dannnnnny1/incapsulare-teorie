package app;

public class Masina {
    //atribute si metode

    public int id;
    public double pret;
    public String marca;
    public String model;
    public double km;
    boolean uzata;
    public String inmatriculare;


    public  String descriere(){
        String text="";
        text+="Id "+this.id+"\n";
        text+="Marca "+this.marca+"\n";
        text+="Model "+this.model+"\n";
        text+="Km "+this.km+"\n";
        text+="Pret "+this.pret+"\n";
        text+="Inmatriculare "+this.inmatriculare+"\n";
        text+="Uzata "+this.uzata+"\n";
        return text;

    }
}
