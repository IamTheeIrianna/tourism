package com.example.tourism.repository;
//b.Opret klassen TouristRepository i repository package med annoteringen @Repository.
import com.example.tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
//create , read , update ,deleteTourAttraction

@Repository
public class TouristRepository {
    //Tilføj en ArrayList til opbevaring af data (om ikke så længe skal I arbejde med en rigtig database).
    List<TouristAttraction>touristAttractionsList;

    public TouristRepository(){
        this.touristAttractionsList = new ArrayList<>();
        createNewTourAttraction();
    }

    //Opret et par TouristAttraction objekter, som tilføjes til denne ArrayList.
    public void createNewTourAttraction(){
        touristAttractionsList.add(new TouristAttraction("Kongens Have", "The kings garden. Find yourself on a stroll of botanical beauty. ", "Copenhagen", new ArrayList()));
        touristAttractionsList.add(new TouristAttraction("Tivoli", "Amusement park in the center of Copenhagen.", "Copenhagen", new ArrayList()));
        touristAttractionsList.add(new TouristAttraction(" ", " ", "Copenhagen", new ArrayList()));
        touristAttractionsList.add(new TouristAttraction(" ", " ", "Copenhagen", new ArrayList()));

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

    public String getTourName(String name){
        for (TouristAttraction touristAttraction : touristAttractionsList){
            if(touristAttraction.getName().equalsIgnoreCase(name)){
                return touristAttraction.getName();
            }
        }
        return null;
    }
    //------------------------ FIND ALL
    //C(R)UD. read all attractions
    public List<TouristAttraction> getAllTouristAttractionsList() {
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
    /*
    // old method
    public TouristAttraction removeTourAttraction(TouristAttraction tourAttraction){
        touristAttractionsList.remove(tourAttraction);
        return tourAttraction;
    }
     */

    public boolean removeTourAttraction(String name){
        return touristAttractionsList.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }

    //------------------------DESCRIPTION
    public List getTourAttractionsDescription(String description){
        return touristAttractionsList;
    }


}
