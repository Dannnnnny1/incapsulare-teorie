package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasinaView {
    public MasinaService masinaService=new MasinaService();
    public Scanner scanner = new Scanner(System.in);


    public  void meniu(){
        System.out.println("1->afisare masini");
        System.out.println("2->masina cu pretul maxim");
        System.out.println("3->afisare toate masinile noi");
        System.out.println("4->Sortare dupa pret crescator");
        System.out.println("5->Introduceti nr de inmatriculare pt a afisa masina");
        System.out.println("6->Afisati totalul pretului masinilor");
        System.out.println("7->Verificati daca o masina exista deja");
        System.out.println("8->Modificati pretul unei masini in functie de id");
        System.out.println("9->Adaugati o masina noua");
        System.out.println("10->Cate masini uzate");
        System.out.println("11->Filtrare");
        System.out.println("12->Stergere");
        System.out.println("13->Afisarea tuturor masinilor de o anumita marca");
        //todo:meniu de filtrare

        //todo:crud
        //crud create read update delete


    }
    public void play(){
        this.masinaService.load();
        boolean run=true;
        while (run){
            this.meniu();
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    this.masinaService.afisareMasini();;
                    break;
                case 2:
                    afisareMasinaScumpa();
                    break;
                case 3:
                    afisareMasiniNoi();
                    break;
                case 4:
                    afisareMasiniIeftine();
                    break;
                case 5:
                    afisareDupaNrDeInmatriculare();
                    break;
                case 6:
                    afisareaTotalului();
                    break;
                case 7:
                    afisareDacaExista();
                    break;
                case 8:
                    afisareModificaPretul();
                    this.masinaService.afisareMasini();
                    break;
                case 9:
                    afisareAdaugaMasinaNoua();
                    break;
                case 10:
                    afisareCateMasiniUzate();
                    break;
                case 11:
                    afisareFiltrare();
                case 12:
                    afisareStergereMasina();
                case 13:
                    afisareDupaMarca();
                default:
                    System.out.println("test");
            }
        }
    }
    public void afisareMasinaScumpa(){
        Masina maxima=masinaService.masinaCeaMaiScumpa();
        System.out.println(maxima.descriere());
    }
    public void afisareMasiniNoi(){

        List<Masina>masinaNoua= masinaService.masiniNoi();
        for(Masina masini:masinaNoua){
            System.out.println(masini.descriere());
        }

    }
    public void afisareMasiniIeftine(){
        List<Masina>masiniIeftine=masinaService.masiniIefine();
        for(Masina masini:masiniIeftine){
            System.out.println(masini.descriere());
        }

    }
    public void afisareDupaNrDeInmatriculare() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu numarul de inmatriculare: ");
        String nrInmatriculare = scanner.nextLine();
        List<Masina>masiniGasite=masinaService.cautareDupaNrDeInmatriculare(nrInmatriculare);
        if (masiniGasite.isEmpty()) {
            System.out.println("Nu s-a gasit nicio masina cu acest numar de inmatriculare.");
        } else {
            for (Masina masina : masiniGasite) {
                System.out.println(masina.descriere());
            }
        }
    }
    public void afisareaTotalului(){
        int pret=masinaService.pretulTotalAlMasinilor();
        System.out.println(pret);
    }
    public void afisareDacaExista(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti marca");
        String marca=scanner.nextLine();
        System.out.println("Introduceti modelul");
        String model=scanner.nextLine();
        if(masinaService.verificareDacaExista(marca,model)){
            System.out.println("Aceasta masina exista deja");
        }
        else{
            System.out.println("Aceasta masina nu exista");
        }
    }
    public void afisareModificaPretul(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id-ul masinii careia doriti sa ii modificati pretul");
        int id=scanner.nextInt();
        System.out.println("Introduceti noul pret");
        int noulpret=scanner.nextInt();
        masinaService.modificaPretul(id,noulpret);
    }
    public void afisareAdaugaMasinaNoua(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti pretul");
        double pret=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Marca");
        String marca=scanner.nextLine();
        System.out.println("Modelul");
        String model=scanner.nextLine();
        System.out.println("Nr Km");
        double km=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Masina este uzata?");
        boolean uzata=scanner.hasNext();
        scanner.nextLine();
        System.out.println("Inmatriculare");
        String inmatriculare=scanner.nextLine();
        masinaService.adaugaMasina(pret,marca,model,km,uzata,inmatriculare);
    }
    public void afisareCateMasiniUzate(){
        int numar=masinaService.cateMasiniUzate();
        System.out.println("Exista "+numar+" masini uzate");
    }


    public void afisareFiltrare(){
        Scanner scanner=new Scanner(System.in);
        Filtru filtru=new Filtru();
        String raspuns;
        System.out.println("Doriti sa aplicati filtru pentru pret?(da/nu)");
        raspuns=scanner.nextLine();
        if(raspuns.equals("da")||raspuns.equals("DA")||raspuns.equals("Da")){
            System.out.println("Introduceti pretul minim ");
            filtru.pretMinim=Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti pretul maxim");
            filtru.pretMaxim=Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Doriti sa aplicati filtru pentru marca? (da/nu)");
        raspuns = scanner.nextLine();
        if (raspuns.equals("da") || raspuns.equals("DA") || raspuns.equals("Da")) {
            System.out.println("Introduceti marca:");
            filtru.marca = scanner.nextLine();
        }
        System.out.println("Doriti sa aplicati filtru pentru model? (da/nu)");
        raspuns = scanner.nextLine();
        if (raspuns.equals("da") || raspuns.equals("DA") || raspuns.equals("Da")) {
            System.out.println("Introduceti modelul:");
            filtru.model = scanner.nextLine();
        }
        System.out.println("Doriti sa aplicati filtru pentru kilometraj? (da/nu)");
        raspuns = scanner.nextLine();
        if (raspuns.equals("da") || raspuns.equals("DA") || raspuns.equals("Da")) {
            System.out.println("Introduceti kilometrajul minim:");
            filtru.kmMinim = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti kilometrajul maxim:");
            filtru.kmMaxim = Integer.parseInt(scanner.nextLine());
        }
        List<Masina> rezultat = masinaService.filtruMasina(filtru);
        System.out.println("\n===== Rezultatul filtrarii =====");
        if (rezultat.size() == 0) {
            System.out.println("Nu s-au gasit masini care sa respecte toate criteriile.");
        } else {
            System.out.println("S-au gasit " + rezultat.size() + " masini:");
            for (int i=0; i<rezultat.size(); i++) {
                System.out.println(rezultat.get(i).descriere());
            }
        }

    }
    public void afisareStergereMasina(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id a carei masina doriti sa o stergeti");
        int id=scanner.nextInt();
        boolean sters= masinaService.stergeDupaId(id);
        if(sters){
            System.out.println("Masina a fost stearsa cu succes");
        }
        else{
            System.out.println("Masina nu a putut fi stearsa");
        }
    }
    public void afisareDupaMarca(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti marca");
         String marca=scanner.nextLine();
         List<Masina>masini=masinaService.arataDupaMarca(marca);
         for(Masina masina:masini){
             System.out.println(masina.descriere());
         }
    }
}

