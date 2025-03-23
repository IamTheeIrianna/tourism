package DTO;

import java.util.List;

public class TouristAttractionDTO {
    private int ID;
    private String name;
    private int cityID;
    private List<Integer> tagsID;
    private String description;

    public TouristAttractionDTO() {}

    public TouristAttractionDTO(int ID, String name, String description, int cityID, List<Integer> tagsID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cityID = cityID;
        this.tagsID = tagsID;
    }

    // Getters-----------
    public int getId() {
        return ID;
    }
    public int getCityID() {
        return cityID;
    }
    public String getName() {
        return name;
    }
    public List<Integer> getTagsID() {
        return tagsID;
    }
    public String getDescription() {
        return description;
    }

    //Setters-----------------------------
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTagsID(List<Integer> tagsID) {
        this.tagsID = tagsID;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}