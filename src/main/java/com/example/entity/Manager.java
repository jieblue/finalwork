package com.example.entity;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table manager
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Manager implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.account
     *
     * @mbg.generated
     */
    private String account;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.account
     *
     * @return the value of manager.account
     *
     * @mbg.generated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.account
     *
     * @param account the value for manager.account
     *
     * @mbg.generated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.password
     *
     * @return the value of manager.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.password
     *
     * @param password the value for manager.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}