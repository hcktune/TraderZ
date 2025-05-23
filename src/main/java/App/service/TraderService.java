package App.service;

import App.model.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import App.repository.TraderRepository;
import App.dto.TraderDto;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 */
@Service
public class TraderService {


    private final TraderRepository t_repo;
    private final PasswordEncoder passwordEncoder;

    public TraderService(TraderRepository t_repo, PasswordEncoder passwordEncoder) {
        this.t_repo = t_repo;
        this.passwordEncoder = passwordEncoder;
    }


    public List<TraderDto> getAllTraders(){
        return t_repo.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    public TraderDto mapToDto(Trader t){
        return new TraderDto(t.getTrader(),  t.getEmail(), t.getPassword(), t.getPoints());

    }

    public static void debug(TraderDto t){
        System.out.println(t);
    }

    public static void debug(Trader t){
        System.out.println(t);
    }

    public static void debug(String s){
        System.out.println(s);
    }

    public TraderDto getTrader(String trader, String password){

        Trader t = t_repo.findBytrader(trader)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Trader not found: " + trader));

        if (!passwordEncoder.matches(password, t.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Password");
        }
        return mapToDto(t);
    }

    public TraderDto registerTrader(String trader, String email, String password, int points){
        Trader t = new Trader();
        t.setTrader(trader);
        t.setEmail(email);
        t.setPassword(passwordEncoder.encode(password));
        t.setPoints(points);
        t_repo.save(t);
        return mapToDto(t);
    }

}
