package controller;

import model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.TouristRepository;
import service.TouristService;

import java.util.ArrayList;

@Controller
@RequestMapping("/attractions")
public class TouristController {


    private TouristService ts;

    public TouristController(TouristService ts)
    {
        this.ts = ts;
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<TouristAttraction>> getAttractions()
    {
        return new ResponseEntity<>(ts.getAttractions(), HttpStatus.OK);
    }


}
