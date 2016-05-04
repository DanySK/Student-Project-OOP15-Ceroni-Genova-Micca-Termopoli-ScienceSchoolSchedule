package Model;

public class PersonImpl implements Person {

    protected String name;
    protected String surname;

    public PersonImpl(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
