package com.daliantwop.cloud.daliantwopdatabase.service;

import com.daliantwop.cloud.daliantwopcommon.consts.Renum;
import com.daliantwop.cloud.daliantwopcommon.response.R;
import com.daliantwop.cloud.daliantwopdatabase.consts.SchemaConst;
import com.daliantwop.cloud.daliantwopdatabase.consts.TableEnum;
import com.daliantwop.cloud.daliantwopdatabase.entity.ColumnEntity;
import com.daliantwop.cloud.daliantwopdatabase.mapper.DataTableMapper;
import com.mysql.cj.xdevapi.Column;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Kevin
 * @date 2024/11/8 15:24
 */
@Service
public class DataTableService {

    String year = LocalDate.now().getYear() + "";

    @Resource
    DataTableMapper dataTableMapper;



    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 创建表
     */
    public void createTable(String schemaName, String tableEnName, String tableCnName){

        String columnSql = "Select COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_KEY, COLUMN_DEFAULT, COLUMN_COMMENT"
                + " FROM information_schema.COLUMNS where TABLE_SCHEMA = ? and  TABLE_NAME = ?";

        List<ColumnEntity> columns =  jdbcTemplate.query(columnSql, new Object[]{schemaName, tableEnName}, new BeanPropertyRowMapper<>(ColumnEntity.class));

        // 拼接sql语句
        StringBuilder createTableSql = new StringBuilder();
        createTableSql.append("create table ").append(tableEnName).append("_").append(year).append("(\r\n");
        String fieldSql = getFieldSql(columns);
        createTableSql.append(fieldSql);
        createTableSql.append("\r\n)");
        createTableSql.append(" \r\n comment");
        createTableSql.append(tableCnName);
        try {
            jdbcTemplate.execute(createTableSql.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private String getFieldSql(List<ColumnEntity> columns) {
        StringBuilder stringSql = new StringBuilder();
        String isPrimaryKey = "";
        int i = 0;
        long count = columns.size();
        for(ColumnEntity column : columns){
            ColumnEntity columnTarget = new ColumnEntity();
            BeanUtils.copyProperties(column, columnTarget);
            String columnName = columnTarget.getColumnName();
            String columnType = columnTarget.getColumnType();
            String columnNull = columnTarget.getColumnNull();
            String defaultValue = columnTarget.getDefaultValue();
            String columnComment = columnTarget.getColumnComment();
            String columnKey = columnTarget.getColumnKey();

            stringSql.append(columnName);
            stringSql.append("  ");
            stringSql.append(columnType);
            if(columnKey.equals("PRI")){
                stringSql.append(" auto_increment  primary key");
                isPrimaryKey = " primary key ";
            }
            if ("varchar".equals(columnName)){
                stringSql.append("(500)");
            }
            stringSql.append("  ");
            if ("NO".equals(columnNull)){
                stringSql.append("NOT NULL");
            } else {
                stringSql.append(" NULL ");
            }
            stringSql.append(" comment ");
            stringSql.append(columnComment);
            if (i == count - 1 && isPrimaryKey.isEmpty()){
                stringSql.append("\r\n");
            } else {
                stringSql.append(",\r\n");
            }
            i++;
        }

        return stringSql.toString();
    }

    public R<?> createTable(){
        int existTable = dataTableMapper.existTable("user_2024");
        if (existTable == 0){
            dataTableMapper.createTable("user_2024");
        }
        return new R<>(Renum.SUCCESS.getCode(), "创建成功");
    }
}
