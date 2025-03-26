package com.example.tourism.controller;
import com.example.tourism.model.Tag;
import com.example.tourism.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.tourism.model.TouristAttraction;
import com.example.tourism.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

//Opret en TouristController klasse i controller package med annoteringen @Controller, samt @RequestMapping(”attractions”).
//Lav nedenstående CRUD endpoints med funktionalitet, der alle returnerer et ResponseEntity.

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService service;

    @Autowired
    public TouristController(TouristService service) {
        this.service = service;
    }
    @GetMapping("/list")
    public String getAllTouristAttractionsList(Model model) {
        List<TouristAttraction> touristAttractions = service.getAllAttractions();
        model.addAttribute("attractions", touristAttractions);
        return "attractionsList";

    }
    @GetMapping("/createNewAttraction")
    public String getAddNewAttraction(Model model) {
        List<Tags> publishedTags = Arrays.asList(Tags.values());
        model.addAttribute("publishedTags", publishedTags);
        model.addAttribute("attraction", new TouristAttraction());
        return "addAttraction";
    }
    @PostMapping("/addNewAttraction")
    public String addNewAttraction(@ModelAttribute("tourAttraction") TouristAttraction touristAttraction, @RequestParam("tags") List<Tag> tags) {
        touristAttraction.setTags(tags);
        TouristAttraction existingAttraction = service.getAttractionByName(touristAttraction.getName());
        if (existingAttraction != null) {
            service.updateAttraction(existingAttraction.getName(), touristAttraction);
        } else {
            service.createAttraction(touristAttraction);
        }
        return "redirect:/attractions";
    }

    @GetMapping
    public String getAllAttractions(Model model) {
        model.addAttribute("attractionsList",service.getAllAttractions() );
        return "attractionsList";
    }

    @GetMapping("/{name}/getTags")
    public String getTags(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.getAttractionByName(name);
        model.addAttribute("attraction", attraction);
        return "tags";
    }

    @GetMapping("/{name}/edit")
    public String edit(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.getAttractionByName(name);
        if (attraction != null) {
            List<Tags> publishedTags = Arrays.asList(Tags.values());
            model.addAttribute("publishedTags", publishedTags);
            model.addAttribute("preAttraction", attraction);
            model.addAttribute("cities", service.getCities());
            model.addAttribute("tags", service.getTags());
            return "edit-attraction";
        } else {
            return "attractions"; // or return a 404 error page
        }
    }

    @PostMapping("{name}/update")
    public String updateAttraction(@PathVariable String name, Model model, @ModelAttribute("tourAttraction") TouristAttraction newAttraction, @RequestParam("tags") List<Tag> tags) {

        newAttraction.setTags(tags);
        service.updateAttraction(name, newAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.getAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }
    @GetMapping("/{name}/delete")
    public String deleteAttraction(@PathVariable String name) {
        service.deleteAttraction(name.toLowerCase());
        System.out.println("hit");
        return "redirect:/attractions";
    }
    @GetMapping("/add")
    public String addAttraction(Model model) {
        model.addAttribute("attraction", new TouristAttraction());
        model.addAttribute("cities", service.getCities());
        model.addAttribute("tags", service.getTags());
        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        service.createAttraction(attraction);
        return "redirect:/attractions";
    }

    @PostMapping("/add")
    public String addAttraction(@ModelAttribute TouristAttraction attraction) {
        service.createAttraction(attraction);
        return "redirect:/attractions";
    }

}