package com.edgar.neo;

public class NeoSqlSession {

    private NeoConfiguration configuration;
    private NeoExecutor executor;

    public NeoSqlSession(NeoConfiguration configuration, NeoExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object parameter) {
        String sql = NeoConfiguration.sqlMappings.getString(statementId);
        if (!"".equals(sql))
            return executor.query(sql, parameter);
        else
            return null;
    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }


}
