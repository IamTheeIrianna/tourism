package service;

import model.TouristAttraction;
import org.springframework.stereotype.Service;
import repository.TouristRepository;

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
    public ArrayList getTourAttractionsName(String name){
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
