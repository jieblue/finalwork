package com.example.mapper;

import com.example.entity.Restaurant;
import com.example.entity.RestaurantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RestaurantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    long countByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int deleteByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int insert(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int insertSelective(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    List<Restaurant> selectByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    Restaurant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Restaurant record);
}