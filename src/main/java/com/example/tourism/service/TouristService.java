package com.example.tourism.service;

import com.example.tourism.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.ArrayList;

@Service
public class TouristService {
    private TouristRepository repository;

    public TouristService(){
        repository = new TouristRepository();
    }

    public ArrayList<TouristAttraction>findAll(){
        return repository.getTouristAttractionsList();
    }

    public TouristAttraction getTourAttractionsName(String name){
        return repository.getTourAttractionsName(name);
    }

    public ArrayList getTourAttractionsDescription(String description){
        return repository.getTourAttractionsDescription(description);
    }

    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction){
        return repository.addNewAttraction(tourAttraction);
    }

    public TouristAttraction updateTourAttraction(TouristAttraction tourAttraction){
        return repository.updateTourAttraction(tourAttraction);
    }
    public TouristAttraction removeTourAttraction(String name){
        return repository.removeTourAttraction(name);
    }


}
