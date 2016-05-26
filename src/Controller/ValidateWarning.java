package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Days;
import Model.ErrorException;
import Model.Type;
import Model.WarningException;

public class ValidateWarning {

    private ControllerWorkers contWorkers = new ControllerWorkers();
    private Reservation cont;

    public boolean validateWARNING(Reservation cont) throws WarningException, ErrorException {
        this.cont = cont;
        Boolean check = true;
        if (!checkHoursForDayProf()) { // 6 ore al giorno
            check = false;

        } else if (!check4TimeWeekProfessor()) { // più di 4 giorni a settimana,
                                                 // prof
            check = false;

        } else if (!check4TimeWeekStudent()) { // più di 4 giorni a settimana
            check = false;

        } else if (cont.getCourse().getType().equals(Type.FIRST_YEAR)) { // corso del 1°anno, corso non inseribile
            if (!checkCDLFirstYear()) {
                check = false;
            }

        } else if (Type.getSecondYears().contains(cont.getCourse().getType())) { // corso del 2°anno, corso non inseribile
            if (!checkCDLSecondYear()) {
                check = false;
            }

        } else if (Type.getThirdYears().contains(cont.getCourse().getType())) { // corso del 3°anno, corso non inseribile
            if (!checkCDLThirdYear()) {
                check = false;
            }

        } else if (cont.getCourse().getType().equals(Type.FOURTH_YEAR)) { // corso del 4°anno, corso non inseribile
            if (!checkCDLFourthYear()) {
                check = false;
            }
            
        } else if (Type.getFifthYears().contains(cont.getCourse().getType())) { // corso del 5°anno, corso non inseribile
            if (!checkCDLFifthYear()) {
                check = false;
            }
        }

        return check;
    }

    private Boolean checkCDLFirstYear() throws WarningException, ErrorException {
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
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
                    "Nella stessa fascia oraria è già presente un corso dello stesso anno che non può essere sovrapposto");
        }

        return true;
    }

    private Boolean checkCDLSecondYear() throws WarningException, ErrorException {
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
        } else {
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso dello stesso anno che non può essere sovrapposto");
        }
    }

    private Boolean checkCDLThirdYear() throws WarningException, ErrorException {

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
        } else {
            throw new ErrorException(
                    "Nella stessa fascia oraria è già presente un corso dello stesso anno che non può essere sovrapposto");
        }
    }

    private Boolean checkCDLFourthYear() throws WarningException, ErrorException {
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
                    "Nella stessa fascia oraria è già presente un corso dello stesso anno che non può essere sovrapposto");
        }

        return true;
    }

    private Boolean checkCDLFifthYear() throws WarningException, ErrorException {
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
                    "Nella stessa fascia oraria è già presente un corso dello stesso anno che non può essere sovrapposto");
        }

        return true;
    }

    private Boolean checkHoursForDayProf() throws WarningException {
        int i = 0;

        for (Reservation reservation : this.contWorkers.getByDay(cont.getDay())) {
            if (reservation.getPerson().toString().equals(cont.getPerson().toString())) {
                i++;
            }
        }
        return i <= 6 ? true
                : new WarningException(
                        "Il prof. svolge 6 ore di lezione" + "\n" + "Aggiungere la settima ora?") != null;
    }

    private Boolean check4TimeWeekProfessor() throws WarningException {
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
        return tempCount.size() <= 4 ? true
                : new WarningException(
                        "Il prof. svolge 4 giorni di lezione" + "\n" + "Aggiungerlo anche nel quinto?") != null;
    }

    private Boolean check4TimeWeekStudent() throws WarningException {
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

        return tempCount.size() <= 4 ? true
                : new WarningException("Gli studenti di questo anno svolgono 4 giorni di lezione" + "\n"
                        + "Aggiungerlo anche nel quinto?") != null;
    }

}
