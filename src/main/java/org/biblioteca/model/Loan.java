/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.biblioteca.model;
import java.util.Date;
/**
 *
 * @author Rebe
 */
public class Loan {
    private int code;
    private String user;
    private Date star_Date;
    private Date end_Date;
    private boolean status;

    public Loan(int code, String user, Date star_Date, Date end_Date, boolean status) {
        this.code = code;
        this.user = user;
        this.star_Date = star_Date;
        this.end_Date = end_Date;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getStar_Date() {
        return star_Date;
    }

    public void setStar_Date(Date star_Date) {
        this.star_Date = star_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
