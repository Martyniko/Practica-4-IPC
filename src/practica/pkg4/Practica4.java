/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author impre
 */
public class Practica4 extends Application {
    
    private static FXMLDocumentController controladorPrincipal;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Barra de Herramientas");
        stage.setScene(scene);
        controladorPrincipal = loader.<FXMLDocumentController>getController();
        controladorPrincipal.initStage(stage);
        stage.show();
    }
    
}
