package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Days;
import Model.ErrorException;
import Model.Type;
import Model.WarningException;

public class ValidateWarning implements ValidateWarningInterface {

    private ControllerWorkers contWorkers = new ControllerWorkers();
    private Reservation cont;

    public void validateWARNING(Reservation cont) throws WarningException, ErrorException {
        this.cont = cont;

        checkHoursForDayProf();// 6 ore al giorno
        check4TimeWeekProfessor(); // più di 4 giorni a settimana,
        check4TimeWeekStudent(); // più di 4 giorni a settimana
    }

    /**
     * this method check if professor work more of six hours in a day. if more
     * six hours make a warning error
     * 
     * @throws WarningException
     */
    private void checkHoursForDayProf() throws WarningException {
        int i = 0;
        for (Reservation reservation : this.contWorkers.getByDay(cont.getDay())) {
            if (reservation.getPerson().toString().equals(cont.getPerson().toString())) {
                i++;
            }
        }
        if (i >= 6) {
            new WarningException("Il prof. svolge "+i+" ore di lezione" + "\n" + "Aggiungere la settima ora?");
        }
    }

    /**
     * this method check if professor work more of 4 day in a week. if more 4
     * day make a warning error
     * 
     * @throws WarningException
     */
    private void check4TimeWeekProfessor() throws WarningException {
        int i = 0;
        Set<Integer> tempCount = new HashSet<>();

        for (Days d : Days.values()) {
            i = 0;
            for (Reservation reservation : this.contWorkers.getByProfessor(cont.getPerson())) {

                if (reservation.getDay().equals(d)) {
                    i++;
                }

            }
            if (i != 0) {
                tempCount.add(i);
            }
        }

        if (tempCount.size() <= 4) {
            new WarningException("Il prof. svolge " + tempCount.size() + " giorni di lezione" + "\n"
                    + "Aggiungerlo anche nel quinto?");
        }
    }

    /** 
     * this method check if students work more of 4 day in a week. 
     * if more 4 day make a warning error
     * @throws WarningException
     */
    private void check4TimeWeekStudent() throws WarningException {
        int i = 0;
        Set<Integer> tempCount = new HashSet<>();
        List<Type> listType = new ArrayList<>();

        for (Days d : Days.values()) {
            i = 0;
            for (Reservation res : this.contWorkers.getByDay(d)) {
                listType.add(res.getCourse().getType());
            }

            if (listType.contains(cont.getCourse().getType())) {
                i++;
            }
            if (i != 0) {
                tempCount.add(i);
            }
        }
        if (tempCount.size() <= 4) {
            new WarningException("Gli studenti di questo anno svolgono 4 giorni di lezione" + "\n"
                    + "Aggiungerlo anche nel quinto?");
        }
    }

}
