package UI;


import Domain.Masina;
import Service.MasinaService;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MasinaController {

    public TextField txtMedicineName;
    public TextField txtMedicineProducer;
    public TextField txtMedicinePrice;
    public Button btnCancel;
    public Spinner spnId;
    public CheckBox chkRecipe;
    public Button btnAdd;
    public Button btnUpdate;
    public TextField txtMasinaModel;
    public TextField txtMasinaKilomAchiz;
    public TextField txtMasinaPrice;
    public TextField txtMasinaPretInchiriereZi;


    private MasinaService masinaService;



    public void setService(MasinaService masinaService) {
        this.masinaService = masinaService;

    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage)btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            Masina masina = upsertClick();
            masinaService.insert(masina.getId(), masina.getModel(),
                    masina.getKilometrajAchiz(), masina.getPretInchiriereZi());
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
        public void btnUpdateClick (ActionEvent actionEvent) {
            try {
                Masina masina = upsertClick();
                masinaService.update(masina.getId(), masina.getModel(),
                        masina.getKilometrajAchiz(), masina.getPretInchiriereZi());
                btnCancelClick(actionEvent);
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
            private Masina upsertClick() {
                try {

                    String id = String.valueOf(spnId.getValue());
                    String model = txtMasinaModel.getText();
                    double kilometrajAchizitie = Double.parseDouble(txtMasinaKilomAchiz.getText());
                    double pretInchiriereZi = Double.parseDouble(txtMasinaPretInchiriereZi.getText());
                    return new Masina(id, model, kilometrajAchizitie, pretInchiriereZi);

                } catch (RuntimeException rex) {
                    Common.showValidationError(rex.getMessage());
                }
                return null;
            }
        }






