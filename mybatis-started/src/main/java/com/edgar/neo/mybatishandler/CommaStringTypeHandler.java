package com.edgar.neo.mybatishandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommaStringTypeHandler extends BaseTypeHandler<List<Integer>> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        System.out.println(value);
        return convertValueToScopes(value);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

    private List<Integer> convertValueToScopes(String value) {
        if (null == value || "".equals(value)) {
            return Collections.emptyList();
        }
        String[] scopes = value.split(",");
        return Arrays.stream(scopes).map(Integer::valueOf).collect(Collectors.toList());
    }
}
