package com.example.tourism.service;

import com.example.tourism.model.Tags;
import com.example.tourism.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }
    //------------------FIND ALL LIST
    public List<TouristAttraction> getAllTouristAttractionsList(){
        return touristRepository.getTourAttractionsList();
    }

    //------------------FIND BY NAME--------------
    public TouristAttraction getTourName(String name) {
TouristAttraction result = touristRepository.getTourName(name);

        return result;
    }
    //------------------ADD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction) {
        TouristAttraction exist = touristRepository.getTourName(tourAttraction.getName());
        if (touristRepository.getTourName(tourAttraction.getName()) != null) {
            return null;

        }
        return touristRepository.addNewAttraction(tourAttraction);

    }
    //------------------UPDATE
    public TouristAttraction updateAttraction(TouristAttraction newAttraction){
        TouristAttraction outDated = touristRepository.getTourName(newAttraction.getName());
        return touristRepository.updateAttraction(outDated,newAttraction);
    }
    public TouristAttraction deleteAttraction(String name){
        TouristAttraction exist = touristRepository.getTourName(name);
        return touristRepository.deleteAttraction(exist);
    }
public List<Tags>getTagsName(String name){
        return touristRepository.getTagsName(name);
}
}
