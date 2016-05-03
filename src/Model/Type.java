package Model;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Type {

    FIRST_YEAR(1, "1° anno laurea triennale", Color.BLUE), SECOND_YEAR(2, "2° anno laurea triennale",Color.CYAN), 
    SECOND_YEAR_ENG(4,"2° anno laurea ingegneria informatica", Color.green), 
    SECOND_YEAR_SCI(5,"2° anno laurea scienze e tecnologie informatiche",Color.magenta), THIRD_YEAR(3,"3° anno laurea triennale",Color.pink), 
    THIRD_YEAR_OPT(6,"3° anno opzionali",Color.ORANGE), THIRD_YEAR_ENG(7,"3° anno laurea ingegneria informatica",Color.WHITE), 
    THIRD_YEAR_SCI(8,"3° anno scienze e tecnologie informariche",Color.RED), FOURTH_YEAR(9,"4° anno laurea magistrale",Color.YELLOW), 
    FIFTH_YEAR(10,"5° anno laurea magistrale",Color.darkGray), FIFTH_YEAR_OPT(11,"5° anno opzionali",Color.LIGHT_GRAY);

    private final int x;
    private final String character;
	private final Color color;

    private Type(Integer i,final String s, final Color c) {
        this.x = i;
        this.character=s;
        this.color=c;
        
    }

    public String getCharacter() {
		return character;
	}

	public Color getColor() {
		return color;
	}

	public int getValue() {
        return this.x;
    }
	
	public static Set<Type> getSubjectTypeValues() {
		return new HashSet<>(Arrays.asList(Type.values()));
	}

}