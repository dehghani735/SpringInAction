package com.mdt.tacobar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbc;

//    When Spring creates the JdbcIngredientRepository bean, it injects it with Jdbc-
//    Template via the @Autowired annotated construction.
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
//      The query() method accepts the SQL for the query as well as an implementation
//of Spring’s RowMapper for the purpose of mapping each row in the result set to
//an object.
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }

    @Override
    public Ingredient findOne(String id) {

        return jdbc.queryForObject("select * id, name, type from Ingredient where id = ?",
                this::mapRowToIngredient, id);
//        alternative, explicit RowMapper
//        new RowMapper<Ingredient>() {
//            public Ingredient mapRow(ResultSet rs, int rowNum)
//                    throws SQLException {
//                return new Ingredient(
//                        rs.getString("id"),
//                        rs.getString("name"),
//                        Ingredient.Type.valueOf(rs.getString("type")));
//            };
//        }
    }

    @Override
    public Ingredient Save(Ingredient ingredient) {
        jdbc.update(
                "Insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
