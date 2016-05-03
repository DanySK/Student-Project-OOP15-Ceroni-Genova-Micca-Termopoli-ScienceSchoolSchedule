package Model;

public enum ListProfessor {
    
    //Prof e Tutor Triennale e Magistrale
    ALBANO("Albano", "Paolo"),
    BEVILACQUA("Bevilacqua", "Alessandro"),
    BOSCHETTI("Boschetti", "Marco Antonio"),
    BRAVETTI("Bravetti", "Mario"),
    CALLEGATI("Callegati", "Franco"),
    CAMPARI("Campari", "Enrico Gianfranco"),
    CAMPI("Campi", "Aldo"),
    CANTARINI("Cantarini", "Nicoletta"),
    CAPPELLI("Cappelli", "Raffaele"),
    CARBONARO("Carbonaro", "Antonella"),
    CASADEI("Casadei", "Matteo"),
    CASELLI("Caselli", "Fabrizio"),
    CEVENINI("Cevenini", "Claudia"),
    CODELUPPI("Codeluppi", "Rossano"),
    D_ANGELO("D'Angelo", "Gabriele"),
    DI_LENA("Di Lena", "Pietro"),
    DOMENICONI("Domeniconi", "Giacomo"),
    FERRETTI("Ferretti", "Stefano"),
    FOCACCI("Focacci", "Antonio"),
    FRANCO("Franco", "Annalisa"),
    GHINI("Ghini", "Vittorio"),
    GOLFARELLI("Golfarelli", "Matteo"),
    LAZZARO("Lazzaro", "Damiana"),
    LEVI("Levi", "Giuseppe"),
    LUMINI("Lumini", "Alessandra"),
    MAIO("Maio", "Dario"),
    MALTONI("Maltoni", "Davide"),
    MANIEZZO("Maniezzo", "Vittorio"),
    MARGARA("Margara", "Luciano"),
    MIMMO("Mimmo", "Nicola"),
    MINGOZZI("Mingozzi", "Aristide"),
    MIRRI("Mirri", "Silvia"),
    MORIGI("Morigi", "Serena"),
    MORO("Moro", "Gianluca"),
    NATALI("Natali", "Antonio"),
    OMICINI("Omicini", "Andrea"),
    PALLI("Palli", "Gianluca"),
    PASQUINI("Pasquini", "Luca"),
    PIANINI("Pianini", "Danilo"),
    PRANDI("Prandi", "Catia"),
    RAVAIOLI("Ravaioli", "Mirko"),
    RICCI("Ricci", "Alessandro"),
    RIZZI("Rizzi", "Stefano"),
    ROLI("Roli", "Andrea"),
    SALOMONI("Salomoni", "Paola"),
    STRAPPAVECCIA("Strappaveccia", "Francesco"),
    VIROLI("Viroli", "Mirko"),
    C_L_A("", "");
    
     private final String name;
     private final String surname;
     
     private ListProfessor(String m, String l){
         this.surname = m;
         this.name = l;
     }
     
     public String getName(){
         return this.name;
     }
     
     public String getSurname(){
         return this.surname;
     }
     
     public String toString(){
         return this.surname+" "+this.name;
     }
}
