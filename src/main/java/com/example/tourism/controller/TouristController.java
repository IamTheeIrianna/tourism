package com.example.tourism.controller;

import com.example.tourism.model.Tags;
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

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    //----------------------GET MAPPINGS---------------------

    //-------------------------" "-INDEX------------------------------
    @GetMapping("")
    public String getAllTouristAttractionsList(Model model) {
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractionsList();
        model.addAttribute("attractions", touristAttractions);
        return "attractionsList";
    }


    //----------------------------SEARCH by name----------------------------
    @GetMapping("/{name}")
    public String getAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getTourName(name);
        model.addAttribute("attraction", attraction);
        return "attraction";
    /*
    @GetMapping("/{name}")
    public ResponseEntity<String> SearchAttraction(@PathVariable String name) {
        return new ResponseEntity<>(touristService.getTourName(name), HttpStatus.OK); //--------old
    }

     */


    }


    //--------------------------------------------mapping for form page----------------
    @GetMapping("/createNewAttraction")
    public String getAddNewAttraction(Model model){
        List<Tags> publishedTags = Arrays.asList(Tags.values());
        model.addAttribute("publishedTags",publishedTags);
        model.addAttribute("attraction",new TouristAttraction());
        return "addAttraction";
    }

//------------------POST MAPPINGS-----------------------

    //------------------------ADD NEW ATTRACTION--------------------------------

    @PostMapping("/addNewAttraction")
    public String addNewAttraction(@ModelAttribute("tourAttraction") TouristAttraction tourAttraction, @RequestParam("tags")List<Tags>tags){
        tourAttraction.setTags(tags);
        TouristAttraction result = touristService.updateAttraction(tourAttraction);
        return "redirect:/attractions";
    }
    //-------------------------ADD------------------
    @PostMapping("/add")
    public String addAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addNewAttraction(attraction);
        return "redirect:/attractions";
    /*
    @PostMapping("/add")
    public ResponseEntity<Boolean>
    addAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") //--------------------old
                  String name,@RequestParam(value = "attDesc", defaultValue = "empty")
                  String desc, @RequestParam String city, @RequestParam List<Tags> tags){
        TouristAttraction t = new TouristAttraction(name,desc,city,tags);
        return new ResponseEntity<>(touristService.addNewAttraction(t), HttpStatus.OK);
    }
    */



}

    //-------------------------DELETE-------------------------------
    @PostMapping("/delete/{name}")
    public String deleteAttraction(@PathVariable String name) {
        TouristAttraction result = touristService.deleteAttraction(name);
        return "redirect:/attractions";
    /*
    @PostMapping("delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@RequestParam(value = "attName", defaultValue = "tivoli") String name){
        return new ResponseEntity(touristService.removeTourAttraction(name), HttpStatus.OK);
    }
     */
    /*
    @PostMapping("/delete/{name}") //-----------old
    public String deleteAttraction(@PathVariable String name) {
        if (name != null) {
            boolean result = touristService.removeTourAttraction(name);
            return "redirect:/attractions";
        } else {
            return "error";
        }
    }


     */

}

    //---------------------------UPDATE-----------------------------
    @PostMapping("{name}/update")
    public String updateAttraction(@ModelAttribute("tourAttraction") TouristAttraction newAttraction, @RequestParam("tags")List<Tags> tags) {
        newAttraction.setTags(tags);
        TouristAttraction result = touristService.updateAttraction(newAttraction);
        return "redirect:/attractions";

    /*
    @PostMapping("{name}/update") //----------------old
    public ResponseEntity<TouristAttraction>
    updateAttraction(@RequestParam(value = "attName", defaultValue = "tivoli")
                     String name,@RequestParam(value = "attDesc", defaultValue = "tom")
                String desc, @RequestParam String city, @RequestParam List<Tags> tags) {
    {
        TouristAttraction t = new TouristAttraction(name, desc,city,tags);
        return new ResponseEntity<>(touristService.updateTourAttraction(t), HttpStatus.OK);
    }
*/
    }
    @GetMapping("{name}/tags")
    public String getTagsName(@PathVariable String name, Model model){
        TouristAttraction attraction = touristService.getTourName(name);
        model.addAttribute("", attraction);
        return "tags";
    }
    }




