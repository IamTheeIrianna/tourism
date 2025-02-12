package com.example.tourism.controller;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    public TouristService service;

    public TouristController()
    {
        service = new TouristService();
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<TouristAttraction>> getAll()
    {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<TouristAttraction> getOne(@RequestParam(value = "attName", defaultValue = "tivoli") String name)
    {
        return new ResponseEntity<>(service.getTourAttractionsName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name,@RequestParam(value = "attDesc", defaultValue = "tom") String desc)
    {
        TouristAttraction t = new TouristAttraction(name, desc);
        return new ResponseEntity<>(service.addNewAttraction(t), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<TouristAttraction> deleteAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name)
    {
        return new ResponseEntity(service.removeTourAttraction(name), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name,@RequestParam(value = "attDesc", defaultValue = "tom") String desc)
    {
        TouristAttraction t = new TouristAttraction(name, desc);
        return new ResponseEntity<>(service.updateTourAttraction(t), HttpStatus.OK);
    }


}
