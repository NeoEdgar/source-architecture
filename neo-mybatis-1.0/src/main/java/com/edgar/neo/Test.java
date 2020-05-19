package com.edgar.neo;

import com.edgar.neo.mapper.BlogMapper;
import com.edgar.neo.pojo.Blog;

public class Test {
    public static void main(String[] args) {
        NeoSqlSession sqlSession = new NeoSqlSession(new NeoConfiguration(), new NeoExecutor());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectById(1);
        System.out.println(blog);
    }
}
