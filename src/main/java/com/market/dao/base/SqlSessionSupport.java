package com.market.dao.base;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SqlSessionSupport extends SqlSessionDaoSupport {

    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
        this.sqlSessionFactory=sqlSessionFactory;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public PlatformTransactionManager getTxManager() {
        return txManager;
    }

    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    public Connection getConnection()throws SQLException {
        SqlSessionTemplate st = (SqlSessionTemplate) getSqlSession();

        Connection connection = SqlSessionUtils.getSqlSession(
                st.getSqlSessionFactory(), st.getExecutorType(),
                st.getPersistenceExceptionTranslator()).getConnection();
        //return super.getSqlSession().getConfiguration().getEnvironment().getDataSource().getConnection();
        return connection;
    }

    public TransactionStatus getTransactionStatus(){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        return status;
    }

    /**
     * 获取Batch结果是否执行成功
     * @param resultArray
     * @return
     */
    public boolean getBatchResult(int[] resultArray){
        boolean result=false;
        if(resultArray.length>0){
            result=true;
            for(int sn:resultArray){
                if(sn<1&&sn!=-2){
                    result=false;
                    break;
                }
            }
        }
        return result;
    }
}

