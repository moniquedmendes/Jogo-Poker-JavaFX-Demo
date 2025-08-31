package com.example.baralhojavafx_demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void abrirSegundaCena(ActionEvent event) throws IOException {
        // Carrega o FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("frmFiveCardDraw-view.fxml"));
        Parent root = loader.load();

        // Cria uma nova cena
        Scene scene = new Scene(root);

        // Cria uma nova janela (Stage)
        Stage stage = new Stage();
        stage.setTitle("Segunda Tela");
        stage.setScene(scene);

        // Mostra a nova janela
        stage.show();

        // Opcional: fecha a janela atual
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}