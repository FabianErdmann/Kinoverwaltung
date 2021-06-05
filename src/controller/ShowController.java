package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kinoverwaltung.DatabaseManager;
import kinoverwaltung.Session;
import model.MovieModel;
import model.ShowModel;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowController implements Initializable {

    //FXML identifiers
    @FXML private TableView<ShowModel> showlist = new TableView<>();
    @FXML private TableColumn<ShowModel, String> colName;
    @FXML private TableColumn<ShowModel, Byte> colCinemaHall;
    @FXML private TableColumn<ShowModel, String> colPriceCategory;
    @FXML private TableColumn<ShowModel, String> colDate;
    @FXML private TableColumn<ShowModel, String> colTime;

    ObservableList<ShowModel> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Session s = Session.getInstance();
            String sql = "select * from vorstellung where film_id = \""+s.getCurrentMovie().getId()+"\"";

            ResultSet rs = DatabaseManager.getDatabaseManager().issueQuery(sql);

            while(rs.next()) {
                String movieTitle = getMovieTitleById(rs.getInt("film_id"));
                oblist.add(new ShowModel(movieTitle, rs.getInt("saal_id"),
                        rs.getString("preiskat_id"), rs.getString("uhrzeit"), rs.getString("datum")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Field names in ShowModel.java
        colName.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        colCinemaHall.setCellValueFactory(new PropertyValueFactory<>("cinemaHall"));
        colPriceCategory.setCellValueFactory(new PropertyValueFactory<>("priceCategory"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        ObservableList<ShowModel> observList = FXCollections.observableArrayList();
        showlist.setItems(oblist);
    }

    public String getMovieTitleById(int id) {
        String movieTitle = "undefined";

        try {
            String sql = "select name from film where film_id = "+id;
            ResultSet rs = DatabaseManager.getDatabaseManager().issueQuery(sql);
            while(rs.next()) {
                movieTitle = rs.getString("name");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return movieTitle;
    }

    public void openBooking(ActionEvent event) throws Exception {
        Session s = Session.getInstance();
        ShowModel sm = showlist.getSelectionModel().getSelectedItem();
        if(sm != null) {
            try {
                s.setCurrentShow(sm);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/buchung.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
