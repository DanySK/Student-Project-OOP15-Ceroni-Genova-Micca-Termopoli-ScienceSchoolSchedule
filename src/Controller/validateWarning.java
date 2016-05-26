package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Days;
import Model.ErrorException;
import Model.Type;
import Model.WarningException;

public class validateWarning {

    private ControllerWorkers contWorkers = new ControllerWorkers();
    private Reservation cont;

    public boolean validateWARNING(Reservation cont)  throws WarningException, ErrorException {
        this.cont = cont;
        Boolean check = true;
        if (!checkHoursForDayProf()) {
            check = false;
            throw new WarningException("Il prof. svolge 6 ore di lezione"+"\n"+"Aggiungere la settima ora?"); // 6 ore al giorno

        } else if (!check4TimeWeekProfessor()) {
            check = false;
            throw new WarningException("Il prof. svolge 4 giorni di lezione"+"\n"+"Aggiungerlo anche nel quinto?");  // più di 4 giorni a settimana
                                                  // prof

        } else if (!check4TimeWeekStudent()) {
            check = false;
            throw new WarningException("Gli studenti di questo anno svolgono 4 giorni di lezione"+"\n"+"Aggiungerlo anche nel quinto?"); // più di 4 giorni a settimana
                                                  // stud
        }else if (cont.getCourse().getType().equals(Type.FIRST_YEAR)) { /// corso del 1° anno
            if (!checkCDLFirstYear()) { // corso non inseribile
                check = false;
                throw new WarningException(""+"\n"+""); //
            }

        } else if (Type.getSecondYears().contains(cont.getCourse().getType())) { // corso del 2° anno
            if (!checkCDLSecondYear()) { // corso non inseribile
                check = false;
                throw new IllegalArgumentException(); //
            }

        } else if (Type.getThirdYears().contains(cont.getCourse().getType())) { // corso del 3° anno
            if (!checkCDLThirdYear()) { // corso non inseribile
                check = false;
                throw new IllegalArgumentException();
            }

        } else if (cont.getCourse().getType().equals(Type.FOURTH_YEAR)) { // corso del 4° anno
            if (!checkCDLFourthYear()) { // corso non inseribile
                check = false;
                throw new IllegalArgumentException();
            }
        } else if (Type.getFifthYears().contains(cont.getCourse().getType())) { // corso del 5° anno
            if (!checkCDLFifthYear()) { // corso non inseribile
                check = false;
                throw new IllegalArgumentException(); //
            }
        }

        return check;
    }

   
    private Boolean checkCDLFirstYear()throws WarningException, ErrorException {
        //boolean check = false;
        List<Type> listType = new ArrayList<>();        

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if(res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())){
                        throw new WarningException("");
                }
                listType.add(res.getCourse().getType());

            }
        }
       if (listType.contains(Type.FIRST_YEAR)) {
           throw new ErrorException("");
        } 

       
        return true;
    }

    private Boolean checkCDLSecondYear() throws WarningException, ErrorException{
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if(res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())){
                    throw new WarningException("");
                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.SECOND_YEAR_ENG) && cont.getCourse().getType().equals(Type.SECOND_YEAR_SCI)) {
           return true;
        } else if (listType.contains(Type.SECOND_YEAR_SCI) && cont.getCourse().getType().equals(Type.SECOND_YEAR_ENG)) {
            return true;
        } else {
            throw new ErrorException("");
        }
    }

    private Boolean checkCDLThirdYear()throws WarningException, ErrorException {
        
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if(res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())){
                    throw new WarningException("");
                }
                listType.add(res.getCourse().getType());
            }
        }
        if (listType.contains(Type.THIRD_YEAR_ENG) && cont.getCourse().getType().equals(Type.THIRD_YEAR_SCI)) {
            return true;
        } else if (listType.contains(Type.THIRD_YEAR_SCI) && cont.getCourse().getType().equals(Type.THIRD_YEAR_ENG)) {
            return true;
        } else if (listType.contains(Type.THIRD_YEAR_OPT) && cont.getCourse().getType().equals(Type.THIRD_YEAR_OPT)) {
            return true;
        } else {
            throw new ErrorException("");
        }
    }

    private Boolean checkCDLFourthYear()throws WarningException, ErrorException {
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if(res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())){
                    throw new WarningException("");
                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FOURTH_YEAR)) {
            throw new ErrorException("");
        } 

        return true;
    }

    private Boolean checkCDLFifthYear() throws WarningException, ErrorException{
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if(res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())){
                    throw new WarningException("");
                   
                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FIFTH_YEAR) || listType.contains(Type.FIFTH_YEAR_OPT)) {
          throw new ErrorException("");
        }

        return true;
    }

    private Boolean checkHoursForDayProf()throws WarningException {
        int i = 0;

        for (Reservation reservation : this.contWorkers.getByDay(cont.getDay())) {
            if (reservation.getPerson().toString().equals(cont.getPerson().toString())) {
                i++;
            }
        }
        return i <= 6 ? true : new WarningException(" ") != null;
    }

    private Boolean check4TimeWeekProfessor() throws WarningException{
        int i = 0;
        Set<Integer> tempCount = new HashSet<>();
        for (Reservation reservation : this.contWorkers.getByProfessor(cont.getPerson())) {
            for (Days d : Days.values()) {
                i = 0;
                if (reservation.getDay().equals(d)) {
                    i++;
                }
                if (i != 0) {
                    tempCount.add(i);
                }

            }
        }
        return tempCount.size() <= 4 ? true : new WarningException(" ") != null;
    }

    private boolean check4TimeWeekStudent() throws WarningException{
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

        return tempCount.size() <= 4 ? true : new WarningException(" ") != null;
    }

    
}
