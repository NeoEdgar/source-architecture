package com.edgar.neo.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Intercepts(
        {@Signature(type = Executor.class,
                    method = "query",
                    args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})}
)
@Slf4j
public class ParallelShardIntercept implements Interceptor {

    private static final String FROM = "from";
    private static final String WHERE = "where";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("start Interceptor ...");

        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        BoundSql boundSql = ms.getBoundSql(args[1]);

        String sql = boundSql.getSql();

        String date = (String) args[1];
        date=  date.substring(0,date.lastIndexOf("-")).replace("-","");

        String regex = FROM+".+"+WHERE;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()){
            String group = matcher.group();

            String tableName = group.replace(FROM, "").replace(WHERE, "").trim();

            String condition = FROM +" "+tableName+"_"+date+" "+ WHERE ;
            sql = sql.replaceAll(regex,condition);
        }

        SqlSource sqlSource  = new StaticSqlSource(ms.getConfiguration(),sql,boundSql.getParameterMappings());


        // 修改原来的sqlSource
        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        field.set(ms, sqlSource);

        // 执行被拦截方法

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
