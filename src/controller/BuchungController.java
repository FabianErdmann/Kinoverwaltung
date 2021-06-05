package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import kinoverwaltung.DatabaseManager;
import kinoverwaltung.Session;
import model.BookingModel;
import model.MovieModel;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class BuchungController implements Initializable {

    @FXML private Label buchung_filmname;
    @FXML private Label buchung_vorstDatum;
    @FXML private Label buchung_vorstUhrzeit;

    @FXML private CheckBox P11;
    @FXML private CheckBox P12;
    @FXML private CheckBox P13;
    @FXML private CheckBox P14;
    @FXML private CheckBox P15;
    @FXML private CheckBox P21;
    @FXML private CheckBox P22;
    @FXML private CheckBox P23;
    @FXML private CheckBox P24;
    @FXML private CheckBox P25;
    @FXML private CheckBox P31;
    @FXML private CheckBox P32;
    @FXML private CheckBox P33;
    @FXML private CheckBox P34;
    @FXML private CheckBox P35;

    @FXML private CheckBox L41;
    @FXML private CheckBox L42;
    @FXML private CheckBox L43;
    @FXML private CheckBox L44;
    @FXML private CheckBox L45;
    @FXML private CheckBox L51;
    @FXML private CheckBox L52;
    @FXML private CheckBox L53;
    @FXML private CheckBox L54;
    @FXML private CheckBox L55;

    @FXML private Spinner spinnerStudents;
    @FXML private Spinner spinnerChildren;

    ObservableList<BookingModel> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Session s = Session.getInstance();
        buchung_filmname.setText(s.getCurrentShow().getMovieTitle());
        buchung_vorstDatum.setText(s.getCurrentShow().getDate());
        buchung_vorstUhrzeit.setText(s.getCurrentShow().getTime());
    }

    public boolean doCheckAndBook() {
        Session s = Session.getInstance();
        buchung_filmname.setText(s.getCurrentShow().getMovieTitle());
        buchung_vorstDatum.setText(s.getCurrentShow().getDate());
        buchung_vorstUhrzeit.setText(s.getCurrentShow().getTime());
        return true;
    }
}
