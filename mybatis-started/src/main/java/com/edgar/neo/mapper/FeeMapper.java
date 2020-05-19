package com.edgar.neo.mapper;

import com.edgar.neo.pojo.Fee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FeeMapper {

    @Select("select id,fee_amt,fee_date from fee where fee_date = #{feeDate}")
    List<Fee> getFeeByDate(String feeDate);

}
