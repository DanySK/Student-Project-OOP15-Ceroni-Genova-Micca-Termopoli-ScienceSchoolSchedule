package Model;

public enum ListCourses {
    
    //First Year 
    ANALISI_MATEMATICA(Type.FIRST_YEAR, ListProfessor.ALBANO, "Analisi Matematica"), 
    PROGRAMMAZIONE(Type.FIRST_YEAR, ListProfessor.CARBONARO,
                        ListProfessor.DI_LENA, ListProfessor.STRAPPAVECCIA, "Programmazione"),
    INGLESE(Type.FIRST_YEAR, ListProfessor.C_L_A, "Inglese"),
    ALGEBRA_E_GEOMETRIA(Type.FIRST_YEAR, ListProfessor.CANTARINI, "Algebra e Geometria"),
    ALGORITMI_E_STRUTTURE_DATI(Type.FIRST_YEAR, ListProfessor.MARGARA, 
                        ListProfessor.DI_LENA, ListProfessor.MANIEZZO, "Algoritmi e Strutture Dati"),
    ARCHITETTURA_DEGLI_ELABORATORI(Type.FIRST_YEAR, ListProfessor.MALTONI, 
                        ListProfessor.CAPPELLI, "Architettura degli  Elaboratori"),
    
    //Second Year ENG and SCI
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
    
    
    
    
    
    
    
    
    ;

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
