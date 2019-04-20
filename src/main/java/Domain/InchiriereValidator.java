package Domain;

import java.util.Calendar;

public class InchiriereValidator implements IValidator<Inchiriere> {
    /**
     * validates a inchiriere
     *
     * @param inchiriere to validate
     * throws InchiriereValidationException if there are validation errors
     */
    public void validate(Inchiriere inchiriere) {
        String errors = "";
        if (inchiriere.getKilometriParcursi() <= 0) {
            throw new InchiriereValidationException("The kilometrii parcursi must be grater than 0!\n");
        }

        if (!errors.isEmpty()){
            throw new InchiriereValidationException("\n" + errors);
        }

    }
}


