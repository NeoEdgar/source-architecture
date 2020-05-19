package com.edgar.neo.mapper;

import com.edgar.neo.MybatisStartedApplicationTests;
import com.edgar.neo.pojo.Merchant;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MerchantMapperTest extends MybatisStartedApplicationTests {


    @Autowired
    private MerchantMapper merchantMapper;

    @Test
    void getAll() {
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        MerchantMapper mapper = sqlSession.getMapper(MerchantMapper.class);
//        List<Merchant> all1 = mapper.getAll();

        List<Merchant> all = merchantMapper.getAll();
        if (all != null)
            all.forEach(System.out::println);
    }

    @Test
    void save() {
    }
}