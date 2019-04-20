package Tests;

import Domain.Masina;

import static org.junit.jupiter.api.Assertions.*;

class MasinaTest {

   // @org.junit.jupiter.api.Test
   // void setIdShouldSetTheGivenId() {
     //   Masina medicine = new Masina("1", "test", "terapia", 10, true);
     //   String setId = "7";
     //   medicine.setId(setId);
     //   assertNotEquals(setId, medicine.getId(), String.format("Returned=%s, Expected=%s", medicine.getId(), setId));
  //  }

    @org.junit.jupiter.api.Test
    void constructorShouldSetAllFieldsCorrectly() {
        Masina masina = new Masina("1", "test", 100, 200);
        assertEquals("1", masina.getId());
        assertEquals("test", masina.getModel());
        assertEquals(10, masina.getPretInchiriereZi());

    }

    @org.junit.jupiter.api.Test
    void settersShouldSetFieldsCorrectly() {
        Masina masina = new Masina("1", "test", 100, 200);

       // masina.setId("2");
        masina.setModel("test2");
        masina.setKilometrajAchiz(100);
        masina.setPretInchiriereZi(200);

        assertEquals("1", masina.getId());
        assertEquals("test2", masina.getModel());
        assertEquals(100, masina.getKilometrajAchiz());
        assertEquals(200, masina.getPretInchiriereZi());
    }

    @org.junit.jupiter.api.Test
    void equalityShouldWorkCorrectly() {
        Masina masina1 = new Masina("1", "test", 100, 2);
        Masina masina2 = new Masina("1", "test", 100, 2);
        Masina masina3 = new Masina("1", "test", 100, 2);

        assertNotEquals(masina1, masina3);
        assertNotEquals(masina3, masina1);
        assertNotEquals(masina3, masina2);
        assertNotEquals(masina2, masina3);
        assertEquals(masina1, masina2);
        assertEquals(masina2, masina1);

    }


    @org.junit.jupiter.api.Test
    void toStringShouldReturnALongEnoughString() {
        Masina masina1 = new Masina("2", "test", 200, 2);

        assertTrue(masina1.toString().length() > 10);
    }
}