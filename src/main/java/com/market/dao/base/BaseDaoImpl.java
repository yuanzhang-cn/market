package com.market.dao.base;

import com.market.entity.BaseEntity;

public class BaseDaoImpl<T extends BaseEntity> extends SqlSessionSupport implements IBaseDao<T> {
    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "insertBatch";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_BATCH_UPDATE = "updateBatch";
    public static final String SQL_GET_BY_ID = "getByPrimaryKey";
    public static final String SQL_DELETE_BY_ID = "deleteByPrimaryKey";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_LOGIC_DELETE = "logicalDeletion"; //逻辑删除
    public static final String SQL_LIST_PAGE = "listPage";
    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    public static final String SQL_LIST_BY = "getList";
    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计
}
