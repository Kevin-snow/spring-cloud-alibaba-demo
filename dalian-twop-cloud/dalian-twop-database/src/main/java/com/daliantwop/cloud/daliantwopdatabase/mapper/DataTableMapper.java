package com.daliantwop.cloud.daliantwopdatabase.mapper;

import com.daliantwop.cloud.daliantwopdatabase.entity.ColumnEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Kevin
 * @date 2024/11/8 15:37
 */
public interface DataTableMapper {

    /**
     * 判断表是否存在
     * @param tableName 表名
     * @return 存在返回1， 不存在返回0
     */
    int existTable(@Param("tableName") String tableName);

    /**
     * 创建表
     * @param tableName 表名
     * @return 创建成功返回1， 创建失败返回0
     */
    int createTable(@Param("tableName") String tableName);



    List<ColumnEntity> selectTableColumns(@Param("schemaName") String schemaName, @Param("tableName") String tableName);



}
