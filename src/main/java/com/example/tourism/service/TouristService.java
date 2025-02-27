package com.example.tourism.service;

import com.example.tourism.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;
    private TouristRepository repository;

    public TouristService(TouristRepository repository, TouristRepository touristRepository){
        this.repository = repository;
        this.touristRepository = touristRepository;
    }
    //------------------FIND ALL LIST
    public List<TouristAttraction> getAllTouristAttractionsList(){
        return repository.getAllTouristAttractionsList();
    }

    //------------------FIND BY NAME--------------
    public String getTourName(String name) {

        return repository.getTourName(name);

    }
    //------------------ADD
    public boolean addNewAttraction(TouristAttraction tourAttraction) {
        if (touristRepository.getTourName(tourAttraction.getName()) != null) {
            return false;
        }

        repository.addNewAttraction(tourAttraction);
        return true;
    }
    //------------------UPDATE
    public TouristAttraction updateTourAttraction(TouristAttraction tourAttraction){
        return repository.updateTourAttraction(tourAttraction);
    }
    //------------------REMOVE
    /*public TouristAttraction removeTourAttraction(String name){
        TouristAttraction tourAttraction = getTourName(name);
        return repository.removeTourAttraction(tourAttraction);
    }
    */

    public boolean removeTourAttraction(String name){
        return repository.removeTourAttraction(name);
    }


}
