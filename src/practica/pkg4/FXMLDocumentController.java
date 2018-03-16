/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg4;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author impre
 */
public class FXMLDocumentController implements Initializable {
    
    private Stage primaryStage;
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem mAmazon;
    @FXML
    private MenuItem mBlogger;
    @FXML
    private MenuItem mEbay;
    @FXML
    private MenuItem mFacebook;
    @FXML
    private MenuItem mGoogle;
    @FXML
    private Menu menuOpciones;
    @FXML
    private Menu menuComprarEn;
    @FXML
    private RadioMenuItem opcAmazon;
    @FXML
    private ToggleGroup opcs;
    @FXML
    private RadioMenuItem opcEbay;
    @FXML
    private Button Amazon;
    @FXML
    private Button Blogger;
    @FXML
    private Button Ebay;
    @FXML
    private Button Facebook;
    @FXML
    private Button Google;
    @FXML
    private Label estado;
    @FXML
    private AnchorPane AnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void Amazon(ActionEvent event) {
       if (opcAmazon.isSelected())
         compraOk("Amazon");
       else compraError("Amazon");
    }

    private void compraOk(String tienda){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Compra realizada correctamente");
        alert.setContentText("Has comprado en "+tienda);
        ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(buttonTypeOk);
        Optional<ButtonType> result = alert.showAndWait();
    }
    
    private void compraError(String tienda){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Error en la selección");
        alert.setHeaderText("No puede comprar en "+tienda);
        alert.setContentText("Por favor, cambie la selección en el menú Opciones");
        ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(buttonTypeOk);
        Optional<ButtonType> result = alert.showAndWait();
    }
    
    @FXML
    private void Blogger(ActionEvent event) {
        ObservableList<String> choices = FXCollections.observableArrayList();
        choices.addAll("el blog de Porthos","el blog de Athos","el blog de Aramis");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("", choices);
        dialog.setTitle("Selecciona un blog");
        dialog.setHeaderText("Que blog quieres visitar?");
        dialog.setContentText("Elige:");
        Optional<String> result = dialog.showAndWait();
        // Obteniendo el resultado con una lambda
        result.ifPresent(number-> estado.setText("Visitando " + result.get()));
    }

    @FXML
    private void Ebay(ActionEvent event) {
        if (opcEbay.isSelected())
         compraOk("Ebay");
       else compraError("Ebay");
    }

    @FXML
    private void Facebook(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog(""); // Por defecto
        dialog.setTitle("Introduce tu nombre");
        dialog.setHeaderText("Con que usuario quieres escribir en Facebook?");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(number-> estado.setText("Mensaje enviado como " + result.get()));
    }

    @FXML
    private void Google(ActionEvent event) {
    }

    public void initStage(Stage stage) {
     primaryStage = stage;   
    }
    
    
}
