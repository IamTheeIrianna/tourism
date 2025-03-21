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


    private String dbUrl = System.getenv("PROD_DATABASE_URL");
    private String username = System.getenv("PROD_USERNAME");
    private String password = System.getenv("PROD_PASSWORD");
    private DataSource dataSource = dataSource();
    JdbcTemplate jdbcTemplate;

    private DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

    //Tilføj en ArrayList til opbevaring af data (om ikke så længe skal I arbejde med en rigtig database).
    List<TouristAttraction> tourAttractionsList;



    public TouristRepository() {
        System.out.println(dbUrl);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.tourAttractionsList = new ArrayList<>();
        createNewTourAttraction();
        String query = "INSERT INTO regions (RegionName, Province) VALUES (?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Test");
            ps.setString(2, "test");
            return ps;
        }, keyHolder);

    }

    //--------------------------------------------------
    public List<TouristAttraction> getTourAttractionsList() {
        return tourAttractionsList;
    }

    //Opret et par TouristAttraction objekter, som tilføjes til denne ArrayList.
    private void createNewTourAttraction() {
        tourAttractionsList.add(new TouristAttraction("Kongens Have", "The kings garden. Find yourself on a stroll of botanical beauty. ", "Copenhagen", new ArrayList()));
        tourAttractionsList.add(new TouristAttraction("Tivoli", "Amusement park in the center of Copenhagen.", "Copenhagen", new ArrayList()));
    }

    //-----------------------C. add/create new tourist attraction method
    //(C)RUD
    public TouristAttraction addNewAttraction(TouristAttraction tourAttraction) {
        tourAttractionsList.add(tourAttraction);
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
        tourAttractionsList.remove(outDatedTour);
        tourAttractionsList.add(newAttraction);
        return newAttraction;
    }

    //---------//CRU(D)-----DELETE---------------------
    public TouristAttraction deleteAttraction(TouristAttraction tourAttraction) {
        tourAttractionsList.remove(tourAttraction);
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

