package com.example.tourism.repository;
//b.Opret klassen TouristRepository i repository package med annoteringen @Repository.
import com.example.tourism.RowMappers.TouristAttractionRowMapper;
import com.example.tourism.model.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


import com.example.tourism.model.TouristAttraction;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class TouristRepository {
    private final JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TouristAttraction> findAll() {
        String sql = "SELECT attractionName, AttractionDescription, CityID,Adress FROM touristattractions";
        return jdbcTemplate.query(sql, new TouristAttractionRowMapper());
    }

    public TouristAttraction findByName(String name) {
        String sql = "SELECT attractionName, AttractionDescription, CityID, Adress FROM touristattractions WHERE attractionName = ?";
        return jdbcTemplate.queryForObject(sql, new TouristAttractionRowMapper(), name);
    }

    public void addAttraction(TouristAttraction attraction) {
        String sql = "INSERT INTO touristAttractions (attractionName, AttractionDescription, CityID, Adress) VALUES (?, ?, ?,?)";
        jdbcTemplate.update(sql, attraction.getName(), attraction.getDescription(), attraction.getCity());


    }

    public void updateAttraction(String name, TouristAttraction updatedAttraction) {
        String sql = "UPDATE tourismdb.touristattractions SET Attractiondescription = ?, cityID = ?, Adress=? WHERE attractionName = ?";
        jdbcTemplate.update(sql, updatedAttraction.getDescription(), updatedAttraction.getCity(), name);

    }

    public void deleteAttraction(String name) {
        String sql = "DELETE FROM touristAttractions WHERE attractionName = ?";
        jdbcTemplate.update(sql, name);
    }
    public void addTagToAttraction(int attractionId, int tagId) {
        String sql = "INSERT INTO attractionstags (AttractionID, tagID) VALUES (?, ?)";
        jdbcTemplate.update(sql, attractionId, tagId);
    }

    public List<Tag> getTags() {
        String sql = "SELECT tagName FROM tags";
        return jdbcTemplate.queryForList(sql, Tag.class);

    }
    public List<City> getCities() {
        String sql = "SELECT * FROM cities";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class));
    }
}
