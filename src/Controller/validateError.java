package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Type;

public class validateError {
    private ControllerWorkers contWorkers = new ControllerWorkers();
    private SaveController controllerSave = new SaveController(); 
    private Reservation cont;
    
    public boolean validateErrore(Reservation cont) {
        this.cont = cont;
        Boolean check = true;
        if(!check()){           // stessa cella non inseribile
            check = false;
            throw new IllegalArgumentException(); //
        }else if (cont.getCourse().getType().equals(Type.FIRST_YEAR)) { /// corso del 1° anno
            if (!checkCDLFirstYear()) { // corso non inseribile
                check = false;
                throw new IllegalArgumentException(); //
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
    
    private boolean check() {
        boolean check = true;
        for (Reservation res : controllerSave.getObjToSave().getListReservation()) {
            if (((cont.getDay().getString()).equals(res.getDay().getString())
                    && ((cont.getHour().getValue()).equals(res.getHour().getValue())))
                    && ((cont.getRoom().getNameRoom()).equals(res.getRoom().getNameRoom()))) {
                check = false;
            }
        }

        return check;

    }
    
    private Boolean checkCDLFirstYear() {
        boolean check = false;
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FIRST_YEAR)) {
            check = false;
        } else {
            check = true;
        }

        return check;
    }

    private Boolean checkCDLSecondYear() {
        boolean check = false;
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.SECOND_YEAR_ENG) && cont.getCourse().getType().equals(Type.SECOND_YEAR_SCI)) {
            check = true;
        } else if (listType.contains(Type.SECOND_YEAR_SCI) && cont.getCourse().getType().equals(Type.SECOND_YEAR_ENG)) {
            check = true;
        } else {
            check = false;
        }

        return check;
    }

    private Boolean checkCDLThirdYear() {
        boolean check = false;
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.THIRD_YEAR_ENG) && cont.getCourse().getType().equals(Type.THIRD_YEAR_SCI)) {
            check = true;
        } else if (listType.contains(Type.THIRD_YEAR_SCI) && cont.getCourse().getType().equals(Type.THIRD_YEAR_ENG)) {
            check = true;
        } else if (listType.contains(Type.THIRD_YEAR_OPT) && cont.getCourse().getType().equals(Type.THIRD_YEAR_OPT)) {
            check = true;
        } else {
            check = false;
        }

        return check;
    }

    private Boolean checkCDLFourthYear() {
        boolean check = false;
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FOURTH_YEAR)) {
            check = false;
        } else {
            check = true;
        }

        return check;
    }

    private Boolean checkCDLFifthYear() {
        boolean check = false;
        List<Type> listType = new ArrayList<>();

        for (Reservation res : this.contWorkers.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())) {
                listType.add(res.getCourse().getType());

            }
        }
        if (listType.contains(Type.FIFTH_YEAR) || listType.contains(Type.FIFTH_YEAR_OPT)) {
            check = false;
        } else {
            check = true;
        }

        return check;
    }

}
