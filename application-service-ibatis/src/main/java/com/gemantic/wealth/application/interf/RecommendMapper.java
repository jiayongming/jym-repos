package com.gemantic.wealth.application.interf;

import com.gemantic.wealth.application.model.Recommend;
import com.gemantic.wealth.application.model.RecommendExample;
import com.gemantic.wealth.application.model.RecommendWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    int countByExample(RecommendExample example);

    int deleteByExample(RecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RecommendWithBLOBs record);

    int insertSelective(RecommendWithBLOBs record);

    List<RecommendWithBLOBs> selectByExampleWithBLOBs(RecommendExample example);

    List<Recommend> selectByExample(RecommendExample example);

    RecommendWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RecommendWithBLOBs record, @Param("example") RecommendExample example);

    int updateByExampleWithBLOBs(@Param("record") RecommendWithBLOBs record, @Param("example") RecommendExample example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByPrimaryKeySelective(RecommendWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecommendWithBLOBs record);

    int updateByPrimaryKey(Recommend record);
}