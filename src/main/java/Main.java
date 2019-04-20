
import Domain.*;
import Repository.IRepository;
import Repository.JsonFileRepository;
import Service.InchiriereService;
import Service.MasinaService;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import UI.Console;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("controller.fxml"));
        Parent root = fxmlLoader.load();

        MainController mainController = fxmlLoader.getController();

        IValidator<Masina> masinaValidator = new MasinaValidator();
        IValidator<Inchiriere> inchiriereValidator = new InchiriereValidator();


        IRepository<Masina> medicinesRepository = new JsonFileRepository<>
                (masinaValidator, "Masina.json", Masina.class);
        IRepository<Inchiriere> cardsRepository = new JsonFileRepository<>
                (inchiriereValidator, "Inchiriere.json", Inchiriere.class);

        MasinaService masinaService = new MasinaService(medicinesRepository);
        InchiriereService inchiriereService = new InchiriereService(cardsRepository);


        mainController.setServices(masinaService, inchiriereService);

        primaryStage.setTitle("Inchirieri auto");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

