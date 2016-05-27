package Controller;

import Model.ErrorException;
import Model.WarningException;

public interface ValidateWarningInterface {
    public void validateWARNING(Reservation cont) throws WarningException, ErrorException;
}