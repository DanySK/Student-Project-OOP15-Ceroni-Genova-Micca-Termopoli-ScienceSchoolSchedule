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
    
   

}
