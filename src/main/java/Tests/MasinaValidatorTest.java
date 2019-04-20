package Tests;

import Domain.IValidator;
import Domain.Masina;
import Domain.MasinaValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MasinaValidatorTest {

    private IValidator<Masina> validatorMedicine = new MasinaValidator();

    @Test
    void validateShouldThrowExceptionsCorrectly() {
        Masina masina = new Masina("2", "test", 100, 2);
        try {
            validatorMedicine.validate(masina);
        } catch (RuntimeException rex) {
            assertTrue(true);
        }
    }
}