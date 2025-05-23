package App.controler;

import App.dto.TraderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import App.service.TraderService;
import java.util.List;

/**
 * @author
 */
@RestController
@RequestMapping("/api")
public class TraderController {

    @Autowired
    private  TraderService t_service;

    @GetMapping("/getAllTraders")
    public List<TraderDto> getAllTraders(){
        return t_service.getAllTraders();
    }



}
