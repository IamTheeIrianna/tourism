package com.example.tourism.controller;

import org.springframework.ui.Model;
import com.example.tourism.model.TouristAttraction;
import com.example.tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Opret en TouristController klasse i controller package med annoteringen @Controller, samt @RequestMapping(”attractions”).
//Lav nedenstående CRUD endpoints med funktionalitet, der alle returnerer et ResponseEntity.
@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }


    //-------------------------" "-------------------------------
    @GetMapping("")
    public String getAllTouristAttractionsList(Model model) {
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractionsList();
        model.addAttribute("attractions", touristAttractions);
        return "attractionsList";
    }

    //----------------------------SEARCH by name----------------------------
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTourAttractionName(@PathVariable String name)
    {
        return new ResponseEntity<>(touristService.findTourAttractionName(name), HttpStatus.OK);
    }
    //------------------------ADD--------------------------------
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name,@RequestParam(value = "attDesc", defaultValue = "tom") String desc) {
        TouristAttraction t = new TouristAttraction(name, desc);
        return new ResponseEntity<>(touristService.addNewAttraction(t), HttpStatus.OK);
    }
    /*
     @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction){
        TouristAttraction newTouristAttraction = touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }
    */
    //-------------------------DELETE-------------------------------
    @PostMapping("/delete")
    public ResponseEntity<TouristAttraction> deleteAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name){
        return new ResponseEntity(touristService.removeTourAttraction(name), HttpStatus.OK);
    }
    //---------------------------UPDATE-----------------------------
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name,@RequestParam(value = "attDesc", defaultValue = "tom") String desc)
    {
        TouristAttraction t = new TouristAttraction(name, desc);
        return new ResponseEntity<>(touristService.updateTourAttraction(t), HttpStatus.OK);
    }


}
