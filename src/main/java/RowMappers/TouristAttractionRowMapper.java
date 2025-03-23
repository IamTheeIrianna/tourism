package RowMappers;

import com.example.tourism.model.City;
import com.example.tourism.model.TouristAttraction;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TouristAttractionRowMapper implements RowMapper<TouristAttraction> {

    @Override
    public TouristAttraction mapRow(ResultSet rs, int rowNum) throws SQLException {
        TouristAttraction attraction = new TouristAttraction();
        attraction.setID(rs.getInt("AttractionID"));
        attraction.setName(rs.getString("AttractionName"));
        attraction.setDescription(rs.getString("AttractionDescription"));

        //city map
        City city = new City();
        city.setCityID(rs.getInt("CityID"));
        city.setCityName(rs.getString("CityName"));
        attraction.setCity(city);
        return attraction;
    }
}
