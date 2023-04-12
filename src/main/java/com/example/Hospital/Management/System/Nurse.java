package com.example.Hospital.Management.System;

public class Nurse {
    private String name;
    private int nurseId;
    private String qualification;
    private int age;

    public Nurse(String name, int nurseId, String qualification, int age) {
        this.name = name;
        this.nurseId = nurseId;
        this.qualification = qualification;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
