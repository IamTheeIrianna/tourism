package com.example.tourism.repository;

import com.example.tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
//create , read , update ,deleteTourAttraction

@Repository
public class TouristRepository {
    private static final List<TouristAttraction>touristAttractionsList = new ArrayList<>();

    public TouristRepository(){
        createNewTourAttraction();
    }

    public void createNewTourAttraction(){
        touristAttractionsList.add(new TouristAttraction("Kongens Have", "The kings garden. Find yourself on a stroll of botanical beauty. "));
        touristAttractionsList.add(new TouristAttraction("Tivoli", "Amusement park in the center of Copenhagen."));
        touristAttractionsList.add(new TouristAttraction(" ", " "));
        touristAttractionsList.add(new TouristAttraction(" ", " "));

    }
    //-----------------------C. add/create new tourist attraction method
    //(C)RUD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction){
        touristAttractionsList.add(tourAttraction);
        return tourAttraction;
    }
    //------------------------FIND NAME--------------
    /*public TouristAttraction getTourAttractionsName(String name){
        for (TouristAttraction touristAttraction : touristAttractionsList){
            if(touristAttraction.getName().equalsIgnoreCase(name)){
                return touristAttraction;
            }
        }
        return null;
    }
    */

    public String findTourAttractionName(TouristAttraction touristAttraction){
        return touristAttraction.getName();
    }
    //------------------------ FIND ALL
    //C(R)UD. read all attractions
    public static List<TouristAttraction> getAllTouristAttractionsList() {
        return touristAttractionsList;
    }
    //------------------------//CR(U)D UPDATE
    public TouristAttraction updateTourAttraction(TouristAttraction tourAttraction){
       for(int i = 0; i< touristAttractionsList.size(); i++){
           if(touristAttractionsList.get(i).getName().equalsIgnoreCase(tourAttraction.getName())){
               touristAttractionsList.set(i, tourAttraction);
               return tourAttraction;
           }
       }
       return null;
    }

    //D. remove tourist attraction method//------------------------REMOVE
    public TouristAttraction removeTourAttraction(TouristAttraction tourAttraction){
        touristAttractionsList.remove(tourAttraction);
        return tourAttraction;
    }

    //------------------------DESCRIPTION
    public List getTourAttractionsDescription(String description){
        return touristAttractionsList;
    }


}
