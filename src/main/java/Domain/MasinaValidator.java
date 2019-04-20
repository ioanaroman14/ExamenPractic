package Domain;

public class MasinaValidator implements IValidator<Masina> {
    /**
     * validate a masina
     * @param masina to validate
     * throws MasinaValidationException if there are validation errors
     */

    public void validate (Masina masina){

        if(masina.getPretInchiriereZi() <= 0){
            throw new MasinaValidationException("The price must be grater than 0!\n");
        }
    }

}

