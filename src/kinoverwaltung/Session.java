package kinoverwaltung;

import model.CustomerUserModel;
import model.MovieModel;
import model.ShowModel;

import java.util.ArrayList;

public class Session
{
    private static Session sessionInstance;

    private CustomerUserModel currentUser;
    //private ArrayList<Seat> seats = new ArrayList<>();
    private MovieModel currentMovie;
    private ShowModel currentShow;

    private Session() {}

    public static Session getInstance()
    {
        if (sessionInstance == null)
        {
            sessionInstance = new Session();
        }
        return sessionInstance;
    }



    public CustomerUserModel getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(CustomerUserModel p){
        currentUser = p;
    }

    /*public void setSeatSelection(ArrayList<Seat> seatSelection){
        seats = seatSelection;
    }*/

    public void setCurrentMovie(MovieModel movie) { currentMovie = movie; }

    public MovieModel getCurrentMovie() { return currentMovie; }

    /*public ArrayList<Seat> getSeats(){
        return seats;
    }*/

    public void setCurrentShow(ShowModel show){ currentShow = show; }

    public ShowModel getCurrentShow() { return currentShow; }
}
