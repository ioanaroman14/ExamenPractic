package UI;

import Domain.Inchiriere;
import Domain.Masina;
import Service.InchiriereService;
import Service.MasinaService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**public class SearchResultsController {
    public Label result;
    public TextField textToSearch;
    public Button btnSearch;
    public Button btnCancel;

    private MasinaService masinaService;
    private InchiriereService inchiriereService;


    public void setService (MasinaService masinaService,
                            InchiriereService inchiriereService){
        this.masinaService = masinaService;
        this.inchiriereService = inchiriereService;

    }

    public void btnSearchClick(ActionEvent actionEvent) {
        String txt = textToSearch.getText();
        String found = txt + " found" + medicineSearch(txt) + "\n" + clientCardSearch(txt) + "\n";

        if(txt.length()>=1)
            result.setText(found);
    }

    private String clientCardSearch (String text){
        String clientCardTextFound = "";
        for (Inchiriere c : inchiriereService.fullTextSearch(text)){
            clientCardTextFound += c + "\n";

        }
        return clientCardTextFound;
    }

    private String medicineSearch (String text){
        String medicineTextFound = "";
        for (Masina m : masinaService.fullTextSearch(text)){
            medicineTextFound += m + "\n";

        }
        return medicineTextFound;
    }
    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
**/