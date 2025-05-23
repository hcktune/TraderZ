package App.controler;


import App.dto.TraderDto;
import App.model.Trader;
import App.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * @author
 */
@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:5173")

public class AuthController {

    private final  TraderService t_service;

    public AuthController(TraderService t_service ){
        this.t_service = t_service;
    }



    @GetMapping("/login")
    public ResponseEntity<TraderDto> login(@RequestParam String trader, @RequestParam String password){
        return ResponseEntity.ok(t_service.getTrader(trader, password));
    }

    @PostMapping("/register")
    public ResponseEntity<TraderDto> register(@RequestParam String trader, @RequestParam String email, @RequestParam String password, @RequestParam int points){
        return ResponseEntity.ok(t_service.registerTrader(trader, email, password, points));
    }
}
