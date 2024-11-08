package com.daliantwop.cloud.daliantwopdatabase.consts;

import lombok.Getter;

/**
 * @author Kevin
 * @date 2024/11/8 15:06
 */
@Getter
public enum TableEnum {

    ORDER("order", "消费单", "InnoDB", "utf8mb4_general_ci"),
    ORDER_DETAIL("order_detail", "消费单详情", "InnoDB", "utf8mb4_general_ci"),
    ORDER_PAY_TYPE("order_pay_type", "消费单支付方式", "InnoDB", "utf8mb4_general_ci"),
    ORDER_SERVER("order_server", "消费单服务人员", "InnoDB", "utf8mb4_general_ci"),
    RECHARGE("recharge", "会员充值", "InnoDB", "utf8mb4_general_ci"),
    RECHARGE_PAY_TYPE("recharge_pay_type", "充值支付方式", "InnoDB", "utf8mb4_general_ci"),
    RECHARGE_SERVER("recharge_server", "充值服务人员", "InnoDB", "utf8mb4_general_ci"),
    ;

    private final String tableEnName;

    private final String tableCnName;

    private final String tableEngine;

    private final String tableCollation;

    TableEnum(String tableEnName, String tableCnName, String tableEngine, String tableCollation) {
        this.tableEnName = tableEnName;
        this.tableCnName = tableCnName;
        this.tableEngine = tableEngine;
        this.tableCollation = tableCollation;
    }

    /**
     * 根据表名获表英文名
     * @param tableName 表名
     * @return 表引擎
     */
    public static String getTableEnName(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableEnName().equals(tableName)){
                return tableEnum.getTableEnName();
            }
        }
        return null;
    }

    public static String getTableCnName(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableEnName().equals(tableName)){
                return tableEnum.getTableCnName();
            }
        }
        return null;
    }


    public static String getTableEngine(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableEnName().equals(tableName)){
                return tableEnum.getTableEngine();
            }
        }
        return null;
    }

    public static String getTableCollation(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableEnName().equals(tableName)){
                return tableEnum.getTableCollation();
            }
        }
        return null;
    }
}
