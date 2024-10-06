
package com.qt.collegeportal.model;


public class Studentmodel {
    
    private  int id;
    private  String name;
    private  String email;
    private  String phone;
    private  String degree;
    private  String semester;
    private  String college;
    private  String address;
    private  String state;
    private  String city;
    private  String createdAt;
    private  String modifiedAt;

    public Studentmodel() {
    }

    public Studentmodel(int id, String name, String email, String phone, String degree, String semester, String college, String address, String state, String city, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.degree = degree;
        this.semester = semester;
        this.college = college;
        this.address = address;
        this.state = state;
        this.city = city;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    

    
                   
}
