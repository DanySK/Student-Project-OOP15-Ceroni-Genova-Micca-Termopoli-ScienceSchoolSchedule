package Model;

public enum ListCourses {
    
    //First Year 
    ANALISI_MATEMATICA(Type.FIRST_YEAR, ListProfessor.ALBANO, "Analisi Matematica"), 
    PROGRAMMAZIONE(Type.FIRST_YEAR, ListProfessor.CARBONARO,
                        ListProfessor.DI_LENA, ListProfessor.STRAPPAVECCIA, "Programmazione"),
    INGLESE_B1(Type.FIRST_YEAR, ListProfessor.C_L_A, "Inglese B1"),
    ALGEBRA_E_GEOMETRIA(Type.FIRST_YEAR, ListProfessor.CANTARINI, "Algebra e Geometria"),
    ALGORITMI_E_STRUTTURE_DATI(Type.FIRST_YEAR, ListProfessor.MARGARA, 
                        ListProfessor.DI_LENA, ListProfessor.MANIEZZO, "Algoritmi e Strutture Dati"),
    ARCHITETTURA_DEGLI_ELABORATORI(Type.FIRST_YEAR, ListProfessor.MALTONI, 
                        ListProfessor.CAPPELLI, "Architettura degli  Elaboratori"),
    
    //Second Year 
    PROGRAMMAZIONE_AD_OGGETTI(Type.SECOND_YEAR, ListProfessor.VIROLI, 
                        ListProfessor.CASADEI, "Programmazione ad Oggetti"),
    SISTEMI_OPERATIVI(Type.SECOND_YEAR, ListProfessor.GHINI, "Sistemi Operativi"),
    BASI_DI_DATI(Type.SECOND_YEAR, ListProfessor.MAIO, 
                        ListProfessor.FRANCO, "Basi di Dati"),
    FISICA(Type.SECOND_YEAR, ListProfessor.CAMPARI, 
            ListProfessor.PASQUINI, "Fisica"),
    RETI_DI_TELECOMUNICAZIONE(Type.SECOND_YEAR, ListProfessor.CALLEGATI, "Reti di Telecomunicazione"),
    
    //Second Year ENG
    CONTROLLI_AUTOMATICI(Type.SECOND_YEAR_ENG, ListProfessor.PALLI, 
            ListProfessor.MIMMO, "Controlli Automatici"),
    ELETTRONICA_DEI_SISTEMI_DIGITALI(Type.SECOND_YEAR_ENG, ListProfessor.CODELUPPI, "Elettronica dei Sistemi Digitali"),
    
    //Second Year SCI
    CALCOLO_COMBINATORIO_E_PROBABILITA(Type.SECOND_YEAR_SCI, ListProfessor.CASELLI, "Calcolo Combinatorio e Probabilità"),
    ALGORITMI_NUMERICI(Type.SECOND_YEAR_SCI, ListProfessor.MORIGI, ListProfessor.LAZZARO, "Algoritmi Numerici"),
    
    //Third Year 
    INGEGNERIA_DEL_SOFTWARE(Type.THIRD_YEAR, ListProfessor.RIZZI, "Ingegneria del Software"),
    PROGRAMMAZIONE_DI_RETI(Type.THIRD_YEAR, ListProfessor.D_ANGELO, 
            ListProfessor.CAMPI, "Programmazione di Reti"),
    TECNOLOGIE_WEB(Type.THIRD_YEAR, ListProfessor.SALOMONI, "Tecnologie Web"),
    RICERCA_OPERATIVA(Type.THIRD_YEAR, ListProfessor.MINGOZZI, "Ricerca Operativa"),
    
    //Third Year ENG
    INFORMATICA_E_DIRITTO(Type.THIRD_YEAR_ENG, ListProfessor.CEVENINI, "Informatica e Diritto"),
    ECONOMIA_E_ORGANIZZAZIONE_AZIENDALE(Type.THIRD_YEAR_ENG, ListProfessor.FOCACCI, "Economia e Organizzazione Aziendale"),
    
