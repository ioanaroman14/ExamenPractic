package UI;

import Domain.Inchiriere;
import Domain.Masina;
import Service.InchiriereService;
import Service.MasinaService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainController {
    public TableView tblMedicines;
    public TableView tblCardClients;

    public Button btnClientUndo;
    public Button btnClientRedo;
    public Button btnAddMasina;
    public Button btnUpdateMasina;
    public Button btnMasinaUndo;
    public Button btnMasinaRedo;
    public TableColumn colIdMasina;
    public TableColumn colNumberOfDays;
    public TableColumn colKilometriiParcursi;
    public TableView tblinchiriere;
    public TableColumn colIdInchiriere;
    public TableView tblMasini;
    public TableColumn colIdMasini;
    public TableColumn colModelMasini;
    public TableColumn colKilometrajAchizitieMasini;
    public TableColumn colPretInchiriereZi;


    private MasinaService masinaService;
    private InchiriereService inchiriereService;

    private ObservableList<Masina> masinas = FXCollections.observableArrayList();
    private ObservableList<Inchiriere> inchirieres = FXCollections.observableArrayList();


    public void setServices(MasinaService masinaService, InchiriereService inchiriereService) {
        this.masinaService = masinaService;
        this.inchiriereService = inchiriereService;

    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            //colProducerMedicine.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
            masinas.addAll(masinaService.getAll());
            tblMasini.setItems(masinas);
            inchirieres.addAll(inchiriereService.getAll());
            tblinchiriere.setItems(inchirieres);

        });
    }

    public void btnAddMasinaClick(ActionEvent actionEvent) {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/masinaAdd.fxml"));
            upsertMedicine(fxmlLoader, "Masina add");

    }
    public void btnUpdateMasinaClick (ActionEvent actionEvent){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/masinaUpdate.fxml"));
        upsertMedicine(fxmlLoader, "Masina update");
    }
    public void upsertMedicine (FXMLLoader fxmlLoader, String title){
        try{
            Scene scene = new Scene(fxmlLoader.load(),600, 200);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MasinaController controller = fxmlLoader.getController();
            controller.setService (masinaService);
            stage.showAndWait();
            masinas.clear();
            masinas.addAll(masinaService.getAll());
        }catch (IOException e){
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Errors to create new window.", e);
        }
    }
   /** public void btnRemoveMedicineClick(ActionEvent actionEvent) {
        Masina selected = (Masina)
                tblMedicines.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                masinaService.remove(selected.getId());
                masinas.clear();
                masinas.addAll(masinaService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }
**/


    public void btnAddInchirieriClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/inchiriereAdd.fxml"));
        upsertClientCard (fxmlLoader, "Inchirere add");
    }

    public void btnUpdateClientClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/inchiriereUpdate.fxml"));
        upsertClientCard (fxmlLoader, "inchiriere update");
    }

    public void upsertClientCard (FXMLLoader fxmlLoader, String title) {
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            InchiriereController controller = fxmlLoader.getController();
            controller.setServices(inchiriereService);
            stage.showAndWait();
            inchirieres.clear();
            inchirieres.addAll(inchiriereService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Inchiriere add.", e);
        }
    }

    public void btnRemoveCardClientClick(ActionEvent actionEvent) {
        Inchiriere selected = (Inchiriere)
                tblCardClients.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                inchiriereService.remove(selected.getId());
                inchirieres.clear();
                inchirieres.addAll(inchiriereService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }










    public void btnMasinaUndoClick(ActionEvent actionEvent) {
        masinaService.undo();
        masinas.clear();
        masinas.addAll(masinaService.getAll());
    }

    public void btnMasinaRedoClick(ActionEvent actionEvent) {
        masinaService.redo();
        masinas.clear();
        masinas.addAll(masinaService.getAll());
    }

    public void btnClientUndoClick(ActionEvent actionEvent) {
        inchiriereService.undo();
        inchirieres.clear();
        inchirieres.addAll(inchiriereService.getAll());
    }

    public void btnClientRedoClick(ActionEvent actionEvent) {
        inchiriereService.redo();
        inchirieres.clear();
        inchirieres.addAll(inchiriereService.getAll());
    }





    public void increasingByAnProcentage(ActionEvent actionEvent) {
    }
    /**public void editMedicineName(TableColumn.CellEditEvent cellEditEvent){
        Masina editedMasina = (Masina) cellEditEvent.getRowValue();
        try  {
            String newName = (String)cellEditEvent.getNewValue();
            masinaService.insert(editedMasina.getId(), newName, editedMasina.getProducer(), editedMasina.getPrice(), editedMasina.isRecipe());
            editedMasina.setName(newName);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        tblMedicines.refresh();
    }
    public void editMedicineProducer(TableColumn.CellEditEvent cellEditEvent) {
        Masina editedMasina = (Masina) cellEditEvent.getRowValue();
        try {
            String newProducers = (String)cellEditEvent.getNewValue();
            masinaService.insert(editedMasina.getId(), editedMasina.getName(), newProducers, editedMasina.getPrice(), editedMasina.isRecipe());
            editedMasina.setProducer(newProducers);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        tblMedicines.refresh();
    }
**/

    }





