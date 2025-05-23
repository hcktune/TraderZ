package App.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */



@Entity
@Table(name = "TRADER", schema = "u_admin")
public class Trader {


    @Id
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

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private int points;

    public Trader(String trader, String email, String password, int points) {
        this.trader = trader;
        this.email = email;
        this.password = password;
        this.points = points;
    }
    public Trader(){

    }

}
