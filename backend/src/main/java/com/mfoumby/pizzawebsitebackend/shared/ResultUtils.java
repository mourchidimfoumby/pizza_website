package com.mfoumby.pizzawebsitebackend.shared;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultUtils {
    public static <T> T getJson(ResultSet result, TypeReference<T> type) throws SQLException, JacksonException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> rows = new ArrayList<>();

        ResultSetMetaData meta = result.getMetaData();

        while (result.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                row.put(meta.getColumnLabel(i), result.getObject(i));
            }
            rows.add(row);
        }

        return mapper.readValue(mapper.writeValueAsString(rows), type);
    }
}
