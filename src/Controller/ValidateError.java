package Controller;

import Model.ErrorException;

public class ValidateError {
    private ControllerWorkers contWorkers = new ControllerWorkers();
    private SaveController controllerSave = new SaveController(); 
    private Reservation cont;
    
    public boolean validateErrore(Reservation cont) throws ErrorException {
        this.cont = cont;
        Boolean check = true;
        if(!check()){           // stessa cella non inseribile
            check = false;
            throw new ErrorException("Posizione già occupata!"); //
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
