package com.example.tourism.model;

import org.springframework.core.metrics.StartupStep;

import java.util.List;

//a.Opret klassen TouristAttraction i model package.
//Klassen skal (i første omgang) indeholde to String attributter name og description.
public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private List<Tags> tags;
    //constructor overloading
    //issue: the model doe snot provide a no arguement constructos, which may be necessary for framework or libraries
    // solution: add an no arg constructor: public TouristAttraction(){}
public TouristAttraction(){}

    public TouristAttraction(String name, String description,String city, List<Tags>tags){
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }
    //-----------------NAME---------------------
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
//-------------------DESCRIPTION------------
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    //----------------CITY---------------
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    //-----------TAGS-----------------
    public List <Tags>getTags(){
        return tags;
    }
    public void setTags(List<Tags>tags){
        this.tags = tags;
}

}
