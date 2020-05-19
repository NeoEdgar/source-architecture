package com.edgar.neo.mapper;

import com.edgar.neo.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MerchantMapper {

//    @Select("select * from merchant")
    List<Merchant> getAll();

//    void save(Merchant merchant);
}
