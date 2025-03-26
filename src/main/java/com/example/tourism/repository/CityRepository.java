package com.example.tourism.repository;
import com.example.tourism.RowMappers.CityRowMapper;
import com.example.tourism.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {
    private final JdbcTemplate jdbcTemplate;
    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<City> findAll() {
        String sql = "SELECT * FROM cities";
        return jdbcTemplate.query(sql, new CityRowMapper());
    }
}
