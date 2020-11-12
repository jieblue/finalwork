package com.example.mapper;

import com.example.entity.Vcount;
import com.example.entity.VcountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VcountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    long countByExample(VcountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    int deleteByExample(VcountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    int insert(Vcount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    int insertSelective(Vcount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    List<Vcount> selectByExample(VcountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Vcount record, @Param("example") VcountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vcount
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Vcount record, @Param("example") VcountExample example);
}