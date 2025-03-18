package app;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       MasinaView masinaView=new MasinaView();
        masinaView.play();
       List<Masina>masina1=new ArrayList<>();
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

        masina1.add(m1);
        masina1.add(m2);
        masina1.add(m3);
        masina1.add(m4);
        masina1.add(m5);


       List<Masina>masina2=new ArrayList<>();

       masina2.add(m1);
        masina2.add(m3);
        masina2.add(m4);


       //MasinaService masinaService=new MasinaService();
        //System.out.println(masinaService.pretulMediuAlMasinilor());
        MasinaService masinaService=new MasinaService();


        List<Masina> masini=masinaService.elementeComune(masina1,masina2);

    }
}