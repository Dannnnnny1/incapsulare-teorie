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
    //todo: functie care returneaza elementele comune din 2 liste

    public List<Masina>elementeComune(List<Masina>lista1,List<Masina>lista2){
        List<Masina>elementeComune=new ArrayList<>();
        for(int i=0;i<lista1.size();i++){
            if(lista2.contains(lista1.get(i))){
                elementeComune.add(lista1.get(i));
            }
        }
        return elementeComune;
    }

    public List<Masina>filtruMasina(Filtru filtru) {
        List<Masina> rezultat = new ArrayList<>(this.masini);
        boolean filtruAplicat = false;
        if (filtru.pretMaxim > 0 || filtru.pretMinim > 0) {
            int minPret = 0;
            int maxPret = Integer.MAX_VALUE;

            if (filtru.pretMinim > 0) {
                minPret=filtru.pretMinim;

            }
            if(filtru.pretMaxim>0){
                maxPret=filtru.pretMaxim;
            }
            rezultat=filtruPret(maxPret,maxPret);
            filtruAplicat=true;

        }
        if(filtru.marca!=null&&filtru.marca.isEmpty()) {
            if (filtruAplicat) {
                List<Masina> MasiniFiltrareMarca = filtruMarca(filtru.marca);
                rezultat = elementeComune(rezultat, MasiniFiltrareMarca);
            } else {
                rezultat = filtruMarca(filtru.marca);
                filtruAplicat = true;
            }
        }
        if (filtru.model != null && !filtru.model.isEmpty()) {
            if (filtruAplicat) {
                List<Masina> masiniFiltrateModel = filtruModel(filtru.model);
                rezultat = elementeComune(rezultat, masiniFiltrateModel);
            } else {
                rezultat = filtruModel(filtru.model);
                filtruAplicat = true;
            }
        }
        if (filtru.kmMaxim > 0 || filtru.kmMinim > 0) {
            int minKm = 0;
            int maxKm = Integer.MAX_VALUE;

            if (filtru.kmMinim > 0) {
                minKm = filtru.kmMinim;
            }
            if (filtru.kmMaxim > 0) {
                maxKm = filtru.kmMaxim;
            }
            if (filtruAplicat) {
                List<Masina> masiniFitrateKm = filtruKm(minKm, maxKm);
                rezultat = elementeComune(rezultat, masiniFitrateKm);
            } else {
                rezultat = filtruKm(minKm, maxKm);
            }
        }

        return rezultat;
    }
    //todo:CRUD

    //todo:CREATE
    //todo:functie de generare a id u lui automat

    public void adaugaMasina(double pret,String marca,String model,double km,boolean uzata,String inmatriculare){

        //todo:id functie de generare id
        //todo: unicitate


        Masina masinanoua=new Masina();
        int id=genereazaIdAutomat();
        masinanoua.id=id;
        masinanoua.pret=pret;
        masinanoua.marca=marca;
        masinanoua.model=model;
        masinanoua.km=km;
        masinanoua.uzata=uzata;
        masinanoua.inmatriculare=inmatriculare;
        this.masini.add(masinanoua);
    }

    public int genereazaIdAutomat(){
        if(masini.isEmpty()){
            return 1;
        }
        int maxId=0;
        for(Masina masina:masini){
            if(masina.id>maxId){
                maxId=masina.id;
            }
        }
        return maxId+1;
    }
    //todo:Delete
    public boolean stergeDupaId(int id){
        for(int i=0;i<masini.size();i++){
            Masina masina=masini.get(i);
            if(masina.id==id){
                masini.remove(i);
                return true;
            }
        }
        return false;
    }
    //todo:update
    public void modificaPretul(int id,int pret){
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).id==id){
                this.masini.get(i).pret=pret;
                break;
            }
        }
    }
    //todo:read
    //todo:afiseaza toate masinile de o anumita marca
    public List arataDupaMarca(String marca){
        List<Masina>masini=new ArrayList<>();
        for(int i=0;i<this.masini.size();i++){
            if(this.masini.get(i).marca.equals(marca)){
                masini.add(this.masini.get(i));
            }
        }
        return masini;
    }

}
