package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasinaService {

    public List<Masina> masini = new ArrayList<>();

    public void load() {
        Masina m1 = new Masina();
        m1.id = 1;
        m1.pret = 1000;
        m1.km = 280000;
        m1.marca = "Audi";
        m1.model = "A4";
        m1.inmatriculare = "SB03DXR";
        m1.uzata = true;


        Masina m2 = new Masina();
        m2.id = 2;
        m2.km = 150000;
        m2.pret = 7000;
        m2.marca = "Renault";
        m2.model = "Talisman";
        m2.inmatriculare = "SB17BLT";
        m2.uzata = true;


        Masina m3 = new Masina();
        m3.id = 3;
        m3.km = 180000;
        m3.pret = 9000;
        m3.marca = "BMW";
        m3.model = "F30";
        m3.inmatriculare = "SB10BLT";
        m3.uzata = true;


        Masina m4 = new Masina();
        m4.id = 5;
        m4.km = 190000;
        m4.pret = 20000;
        m4.marca = "Range Rover";
        m4.model = "Evoque";
        m4.inmatriculare = "CJ18HXC";
        m4.uzata = true;


        Masina m5 = new Masina();
        m5.id = 5;
        m5.km = 0;
        m5.pret = 10000;
        m5.marca = "Dacia";
        m5.model = "Logan";
        m5.inmatriculare = "SB01DAC";
        m5.uzata = false;

        masini.add(m1);
        masini.add(m2);
        masini.add(m3);
        masini.add(m4);
        masini.add(m5);

    }

    //todo:functie ce returneaza masina cea mai scumpa
    public double pretulCelMaiMare() {
        double max = 0;
        for (int i = 0; i < this.masini.size(); i++) {
            max = -1;
            if (this.masini.get(i).pret > max) {
                max = this.masini.get(i).pret;
            }
        }
        return max;
    }

    public Masina masinaCeaMaiScumpa() {
        Masina maxima = this.masini.get(0);
        for (int i = 0; i < this.masini.size(); i++) {
            if (this.masini.get(i).pret > maxima.pret) {
                maxima = this.masini.get(i);
            }

        }
        return maxima;
    }

    public void afisareMasini() {
        for (int i = 0; i < this.masini.size(); i++) {

            System.out.println("===================================");
            System.out.println(this.masini.get(i).descriere());
        }
    }

    public List<Masina> masiniNoi() {
        List<Masina> masiniN = new ArrayList<>();
        for (Masina m : this.masini) {
            if (!m.uzata) {
                masiniN.add(m);
            }
        }
        return masiniN;
    }
    //todo:returneaza toate masinile dupa pret crescator
    public List<Masina>masiniIefine(){
        for(int i=0;i<this.masini.size();i++){
            for(int j=0;j<this.masini.size()-i-1;j++){
                if(this.masini.get(j).pret>this.masini.get(j+1).pret){
                    Masina temp=masini.get(j);
                    masini.set(j,masini.get(j+1));
                    masini.set(j+1,temp);

                }
            }
        }

        return masini;
    }
    //todo:Funcție care primește un număr de înmatriculare și returnează mașina corespunzătoare.

    public List<Masina> cautareDupaNrDeInmatriculare(String nrInmatriculare ) {

        List<Masina>masini=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).inmatriculare.equals(nrInmatriculare)){
                masini.add(this.masini.get(i));
            }
        }
        return masini;
    }

    //todo:Funcție care calculează și returnează media prețurilor tuturor mașinilor din listă.

    public int pretulTotalAlMasinilor(){
        int total=0;
        for(int i=0;i<this.masini.size();i++){
            total+=this.masini.get(i).pret;
        }
        return total;
    }

    //todo:Funcție care verifică dacă există deja o mașină cu o anumită marcă și un anumit model.

    public boolean verificareDacaExista(String marca,String model){
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).model.equals(model)&&this.masini.get(i).marca.equals(marca)){
                return true;
            }
        }
        return false;
    }
    //todo:Modificarea prețului unei mașini
    //todo:Funcție care primește un id și un nou preț, apoi actualizează prețul acelei mașini.

    public void modificaPretul(int id,int pret){
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).id==id){
                this.masini.get(i).pret=pret;
                break;
            }
        }
    }

    //todo:functie care adauga o noua masina in lista
    public Boolean adaugaMasina(int id,double pret,String marca,String model,double km,boolean uzata,String inmatriculare){

       //todo:id functie de generare id
        //todo: unicitate


        Masina masinanoua=new Masina();
        masinanoua.id=id;
        masinanoua.pret=pret;
        masinanoua.marca=marca;
        masinanoua.model=model;
        masinanoua.km=km;
        masinanoua.uzata=uzata;
        masinanoua.inmatriculare=inmatriculare;
        this.masini.add(masinanoua);
        return null;
    }

    //todo:Numărarea mașinilor uzate – Returnează câte mașini uzate sunt în listă.

    public int cateMasiniUzate(){
        int cnt=0;
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).uzata){
                cnt++;
            }
        }
        return cnt;
    }
    //todo:filtrare masini in functie de pret, marca,model, an de fabricatie.

    public List<Masina> filtruPret(int pretMinim,int pretMaxim){

         // conditie?ex1:ex2;
        int minim=pretMinim<pretMaxim?pretMinim:pretMaxim;
        int maxim=pretMaxim>pretMinim?pretMaxim:pretMinim;
        List<Masina>masini=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).pret>minim && this.masini.get(i).pret<maxim){
                masini.add(this.masini.get(i));
            }
        }
        return masini;
    }
    //todo:filtru in functie de marca
    public List<Masina>filtruMarca(String marca){
        List<Masina>masini=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).marca.equals(marca)){
                masini.add(this.masini.get(i));

            }
        }
        return masini;
    }

    //todo:filtru in functie de model
    //todo:filtru in functie de marca

    public List<Masina>filtruModel(String model){
        List<Masina>masini=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).model.equals(model)){
                masini.add(this.masini.get(i));

            }
        }
        return masini;
    }

    //todo:filtru Kilometri
    public List<Masina> filtruKm(int kmMinim,int kmMaxim){

        // conditie?ex1:ex2;
        int minim=kmMinim<kmMaxim?kmMinim:kmMaxim;
        int maxim=kmMaxim>kmMinim?kmMaxim:kmMinim;
        List<Masina>masini=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).km>minim && this.masini.get(i).km<maxim){
                masini.add(this.masini.get(i));
            }
        }
        return masini;
    }

    //todo:filtru
    //"
    public List<Masina>filtru(Filtru filtru){
        List<Masina>masiniFiltrare=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){


        }
        return null;
    }






}
