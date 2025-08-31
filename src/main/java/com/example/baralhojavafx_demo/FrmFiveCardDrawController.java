package com.example.baralhojavafx_demo;

import Modelo.Carta;
import Modelo.Controle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.IOException;
import java.util.List;

public class FrmFiveCardDrawController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Controle controle;

    @FXML private Label carta1;
    @FXML private Label carta2;
    @FXML private Label carta3;
    @FXML private Label carta4;
    @FXML private Label carta5;
    @FXML private Label lblMao;

    @FXML private Label carta6;
    @FXML private Label carta7;
    @FXML private Label carta8;
    @FXML private Label carta9;
    @FXML private Label carta10;
    @FXML private Label lblMaoAdversario;

    @FXML private Label lblVencedor;


    @Override
    public void start(Stage primaryStage) {

    }
    public void atualizarCartas()
    {

        List<Carta> cartas = controle.pegarCartas(5); // Pega lista de cartas

        if (cartas.size() >= 5) {
            carta1.setText(cartas.get(0).toString());
            carta2.setText(cartas.get(1).toString());
            carta3.setText(cartas.get(2).toString());
            carta4.setText(cartas.get(3).toString());
            carta5.setText(cartas.get(4).toString());
        }
        String mao = controle.validarMaoJogador(cartas);
        lblMao.setText(mao);



    }

    public void atualizarCartasAdversario()
    {

        List<Carta> cartas = controle.pegarCartasAdversario(5); // Pega lista de cartas do adversario

        if (cartas.size() >= 5) {
            carta6.setText(cartas.get(0).toString());
            carta7.setText(cartas.get(1).toString());
            carta8.setText(cartas.get(2).toString());
            carta9.setText(cartas.get(3).toString());
            carta10.setText(cartas.get(4).toString());
        }
        String maoAdversario = controle.validarMaoAdversario(cartas);
        lblMaoAdversario.setText(maoAdversario);

        String resultado = controle.verificarVencedor();
        lblVencedor.setText(resultado);
    }


    @FXML
    public void comecar(ActionEvent event) {
        try {
            if (controle == null) { // inicializa só uma vez
                controle = new Controle();
            }

            atualizarCartas();
            atualizarCartasAdversario();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
