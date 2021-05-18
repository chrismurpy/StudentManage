package com.murphy.bean;

import java.util.Date;

/**
 * @author murphy
 */
public class Student {
    private Integer stuId;
    private String stuName;
    private String stuNo;
    private Integer sex;
    private String phone;
    private String email;
    private String registered;
    private String address;
    private String profession;
    private String idNumber;
    private String politics;
    private Date regDate;
    private Integer state;
    private String introduction;
    private Integer gid;
    private Grade grade;

    public Student() {
    }

    public Student(Integer stuId, String stuName, String stuNo, Integer sex, String phone, String email, String registered, String address, String profession, String idNumber, String politics, Date regDate, Integer state, String introduction, Integer gid, Grade grade) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.registered = registered;
        this.address = address;
        this.profession = profession;
        this.idNumber = idNumber;
        this.politics = politics;
        this.regDate = regDate;
        this.state = state;
        this.introduction = introduction;
        this.gid = gid;
        this.grade = grade;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
