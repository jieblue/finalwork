package com.example.mapper;

import com.example.entity.Vzan;
import com.example.entity.VzanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VzanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    long countByExample(VzanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    int deleteByExample(VzanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    int insert(Vzan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    int insertSelective(Vzan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    List<Vzan> selectByExample(VzanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Vzan record, @Param("example") VzanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vzan
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Vzan record, @Param("example") VzanExample example);
}