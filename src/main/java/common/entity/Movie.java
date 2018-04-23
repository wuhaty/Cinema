package common.entity;

/**
 * Created by gump on 2018/4/23.
 */
public class Movie {
    String id;
    String title;
    double rate;
    String cover;
    String magnetLink;
    public Movie(){}
    public Movie(String id, String title, double rate, String cover) {
        this.id = id;
        this.title = title;
        this.rate = rate;
        this.cover = cover;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMagnetLink() {
        return magnetLink;
    }

    public void setMagnetLink(String magnetLink) {
        this.magnetLink = magnetLink;
    }
}
