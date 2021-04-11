package idata1002;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import idata1002.Deck;

public class Controller {

    private Deck deck=new Deck();

    @FXML
     private ListView<Card> cardListView;

    @FXML
    private CheckBox yesBox;

    @FXML
    private CheckBox noBox;


    ObservableList cardObs= FXCollections.observableArrayList();


    @FXML
    protected void buttonPressed(ActionEvent actionEvent) {
        cardListView.getItems().clear();
        cardObs.clear();
        deck.pullCards(10);
//        cardListView.getItems().addAll(cardObs)
        cardObs.addAll(deck.myCards);
        cardListView.getItems().addAll(cardObs);
    }


}
