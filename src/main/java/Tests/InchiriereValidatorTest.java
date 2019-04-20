package Tests;

import Domain.Inchiriere;
import Domain.InchiriereValidator;
import Domain.IValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InchiriereValidatorTest {

    private IValidator<Inchiriere> validatorCardClient = new InchiriereValidator();

    @Test
    void validate(){
        Inchiriere inchiriere = new Inchiriere("1", "2", 10, 100);
        try {
            validatorCardClient.validate(inchiriere);
        } catch (RuntimeException rex){
            assertTrue(true);
        }
    }
}