package com.presentation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Julien Deruere
 */
@Component
public class LambdaTemplate {

    @Inject
    private DataSource dataSource;

    public List<Object> doQuery() {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        return jt.query("SELECT name, age FROM person WHERE dep = ?",
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, "Sales");
                    }
                },
                new RowMapper<Object>() {
                    @Override
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Object(/*rs.getString(1), rs.getInt(2)*/);
                    }
                }
        );

//        ps -> ps.setString(1, "Sales"), (rs, rowNum) -> new Object(/*rs.getString(1), rs.getInt(2)*/);
    }
}