package com.edgar.neo.mapper;

import com.edgar.neo.MybatisStartedApplicationTests;
import com.edgar.neo.pojo.Fee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class FeeMapperTest extends MybatisStartedApplicationTests {

    @Autowired
    private FeeMapper feeMapper;

    @Test
    public void test(){
        List<Fee> feeByDate = feeMapper.getFeeByDate("2020-05-12");
        feeByDate.forEach(System.out::println);
    }
}
