/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.biblioteca.model;

/**
 *
 * @author Rebe
 */
public class Career {
    private int code;
    private String name;
    private String description;
    private String deanery;
    private Boolean status;

    public Career(int code, String name, String description, String deanery, Boolean status) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.deanery = deanery;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeanery() {
        return deanery;
    }

    public void setDeanery(String deanery) {
        this.deanery = deanery;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
