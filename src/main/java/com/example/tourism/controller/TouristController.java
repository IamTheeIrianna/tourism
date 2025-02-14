package com.example.tourism.controller;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
    //-------------------------" "-------------------------------
    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractionsList() {
        List<TouristAttraction>touristAttractions = touristService.getAllTouristAttractionsList();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }
    //----------------------------SEARCH by name----------------------------
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTourAttractionName(@RequestParam(value = "attName", defaultValue = "tivoli") String name)
    {
        return new ResponseEntity<>(touristService.findTourAttractionName(name), HttpStatus.OK);
    }
    //------------------------ADD--------------------------------
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name,@RequestParam(value = "attDesc", defaultValue = "tom") String desc) {
        TouristAttraction t = new TouristAttraction(name, desc);
        return new ResponseEntity<>(touristService.addNewAttraction(t), HttpStatus.OK);
    }
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
