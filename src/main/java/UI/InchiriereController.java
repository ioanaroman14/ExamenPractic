package UI;

import Domain.Inchiriere;
import Service.InchiriereService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class InchiriereController {
    public Spinner spnId;
    public TextField txtCardFirstName;
    public TextField txtCardLastName;
    public TextField txtCardCNP;
    public Button btnCancel;
    public Button btnAdd;
    public TextField txtInchiereIdMasina;
    public TextField txtInchiriereNumberOfDays;
    public TextField txtInchiriereKilometriParcursi;

    private InchiriereService inchiriereService;
    public void setServices (InchiriereService inchiriereService){
        this.inchiriereService = inchiriereService;
    }

   public void btnAddClick(ActionEvent actionEvent){
        try{
            Inchiriere c = upsertClick();
            inchiriereService.insert(c.getId(),c.getIdMasina(), c.getNumberOfDays(),c.getKilometriParcursi());
            btnCancelClick (actionEvent);
        }catch (RuntimeException rex){
            Common.showValidationError(rex.getMessage());
        }
   }
   public void btnCancelClick (ActionEvent actionEvent){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
   }


   private Inchiriere upsertClick(){
        try{
            String id = String.valueOf(spnId.getValue());
            String idMasina = txtInchiereIdMasina.getText();
            int numberOfDays = Integer.parseInt(txtInchiriereNumberOfDays.getText());
            Double kilometriParcursi = Double.parseDouble(txtInchiriereKilometriParcursi.getText());



            return new Inchiriere(id, idMasina, numberOfDays, kilometriParcursi);
        } catch (RuntimeException rex){
            Common.showValidationError(rex.getMessage());
        }
        return null;
   }


}
