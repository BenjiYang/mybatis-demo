package com.atcn.mybatis.demo.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class ListStringTypeHandler extends BaseTypeHandler<List<String>> {
    /**
     *
     * typeHandlers 1.自定义类型转换器
     * typeHandlers称做类型处理器。就是实现Java类型和数据库类型之间转换的。 除了系统提供的类型转换器之外，开发者也可以自定义类型转换，如下： 例如List<—>VARCHAR之间的类型转换：
     *
     *
     * 设置非空参数
     * 执行SQL语句时对占位符进行设置
     * 比如:sql = "insert into t_sysuser(name,age,favorites)values(?,?,?)"
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType)
            throws SQLException {
        System.out.println("------------");
        StringBuilder sb = new StringBuilder();
        for (String s : parameter) {
            sb.append(s).append(";");
        }
        // 给占位符设值
        ps.setString(i, sb.toString());
    }

    /**
     * 获取非空的返回结果
     * 获取数据库一条记录的某个字段的结果，转换为对应的java类型数据
     */
    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // TODO Auto-generated method stub
        return Arrays.asList(rs.getString(columnName).split(";"));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return Arrays.asList(rs.getString(columnIndex).split(";"));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return Arrays.asList(cs.getString(columnIndex).split(";"));
    }
}
