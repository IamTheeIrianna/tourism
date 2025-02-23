package com.example.tourism.service;

import com.example.tourism.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository repository;

    public TouristService(TouristRepository repository){
        this.repository = repository;
    }
    //------------------FIND ALL LIST
    public List<TouristAttraction> getAllTouristAttractionsList(){
        return repository.getAllTouristAttractionsList();
    }
    //------------------FIND BY NAME--------------
    public TouristAttraction findTourAttractionName(String name){
        TouristAttraction findTourAttraction = null;
        for(TouristAttraction tourAttraction : repository.getAllTouristAttractionsList()){
            if(tourAttraction.getName().equalsIgnoreCase(name)){
                findTourAttraction = tourAttraction;
            }
        }
        return findTourAttraction;
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
    /*public TouristAttraction removeTourAttraction(String name){
        TouristAttraction tourAttraction = findTourAttractionName(name);
        return repository.removeTourAttraction(tourAttraction);
    }
    */

    public boolean removeTourAttraction(String name){
        return repository.removeTourAttraction(name);
    }


}
