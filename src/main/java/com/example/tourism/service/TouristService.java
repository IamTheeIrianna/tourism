package com.example.tourism.service;

import com.example.tourism.controller.TouristController;
import com.example.tourism.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {

    private TouristRepository repository;

    public TouristService(TouristRepository repository){
        this.repository = repository;
    }

    public List<TouristAttraction> getAllTouristAttractionsList(){
        return TouristRepository.getAllTouristAttractionsList();
    }
    //------------------FIND BY NAME
    public TouristAttraction findTourAttractionName(String name){
        TouristAttraction findTourAttraction = null;
        for(TouristAttraction touristAttraction : TouristRepository.getAllTouristAttractionsList()){
            if(touristAttraction.getName().equalsIgnoreCase(name)){
                findTourAttraction = touristAttraction;
            }
        }
        return findTourAttraction;
    }
    //------------------DESCRIPTION
    public List getTourAttractionsDescription(String description){
        return repository.getTourAttractionsDescription(description);
    }
    //------------------ADD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction){
        return repository.addNewAttraction(tourAttraction);
    }
    //------------------UPDATE
    public TouristAttraction updateTourAttraction(TouristAttraction tourAttraction){
        return repository.updateTourAttraction(tourAttraction);
    }
    //------------------REMOVE
    public TouristAttraction removeTourAttraction(String name){
        return repository.removeTourAttraction(name);
    }


}
