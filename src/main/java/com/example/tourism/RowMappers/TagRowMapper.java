package com.example.tourism.RowMappers;
import com.example.tourism.model.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagRowMapper implements RowMapper<Tag> {
    @Override
    public Tag mapRow(ResultSet rs, int rowNum)throws SQLException{
        Tag tag = new Tag();
        tag.setTagID(rs.getInt("TagID"));
        tag.setTagName(rs.getString("Tag"));
        return tag;
    }
}
