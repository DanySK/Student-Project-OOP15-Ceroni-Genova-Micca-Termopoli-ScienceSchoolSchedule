package Model;

public enum ListProfessor {
    
    //Prof e Tutor Triennale e Magistrale
    ALBANO("Albano", "Paolo",
            ListCourses.ANALISI_MATEMATICA),
    BEVILACQUA("Bevilacqua", "Alessandro",
            ListCourses.TECNICHE_AVANZATE_PER_L_ANALISI_DELLE_IMMAGINI_E_VISIONE),
    BOSCHETTI("Boschetti", "Marco Antonio",
            ListCourses.PROJECT_MANAGEMENT),
    BRAVETTI("Bravetti", "Mario",
            ListCourses.LINGUAGGI_DI_PROGRAMMAZIONE_E_MODELLI_COMPUTAZIONALI),
    CALLEGATI("Callegati", "Franco",
            ListCourses.RETI_DI_TELECOMUNICAZIONE),
    CAMPARI("Campari", "Enrico Gianfranco",
            ListCourses.),
    CAMPI("Campi", "Aldo",
            ListCourses.),
    CANTARINI("Cantarini", "Nicoletta",
            ListCourses.),
    CAPPELLI("Cappelli", "Raffaele",
            ListCourses.),
    CARBONARO("Carbonaro", "Antonella",
            ListCourses.),
    CASADEI("Casadei", "Matteo",
            ListCourses.),
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
