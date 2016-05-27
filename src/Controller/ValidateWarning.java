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
        if (cont.getCourse().getType().equals(Type.FIRST_YEAR)) { // corso del 1°anno, corso non inseribile
            checkCDLFirstYear();
        } else if (Type.getSecondYears().contains(cont.getCourse().getType())) { // corso del 2°anno, corso non inseribile
            checkCDLSecondYear();

        } else if (Type.getThirdYears().contains(cont.getCourse().getType())) { // corso del 3°anno, corso non inseribile
           checkCDLThirdYear();
           
        } else if (cont.getCourse().getType().equals(Type.FOURTH_YEAR)) { // corso del 4°anno, corso non inseribile
            checkCDLFourthYear();
     
        } else if (Type.getFifthYears().contains(cont.getCourse().getType())) { // corso del 5°anno, corso non inseribile
           checkCDLFifthYear();
        }
    }

    private boolean checkCDLFirstYear() throws WarningException, ErrorException {
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if (cont.getHour().getValue().equals(res.getHour().getValue())) {
                if (res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())) {
                        throw new WarningException(
                            "Un corso del primo anno è già inserito in questo periodo" + "\n" + "Inserirne un altro?"); //
                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FIRST_YEAR)) {
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso del primo anno, quindi non può essere sovrapposto");
        }

        return true;
    }

    private boolean checkCDLSecondYear() throws WarningException, ErrorException {
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if (res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())) {
                    throw new WarningException("Un corso del secondo anno è già inserito in questo periodo" + "\n"
                            + "Inserirne un altro?"); //
                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.SECOND_YEAR_ENG) && cont.getCourse().getType().equals(Type.SECOND_YEAR_SCI)) {
            return true;
        } else if (listType.contains(Type.SECOND_YEAR_SCI) && cont.getCourse().getType().equals(Type.SECOND_YEAR_ENG)) {
            return true; 
        } else if(!listType.contains(cont.getCourse().getType())){
            return true;
        }else{
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso del secondo anno, quindi non può essere sovrapposto");
        }
    }

    private boolean checkCDLThirdYear() throws WarningException, ErrorException {

        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if (res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())) {
                    throw new WarningException(
                            "Un corso del terzo anno è già inserito in questo periodo" + "\n" + "Inserirne un altro?"); //
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
        }else if(!listType.contains(cont.getCourse().getType())){
            return true;
        } else {
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso del terzo anno, quindi non può essere sovrapposto");
        }
    }

    private boolean checkCDLFourthYear() throws WarningException, ErrorException {
      
        List<Type> listType = new ArrayList<>();
        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if (res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())) {
                    throw new WarningException(
                            "Un corso del quarto anno è già inserito in questo periodo" + "\n" + "Inserirne un altro?"); //
                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FOURTH_YEAR)) {
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso del quarto anno, quindi non può essere sovrapposto");
        }

        return true;
    }

    private boolean checkCDLFifthYear() throws WarningException, ErrorException {
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                if (res.getCourse().getName().equals(cont.getCourse().getName())
                        && !res.getRoom().getNameRoom().equals(cont.getRoom().getNameRoom())
                        && !res.getPerson().toString().equals(cont.getPerson().toString())) {
                    throw new WarningException(
                            "Un corso del quinto anno è già inserito in questo periodo" + "\n" + "Inserirne un altro?"); //

                }
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FIFTH_YEAR) || listType.contains(Type.FIFTH_YEAR_OPT)) {
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso del quinto anno, quindi non può essere sovrapposto");
        }

        return true;
    }

    private void checkHoursForDayProf() throws WarningException {
        int i = 0;
        for (Reservation reservation : this.contWorkers.getByDay(cont.getDay())) {
            if (reservation.getPerson().toString().equals(cont.getPerson().toString())) {
                i++;
            }
        }
        if(i >= 6){
            new WarningException("Il prof. svolge 6 ore di lezione" + "\n" + "Aggiungere la settima ora?");
        }
       
    }

    private void check4TimeWeekProfessor() throws WarningException {
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
        
        if(tempCount.size() <= 4){
            new WarningException("Il prof. svolge 4 giorni di lezione" + "\n" + "Aggiungerlo anche nel quinto?");
        }
       
    }

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
        if(tempCount.size() <= 4){
            new WarningException("Gli studenti di questo anno svolgono 4 giorni di lezione" + "\n"
                            + "Aggiungerlo anche nel quinto?");
        }
    }

}
