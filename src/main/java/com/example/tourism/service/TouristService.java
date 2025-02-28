package com.example.tourism.service;

import com.example.tourism.model.Tags;
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
        return repository.getTourAttractionsList();
    }

    //------------------FIND BY NAME--------------
    public TouristAttraction getTourName(String name) {
TouristAttraction result = repository.getTourName(name);

        return result;
    }
    //------------------ADD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction) {
        TouristAttraction exist = repository.getTourName(tourAttraction.getName());
        if (touristRepository.getTourName(tourAttraction.getName()) != null) {
            return null;

        }
        return repository.addNewAttraction(tourAttraction);

    }
    //------------------UPDATE
    public TouristAttraction updateAttraction(TouristAttraction newAttraction){
        TouristAttraction outDated = repository.getTourName(newAttraction.getName());
        return repository.updateAttraction(outDated,newAttraction);
    }
    public TouristAttraction deleteAttraction(String name){
        TouristAttraction exist = repository.getTourName(name);
        return repository.deleteAttraction(exist);
    }
public List<Tags>getTagsName(String name){
        return repository.getTagsName(name);
}
}
