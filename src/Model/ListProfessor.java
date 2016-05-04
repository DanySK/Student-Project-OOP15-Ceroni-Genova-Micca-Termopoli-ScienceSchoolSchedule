package Model;

import java.util.ArrayList;
import java.util.List;

public enum ListProfessor {
    
    //Prof e Tutor Triennale e Magistrale
    ALBANO("Albano", "Paolo", ListCourses.ANALISI_MATEMATICA),
    BEVILACQUA("Bevilacqua", "Alessandro", ListCourses.TECNICHE_AVANZATE_PER_L_ANALISI_DELLE_IMMAGINI_E_VISIONE),
    BOSCHETTI("Boschetti", "Marco Antonio", ListCourses.PROJECT_MANAGEMENT),
    BRAVETTI("Bravetti", "Mario", ListCourses.LINGUAGGI_DI_PROGRAMMAZIONE_E_MODELLI_COMPUTAZIONALI),
    CALLEGATI("Callegati", "Franco", ListCourses.RETI_DI_TELECOMUNICAZIONE, ListCourses.INSTRADAMENTO_E_TRASPORTO_IN_INTERNET),
    CAMPARI("Campari", "Enrico Gianfranco", ListCourses.FISICA),
    CAMPI("Campi", "Aldo", ListCourses.PROGRAMMAZIONE_DI_RETI),
    CANTARINI("Cantarini", "Nicoletta", ListCourses.ALGEBRA_E_GEOMETRIA),
    CAPPELLI("Cappelli", "Raffaele", ListCourses.ARCHITETTURA_DEGLI_ELABORATORI, ListCourses.FONDAMENTI_DI_ELABORAZIONE_DI_IMMAGINI),
    CARBONARO("Carbonaro", "Antonella", ListCourses.PROGRAMMAZIONE, ListCourses.WEB_SEMANTICO),
    CASADEI("Casadei", "Matteo", ListCourses.PROGRAMMAZIONE_AD_OGGETTI),
    CASELLI("Caselli", "Fabrizio", ListCourses.CALCOLO_COMBINATORIO_E_PROBABILITA),
    CEVENINI("Cevenini", "Claudia", ListCourses.INFORMATICA_E_DIRITTO),
    CODELUPPI("Codeluppi", "Rossano", ListCourses.ELETTRONICA_DEI_SISTEMI_DIGITALI),
    D_ANGELO("D'Angelo", "Gabriele", ListCourses.PROGRAMMAZIONE_DI_RETI, ListCourses.SICUREZZA_DELLE_RETI),
    DI_LENA("Di Lena", "Pietro", ListCourses.PROGRAMMAZIONE, ListCourses.ALGORITMI_E_STRUTTURE_DATI),
    DOMENICONI("Domeniconi", "Giacomo", ListCourses.PROGRAMMAZIONE_DI_APPLICAZIONI_DATA_INTENSIVE),
    FERRETTI("Ferretti", "Stefano", ListCourses.SISTEMI_MULTIMEDIALI),
    FOCACCI("Focacci", "Antonio", ListCourses.ECONOMIA_E_ORGANIZZAZIONE_AZIENDALE),
    FRANCO("Franco", "Annalisa", ListCourses.BASI_DI_DATI, ListCourses.SMART_CITY_E_TECNOLOGIE_MOBILI, ListCourses.VISIONE_ARTIFICIALE_E_RICONOSCIMENTO);
  /*  GHINI("Ghini", "Vittorio"),
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
    C_L_A("", "");  */
    
     private final String name;
     private final String surname;
     private ListCourses courses = null;
     private ListCourses courses1 = null;
     private ListCourses courses2 = null;
     
     private ListProfessor(String surname, String name, ListCourses courses){
         this.surname = surname;
         this.name = name;
         this.courses = courses;
     }
     
     private ListProfessor(String surname, String name, ListCourses courses, ListCourses courses1){
         this.surname = surname;
         this.name = name;
         this.courses = courses;
         this.courses1 = courses1; 
     }
     
     private ListProfessor(String surname, String name, ListCourses courses, ListCourses courses1, ListCourses courses2){
         this.surname = surname;
         this.name = name;
         this.courses = courses;
         this.courses1 = courses1; 
         this.courses2 = courses2; 
     }
     
     public String getName(){
         return this.name;
     }
     
     public String getSurname(){
         return this.surname;
     }
     
     public String toStringCourses() {
         return this.courses1==null
                 ? ""+this.courses.getValue() 
                 : this.courses2==null 
                 ? this.courses.getValue()+" "+this.courses1.getValue()
                 :this.courses.getValue()+" "+this.courses1.getValue()+" "+this.courses2.getValue();
     }
     
     public List<ListCourses> getCourses() {
         List<ListCourses> list = new ArrayList<>();
         
         list.add(this.courses);
         if(this.courses1!=null)
             list.add(this.courses1);
         if(this.courses2!=null)
             list.add(this.courses2);

         return list;
     }
     
     public String toString(){
         return this.surname+" "+this.name;
     }
}
