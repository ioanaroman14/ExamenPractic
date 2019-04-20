package Domain;


public class MasinaValidationException extends RuntimeException {
    public MasinaValidationException(String message) {
        super("MasinaValidationException " + message);
    }
}

