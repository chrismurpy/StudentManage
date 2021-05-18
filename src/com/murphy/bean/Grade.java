package com.murphy.bean;


import java.util.List;

/**
 * 表名 = 类名
 * 列名 = 属性名
 * @author murphy
 */
public class Grade {
    private Integer gradeId;
    private String gradeName;
    private List<Student> studentList;

    public Grade() {
    }

    public Grade(Integer gradeId, String gradeName, List<Student> studentList) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.studentList = studentList;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
