package com.example.tourism.service;

import com.example.tourism.model.City;
import com.example.tourism.model.Tag;
import com.example.tourism.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.List;


@Service

public class TouristService {
    private final TouristRepository repository;

    @Autowired
    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAllAttractions(){
        return repository.findAll();
    }

    public TouristAttraction getAttractionByName(String name) {
        return repository.findByName(name);
    }

    public void createAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        repository.updateAttraction(name, updatedAttraction);
        return updatedAttraction;
    }

    public void deleteAttraction(String name) {
        repository.deleteAttraction(name);
    }

    public List<City> getCities() {
        return repository.getCities();
    }

    public List<Tag> getTags() {
        return repository.getTags();
    }

    public void addTagToAttraction(int attractionId, int tagId) {
        repository.addTagToAttraction(attractionId, tagId);
    }
}
