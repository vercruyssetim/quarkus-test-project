package com.switchfully;

import io.agroal.api.AgroalDataSource;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.SqlResult;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository {

    @Inject
    AgroalDataSource dataSource;

    @Inject
    PgPool client;

    public <T> Uni<List<T>> executeReactiveQuery(String query, RowMapper<T> rowmapper) {
        return client.query(query).execute()
                .flatMap(r -> r.toMulti()
                        .map(rowmapper::mapRow)
                        .collect().asList()
                );
    }


    public <T> List<T> executeQuery(String query, RowMapperr<T> extractor) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            List<T> result = new ArrayList<>();
            while (rs.next()) {
                result.add(extractor.mapRow(rs));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public interface RowMapper<T> {
        T mapRow(Row rs);
    }

    public interface RowMapperr<T> {
        T mapRow(ResultSet rs) throws SQLException;
    }
}
