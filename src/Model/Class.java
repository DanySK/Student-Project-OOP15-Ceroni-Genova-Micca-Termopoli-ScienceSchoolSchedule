package Model;

public enum Class {
    MAGNA("Aula Magna Vicolo Carbonaro"),
    MAGNA_PSICO("Aula Magna Psicologia"),
    A("Aula A"),
    B("Aula B"),
    C("Aula C"),
    D("Aula D"),
    E("Aula E"),
    VELA("Laboratorio Vela"),
    LAB2("Laboratorio 2"),
    LAB3("Laboratorio 3"),
    GPT("Aula G.P.T. Via Genova");
    
     
     private final String y;
     
     private Class(String l){
         this.y = l;
     }
     
     public String getValue(){
         return this.y;
     }
}
