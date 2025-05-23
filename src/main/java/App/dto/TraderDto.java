package App.dto;

import App.model.Trader;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author
 */


public class TraderDto {

    private String trader;

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private String email;
    private String password;
    private int points;


    public TraderDto(String trader, String email, String password, int points) {
        this.trader = trader;
        this.email = email;
        this.password = password;
        this.points = points;
    }
    public TraderDto(){

    }

    @Override
    public String toString() {
        return "TraderDto{" +
                "trader='" + trader + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", points=" + points +
                '}';
    }
}