    //Third Year SCI
    LABORATORIO_DI_BASI_DI_DATI(Type.THIRD_YEAR_SCI, ListProfessor.GOLFARELLI, 
            ListProfessor.LUMINI, "Laboratorio di Basi di Dati"),
    
    //Third Year OPT
    COMPUTER_GRAPHICS(Type.THIRD_YEAR_OPT, ListProfessor.LAZZARO, "Computer Graphics"),
    PROGRAMMAZIONE_DI_SISTEMI_EMBEDDED(Type.THIRD_YEAR_OPT, ListProfessor.RICCI, "Programmazione di Sistemi Embedded"),
    FONDAMENTI_DI_ELABORAZIONE_DI_IMMAGINI(Type.THIRD_YEAR_OPT, ListProfessor.CAPPELLI, "Fondamenti di Elaborazione di Immagini"),
    HIGH_PERFORMANCE_COMPUTING(Type.THIRD_YEAR_OPT, ListProfessor.LEVI, "High Performance Computing"),
    LINGUAGGI_VISUALI_PER_IL_CONTROLLO_DEI_SISTEMI(Type.THIRD_YEAR_OPT, ListProfessor.LEVI, "Linguaggi Visuali per il Controllo dei Sistemi"),
    PROGRAMMAZIONE_DI_APPLICAZIONI_DATA_INTENSIVE(Type.THIRD_YEAR_OPT, ListProfessor.MORO, 
            ListProfessor.DOMENICONI, "Programmazione di Applicazioni Data Intensive"),
    PROGRAMMAZIONE_DI_SISTEMI_MOBILE(Type.THIRD_YEAR_OPT, ListProfessor.RAVAIOLI, "Programmazione di Sistemi Mobile"), 
    SISTEMI_MULTIMEDIALI(Type.THIRD_YEAR_OPT, ListProfessor.SALOMONI, ListProfessor.FERRETTI, "Sistemi Multimediali"),
    
    //Fourth Year
    INGLESE_B2(Type.FIRST_YEAR, ListProfessor.C_L_A, "Inglese B2"), 
    LINGUAGGI_DI_PROGRAMMAZIONE_E_MODELLI_COMPUTAZIONALI(Type.FOURTH_YEAR, ListProfessor.BRAVETTI, "Linguaggi di Programmazione e Modelli Computazionali"),
    SISTEMI_INFORMATIVI(Type.FOURTH_YEAR, ListProfessor.GOLFARELLI, "Sistemi Informativi"),
    BUSINESS_INTELLIGENCE(Type.FOURTH_YEAR, ListProfessor.RIZZI, 
            ListProfessor.LUMINI, "Business Intelligence"),
    INTELLIGENZA_ARTIFICIALE(Type.FOURTH_YEAR, ListProfessor.MANIEZZO, "Intelligenza Artificiale"),
    PROGRAMMAZIONE_AVANZATA_E_PARADIGMI(Type.FOURTH_YEAR, ListProfessor.RICCI, "Programmazione Avanzata e Paradigmi"),
    SICUREZZA_DELLE_RETI(Type.FOURTH_YEAR, ListProfessor.D_ANGELO, "Sicurezza delle Reti"),
    SISTEMI_DISTRIBUITI(Type.FOURTH_YEAR, ListProfessor.OMICINI, "Sistemi Distribuiti"),
    
    //Fifth Year
    INGEGNERIA_DEI_SISTEMI_SOFTWARE(Type.FIFTH_YEAR, ListProfessor.NATALI, "Ingegneria dei Sistemi Software"),
    APPLICAZIONI_E_SERVIZI_WEB(Type.FIFTH_YEAR, ListProfessor.MIRRI, 
            ListProfessor.PRANDI, "Applicazioni e Servizi Web"),
    ATTIVITA_PROPEDEUTICA_ALLA_PROVA_FINALE(Type.FIFTH_YEAR, ListProfessor.NATALI, "Attività Propedeutica alla Prova Finale"),
    
