package Controller;

import java.util.List;

import Model.Courses;
import Model.Days;
import Model.ErrorException;
import Model.Professor;
import Model.WarningException;

/**
 * @author Massimiliano Micca
 *
 */

public interface ControllerWorkersInterface {

    /** 
     * this method is used for add a reservation in a list
     * @param cont this is reservation to add
     * @throws ErrorException 
     * @throws WarningException 
     */
    public void addRes(Reservation cont) throws ErrorException, WarningException;

    /**
     * @return return a list reservation
     */
    public List<Reservation> getListReservation();

    /**
     * @param d is a day to take a reservation
     * @return a list of reservation in day d
     */
    public List<Reservation> getByDay(Days d);

    /**
     * @param course use to take the reservation that have that course
     * @return list of reservation
     */
    public List<Reservation> getByCourses(Courses course);
    
    // public List<Reservation> getByClass(Room c);

    // public List<Reservation> getByProfessor(Person p);

    // public List<Reservation> getByHour(Hours h);

    /**
     * @return a list of all Course  
     */
    public List<Courses> getCoursesFromFile();

    /**
     * @return a list of all professor 
     */
    public List<Professor> getProfessorFromFile();

    /**
     * @param cont list of all the reservation that you want to remove
     * @throws WarningException
     */
    public void removeAll(List<Reservation> cont) throws WarningException;
    
    /**
     * this method is used to save in file
     */
    public void save();
    
    /**
     * this method is used to check if list of reservation is empty
     * @throws ErrorException
     */
    public void isEmpty() throws ErrorException;
}