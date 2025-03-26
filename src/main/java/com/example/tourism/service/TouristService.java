package com.example.tourism.service;

import com.example.tourism.model.Tags;
import com.example.tourism.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tourism.repository.TouristRepository;

import java.util.List;


import com.example.tourism.model.TouristAttraction;
import com.example.tourism.repository.TouristRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TouristService {
    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return repository.findAll();
    }

    public TouristAttraction getAttractionByName(String name) {
        return repository.findByName(name);
    }

    public void createAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        repository.updateAttraction(name, updatedAttraction);

    }

    public void deleteAttraction(String name) {
        repository.deleteAttraction(name);
    }

    public List<String> getCities() {
        return repository.getCities();
    }

    public List<String> getTags() {
        return repository.getTags();
    }

    public void addTagToAttraction(int attractionId, int tagId) {
        repository.addTagToAttraction(attractionId, tagId);
    }
}
