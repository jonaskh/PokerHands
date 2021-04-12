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
import javafx.scene.text.Text;

public class Controller {

    private Deck deck=new Deck();

    @FXML
     private ListView<Card> cardListView;

    //Creates a list that the listViewer can see.
    ObservableList cardObs= FXCollections.observableArrayList();

    @FXML
    private Text text;



    /*
    Runs the pull card method and fills listView with the cards when button is pressed.
     */
    @FXML
    protected void buttonPressed(ActionEvent actionEvent) {
        this.text.setText("");
        cardListView.getItems().clear();
        cardObs.clear();
        deck.pullCards(5);
        if (deck.flush=true) {
            this.text.setText("You have a flush!");
        }
        else {
            this.text.setText("You do not have a flush");
        }

        cardObs.addAll(deck.myCards);
        cardListView.getItems().addAll(cardObs);
    }


}
