package service;

import model.TouristAttraction;
import org.springframework.stereotype.Service;
import repository.TouristRepository;

import java.util.ArrayList;

@Service
public class TouristService {

    private TouristRepository touristRepository;

    public TouristService()
    {
        touristRepository = new TouristRepository();
    }

    public ArrayList<TouristAttraction> getAttractions()
    {
        return touristRepository.getTouristAttractionsList();
    }

}
