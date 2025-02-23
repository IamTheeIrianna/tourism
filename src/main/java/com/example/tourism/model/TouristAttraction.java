package com.example.tourism.model;
//a.Opret klassen TouristAttraction i model package.
//Klassen skal (i første omgang) indeholde to String attributter name og description.
public class TouristAttraction {
    private String name;
    private String description;

    //constructor overloading
    //issue: the model doe snot provide a no arguement constructos, which may be necessary for framework or libraries
    // solution: add an no arg constructor: public TouristAttraction(){}
    public TouristAttraction(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

}
