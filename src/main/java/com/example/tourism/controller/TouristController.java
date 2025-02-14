package com.example.tourism.controller;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.repository.TouristRepository;
import com.example.tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    public TouristService service;

    public TouristController()
    {
        service = new TouristService(new TouristRepository());
    }


    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getOne(@RequestParam(value = "attName", defaultValue = "") String name)
    {
        if (name.isEmpty()) {
            List<TouristAttraction> t = service.getAllTouristAttractionsList();
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        System.out.println(name);
        List<TouristAttraction> e = new ArrayList<>();
        e.add(service.getTourAttractionsName(name));
        return new ResponseEntity<>(e, HttpStatus.OK);
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
