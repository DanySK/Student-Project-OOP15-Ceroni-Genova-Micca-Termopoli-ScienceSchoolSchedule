package Model;

public enum ListCourses {

    ANALISI_MATEMATICA(Type.FIRST_YEAR, ListProfessor.ALBANO), 
    PROGRAMMAZIONE(Type.FIRST_YEAR, ListProfessor.CARBONARO,
                        ListProfessor.DI_LENA, ListProfessor.STRAPPAVECCIA),
    
    
    
    ;

    private Type type = null;
    private ListProfessor x = null;

    private ListCourses(Type type, ListProfessor professor) {
        this.type = type;
        this.x = professor;
    }

    private ListCourses(Type type, ListProfessor professor, ListProfessor professor1) {
        this.type = type;
        this.x = professor;
    }

    private ListCourses(Type type, ListProfessor professor, ListProfessor professor1, ListProfessor professor2) {
        this.type = type;
        this.x = professor;
    }

    public Type getValueType() {
        return this.type;
    }

    public ListProfessor getValueProf() {
        return this.x;
    }
}
