package com.example.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   VIEW
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table vcount
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Vcount implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcount.uid
     *
     * @mbg.generated
     */
    private String uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcount.time
     *
     * @mbg.generated
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vcount.count
     *
     * @mbg.generated
     */
    private Long count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vcount
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcount.uid
     *
     * @return the value of vcount.uid
     *
     * @mbg.generated
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcount.uid
     *
     * @param uid the value for vcount.uid
     *
     * @mbg.generated
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcount.time
     *
     * @return the value of vcount.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcount.time
     *
     * @param time the value for vcount.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vcount.count
     *
     * @return the value of vcount.count
     *
     * @mbg.generated
     */
    public Long getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vcount.count
     *
     * @param count the value for vcount.count
     *
     * @mbg.generated
     */
    public void setCount(Long count) {
        this.count = count;
    }
}