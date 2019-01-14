package com.example.mydemo.mapper;

import com.example.mydemo.domain.CardVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CardMapper {

    @Select("select pk_card,card_code,asset_code,asset_name from fa_card where dr=0")
    List<CardVO> findAllCard();

    @Select("select pk_card,card_code,asset_code,asset_name from " +
            "(select pk_card,card_code,asset_code,asset_name,rownum rown from  fa_card where dr=0 and rownum<=#{currPage}*#{pageSize}+#{pageSize}) " +
            "where rown>#{currPage}*#{pageSize}")
    List<CardVO> findAllCardByP(@Param("currPage")Integer currPage,@Param("pageSize")Integer pageSize);
}
