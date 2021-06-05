package model;

public class ShowModel {

    private String movieTitle;
    private int cinemaHall;
    private String priceCategory;
    private String time;
    private String date;

    public ShowModel(String movieTitle, int cinemaHall, String priceCategory, String time, String date) {
        this.movieTitle = movieTitle;
        this.cinemaHall = cinemaHall;
        this.priceCategory = priceCategory;
        this.time = time;
        this.date = date;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(int cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
