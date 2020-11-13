package com.example.entity;

import java.io.Serializable;

/**
 * Database Table Remarks:
 *   VIEW
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table vcollection
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Vcollection implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.dishid
     *
     * @mbg.generated
     */
    private Integer dishid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.userid
     *
     * @mbg.generated
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.dishname
     *
     * @mbg.generated
     */
    private String dishname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.dishscore
     *
     * @mbg.generated
     */
    private Float dishscore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.dishcommentnumber
     *
     * @mbg.generated
     */
    private Integer dishcommentnumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.dishprice
     *
     * @mbg.generated
     */
    private Float dishprice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.restaurantname
     *
     * @mbg.generated
     */
    private String restaurantname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.restaurantlocation
     *
     * @mbg.generated
     */
    private String restaurantlocation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.favor
     *
     * @mbg.generated
     */
    private String favor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.category
     *
     * @mbg.generated
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcollection.picurl
     *
     * @mbg.generated
     */
    private String picurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vcollection
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.id
     *
     * @return the value of vcollection.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.id
     *
     * @param id the value for vcollection.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.dishid
     *
     * @return the value of vcollection.dishid
     *
     * @mbg.generated
     */
    public Integer getDishid() {
        return dishid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.dishid
     *
     * @param dishid the value for vcollection.dishid
     *
     * @mbg.generated
     */
    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.userid
     *
     * @return the value of vcollection.userid
     *
     * @mbg.generated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.userid
     *
     * @param userid the value for vcollection.userid
     *
     * @mbg.generated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.dishname
     *
     * @return the value of vcollection.dishname
     *
     * @mbg.generated
     */
    public String getDishname() {
        return dishname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.dishname
     *
     * @param dishname the value for vcollection.dishname
     *
     * @mbg.generated
     */
    public void setDishname(String dishname) {
        this.dishname = dishname == null ? null : dishname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.dishscore
     *
     * @return the value of vcollection.dishscore
     *
     * @mbg.generated
     */
    public Float getDishscore() {
        return dishscore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.dishscore
     *
     * @param dishscore the value for vcollection.dishscore
     *
     * @mbg.generated
     */
    public void setDishscore(Float dishscore) {
        this.dishscore = dishscore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.dishcommentnumber
     *
     * @return the value of vcollection.dishcommentnumber
     *
     * @mbg.generated
     */
    public Integer getDishcommentnumber() {
        return dishcommentnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.dishcommentnumber
     *
     * @param dishcommentnumber the value for vcollection.dishcommentnumber
     *
     * @mbg.generated
     */
    public void setDishcommentnumber(Integer dishcommentnumber) {
        this.dishcommentnumber = dishcommentnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.dishprice
     *
     * @return the value of vcollection.dishprice
     *
     * @mbg.generated
     */
    public Float getDishprice() {
        return dishprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.dishprice
     *
     * @param dishprice the value for vcollection.dishprice
     *
     * @mbg.generated
     */
    public void setDishprice(Float dishprice) {
        this.dishprice = dishprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.restaurantname
     *
     * @return the value of vcollection.restaurantname
     *
     * @mbg.generated
     */
    public String getRestaurantname() {
        return restaurantname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.restaurantname
     *
     * @param restaurantname the value for vcollection.restaurantname
     *
     * @mbg.generated
     */
    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname == null ? null : restaurantname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.restaurantlocation
     *
     * @return the value of vcollection.restaurantlocation
     *
     * @mbg.generated
     */
    public String getRestaurantlocation() {
        return restaurantlocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.restaurantlocation
     *
     * @param restaurantlocation the value for vcollection.restaurantlocation
     *
     * @mbg.generated
     */
    public void setRestaurantlocation(String restaurantlocation) {
        this.restaurantlocation = restaurantlocation == null ? null : restaurantlocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.favor
     *
     * @return the value of vcollection.favor
     *
     * @mbg.generated
     */
    public String getFavor() {
        return favor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.favor
     *
     * @param favor the value for vcollection.favor
     *
     * @mbg.generated
     */
    public void setFavor(String favor) {
        this.favor = favor == null ? null : favor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.category
     *
     * @return the value of vcollection.category
     *
     * @mbg.generated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.category
     *
     * @param category the value for vcollection.category
     *
     * @mbg.generated
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcollection.picurl
     *
     * @return the value of vcollection.picurl
     *
     * @mbg.generated
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcollection.picurl
     *
     * @param picurl the value for vcollection.picurl
     *
     * @mbg.generated
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }
}