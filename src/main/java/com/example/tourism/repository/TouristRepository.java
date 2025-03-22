package com.example.tourism.repository;
//b.Opret klassen TouristRepository i repository package med annoteringen @Repository.

import com.example.tourism.model.Tags;
import com.example.tourism.model.TouristAttraction;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//create , read , update ,deleteTourAttraction

@Repository
public class TouristRepository {


    //private JdbcTemplate jdbcTemplate;



    //Tilføj en ArrayList til opbevaring af data (om ikke så længe skal I arbejde med en rigtig database).
    List<TouristAttraction> tourAttractionsList;
    private final JdbcTemplate jdbcTemplate;


    public TouristRepository() {
        DataSource dataSource = new DriverManagerDataSource(
                System.getenv("PROD_DATABASE_URL"),  System.getenv("PROD_USERNAME"),  System.getenv("PROD_PASSWORD"));
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //--------------------------------------------------
    public List<TouristAttraction> getTourAttractionsList() {
        return tourAttractionsList;
    }

    //Opret et par TouristAttraction objekter, som tilføjes til denne ArrayList.
    private void createNewTourAttraction() {


    }

    //-----------------------C. add/create new tourist attraction method
    //(C)RUD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction) {
        
        return tourAttraction;
    }

    //--------------------get tourist attr name-------------------------
    public TouristAttraction getTourName(String name) {
        for (TouristAttraction object : tourAttractionsList) {
            if (object.getName().equalsIgnoreCase(name)) {
                return object;
            }
        }
        return null;
    }

    //------------------------//CR(U)D UPDATE
    public TouristAttraction updateAttraction(TouristAttraction outDatedTour, TouristAttraction newAttraction) {
        return newAttraction;
    }

    //---------//CRU(D)-----DELETE---------------------
    public TouristAttraction deleteAttraction(TouristAttraction tourAttraction) {
        return tourAttraction;
    }

    //--------------------TAGS NAME--------------
    public List<Tags> getTagsName(String name) {
        for (TouristAttraction touristAttraction : tourAttractionsList) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction.getTags();
            }
        }
        return null;
    }
}

