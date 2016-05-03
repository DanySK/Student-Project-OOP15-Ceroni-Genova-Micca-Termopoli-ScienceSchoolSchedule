package Model;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Type {

    FIRST_YEAR("1LT : 1°anno laurea triennale", Color.BLUE), 
    SECOND_YEAR("2° anno laurea triennale, 2LT", Color.CYAN), 
    SECOND_YEAR_ENG("2° anno laurea ingegneria informatica, 2LTI", Color.green), 
    SECOND_YEAR_SCI("2° anno laurea scienze e tecnologie informatiche, 2LTS", Color.magenta), 
    THIRD_YEAR("3° anno laurea triennale, 3LT", Color.pink), 
    THIRD_YEAR_OPT("3° anno opzionali, 3LTO", Color.ORANGE), 
    THIRD_YEAR_ENG("3° anno laurea ingegneria informatica, ", Color.WHITE), 
    THIRD_YEAR_SCI("3° anno scienze e tecnologie informariche", Color.RED), 
    FOURTH_YEAR("4° anno laurea magistrale", Color.YELLOW), 
    FIFTH_YEAR("5° anno laurea magistrale", Color.darkGray), 
    FIFTH_YEAR_OPT("5° anno opzionali", Color.LIGHT_GRAY);

    private final String character;
    private final Color color;

    private Type(final String s, final Color c) {
        this.character = s;
        this.color = c;
    }

    public String getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }

    public static Set<Type> getSubjectTypeValues() {
        return new HashSet<>(Arrays.asList(Type.values()));
    }

}