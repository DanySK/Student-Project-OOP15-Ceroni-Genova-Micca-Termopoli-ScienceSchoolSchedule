package Controller;

import java.util.Set;

import Model.Professor;

public interface ProfessorControllerInterface {

    void save(Set<Professor> obj);

    Set<Professor> openFile();

    Set<Professor> createNewEmptyList();

}
