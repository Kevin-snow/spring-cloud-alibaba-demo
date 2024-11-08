package com.daliantwop.cloud.daliantwopdatabase.mapper;

import com.daliantwop.cloud.daliantwopdatabase.entity.ColumnEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Kevin
 * @date 2024/11/8 15:37
 */
public interface DataTableMapper {

    List<ColumnEntity> selectTableColumns(@Param("schemaName") String schemaName, @Param("tableName") String tableName);



}
