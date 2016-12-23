package com.wyh.common;

import org.apache.commons.lang3.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.ParameterizedType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用于控制所有自定义的枚举类型能自动保存读取
 * Created by zwj on 2016/10/8.
 */
public class BaseEnumStatusHandler<T extends Enum<T>> extends BaseTypeHandler<T> {

    private Class<T> type;


    public BaseEnumStatusHandler() {

        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        type = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {

        preparedStatement.setString(i, t.name());
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        if (resultSet.wasNull()) {
            return null;
        }
        T anEnum = EnumUtils.getEnum(type, string);
        return anEnum;
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        if (resultSet.wasNull()) {
            return null;
        }
        T anEnum = EnumUtils.getEnum(type, string);
        return anEnum;
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        String string = callableStatement.getString(i);
        if (callableStatement.wasNull()) {
            return null;
        }
        T anEnum = EnumUtils.getEnum(type, string);
        return anEnum;
    }
}