    //Fifth Year Opt
    INSTRADAMENTO_E_TRASPORTO_IN_INTERNET(Type.FIFTH_YEAR_OPT, ListProfessor.CALLEGATI, "Instradamento e Trasporto in Internet"),
    METODI_ED_ALGORITMI_DI_OTTIMIZZAZIONE_PER_IL_PROBLEM_SOLVING(Type.FIFTH_YEAR_OPT, ListProfessor.MINGOZZI, "Metodi ed Algoritmi di Ottimizzazione per il Problem Solving"),
    DATA_MINING(Type.FIFTH_YEAR_OPT, ListProfessor.GOLFARELLI, 
            ListProfessor.MORO, "Data Mining"),
    SISTEMI_AUTONOMI(Type.FIFTH_YEAR_OPT, ListProfessor.OMICINI, "Sistemi Autonomi"),
    SISTEMI_DI_SUPPORTO_ALLE_DECISIONI(Type.FIFTH_YEAR_OPT, ListProfessor.MANIEZZO, "Sistemi di Supporto alle Decisioni"),
    SMART_CITY_E_TECNOLOGIE_MOBILI(Type.FIFTH_YEAR_OPT, ListProfessor.MAIO, 
            ListProfessor.FRANCO, "Smart City e Tecnologie Mobili"),
    VISIONE_ARTIFICIALE_E_RICONOSCIMENTO(Type.FIFTH_YEAR_OPT, ListProfessor.MALTONI, 
            ListProfessor.FRANCO, "Visione Artificiale e Riconoscimento"),
    INGEGNERIA_DEI_SISTEMI_SOFTWARE_ADATTATIVI_COMPLESSI(Type.FIFTH_YEAR_OPT, ListProfessor.VIROLI, 
            ListProfessor.PIANINI, ListProfessor.RICCI, "Ingegneria dei Sistemi Software Adattativi Complessi"),
    PROJECT_MANAGEMENT(Type.FIFTH_YEAR_OPT, ListProfessor.BOSCHETTI, "Project Management"),
    SISTEMI_INTELLIGENTI_ROBOTICI(Type.FIFTH_YEAR_OPT, ListProfessor.ROLI, "Sistemi Intelligenti Robotici"),
    TECNICHE_AVANZATE_PER_L_ANALISI_DELLE_IMMAGINI_E_VISIONE(Type.FIFTH_YEAR_OPT, ListProfessor.BEVILACQUA, "Tecniche Avanzate per l'Analisi delle Immagini e Visione"),
    WEB_SEMANTICO(Type.FIFTH_YEAR_OPT, ListProfessor.CARBONARO, "Web Semantico");

    private final Type type;
    private final ListProfessor prof;
    private ListProfessor prof1 = null;
    private ListProfessor prof2 = null;
    private final String value;

    private ListCourses(Type type, ListProfessor professor, String value) {
        this.type = type;
        this.prof = professor;
        this.value = value;
    }

    private ListCourses(Type type, ListProfessor professor, ListProfessor professor1, String value) {
        this.type = type;
        this.prof = professor;
        this.prof1 = professor1;
        this.value = value;
    }

    private ListCourses(Type type, ListProfessor professor, ListProfessor professor1, 
                                                ListProfessor professor2, String value) {
        this.type = type;
        this.prof = professor;
        this.prof1 = professor1;
        this.prof2 = professor2;
        this.value = value;
    }

    public Type getType() {
        return this.type;
    }

    public ListProfessor getProf() {
        return this.prof;
    }
    
    public ListProfessor getProf1() {
        return this.prof1;
    }
    
    public ListProfessor getProf2() {
        return this.prof2;
    }
    
    public String getValue(){
        return this.value;
    }
}
