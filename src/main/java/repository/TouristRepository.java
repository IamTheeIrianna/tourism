package repository;

import model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
//create , read , update ,delete


@Repository
public class TouristRepository {
    private ArrayList<TouristAttraction>touristAttractionsList = new ArrayList<>();

    public void TouristRepository(){
        touristAttractionsList.add(new TouristAttraction("Kings Garden ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));

    }
    //C. add/create new tourist attraction method
    public TouristAttraction createTourAttraction(TouristAttraction tourAttraction){
        touristAttractionsList.add(tourAttraction);
        return tourAttraction;
    }
    public TouristAttraction updateTourAttraction(String name,TouristAttraction tourAttraction){
       for(int i = 0; i< touristAttractionsList.size(); i++){
           if(touristAttractionsList.get(i).getName().equalsIgnoreCase(tourAttraction.getName())){
               touristAttractionsList.set(i,tourAttraction);
               return tourAttraction;
           }
       }
       return null;
    }

    //D. remove tourist attraction method
    public TouristAttraction deleteTourAttraction(String name){
        TouristAttraction tourAttractions = null;
        for (TouristAttraction touristAttraction : touristAttractionsList){
            if(touristAttraction.getName().equalsIgnoreCase(name)){
                tourAttractions = touristAttraction;
            }
        }
        if (tourAttractions != null){
            touristAttractionsList.remove(tourAttractions);
        } return tourAttractions;
    }
    public ArrayList getTourAttractionsName(String name){
        return touristAttractionsList;
    }
    public ArrayList getTourAttractionsDescription(String description){
        return touristAttractionsList;
    }
    public ArrayList getTouristAttractionsList(){
        return touristAttractionsList;
    }
}
