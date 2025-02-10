package repository;

import model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
//create , read , update ,deleteTourAttraction


@Repository
public class TouristRepository {
    private ArrayList<TouristAttraction>touristAttractionsList = new ArrayList<>();

    public TouristRepository(){
        touristAttractionsList.add(new TouristAttraction("Kings Garden ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));

    }
    //C. add/create new tourist attraction method
   /* public TouristAttraction createTourAttraction(TouristAttraction tourAttraction){
        touristAttractionsList.add(tourAttraction);
        return tourAttraction;*/
    //(C)RUD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction){
        touristAttractionsList.add(tourAttraction);
        return tourAttraction;
    }

    //C(R)UD. read all attractions
    public ArrayList<TouristAttraction> findAll() {
        return touristAttractionsList;
    }
    //CR(U)D
    public TouristAttraction updateTourAttraction(TouristAttraction tourAttraction){
       for(int i = 0; i< touristAttractionsList.size(); i++){
           if(touristAttractionsList.get(i).getName().equalsIgnoreCase(tourAttraction.getName())){
               touristAttractionsList.set(i, tourAttraction);
               return tourAttraction;
           }
       }
       return null;
    }

    //D. remove tourist attraction method
    public TouristAttraction removeTourAttraction(String name){
        TouristAttraction tourAttraction = null;
        for (TouristAttraction touristAttraction : touristAttractionsList){
            if(touristAttraction.getName().equalsIgnoreCase(name)){
                tourAttraction = touristAttraction;
            }
        }
        if (tourAttraction != null){
            touristAttractionsList.remove(tourAttraction);
        } return tourAttraction;
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
