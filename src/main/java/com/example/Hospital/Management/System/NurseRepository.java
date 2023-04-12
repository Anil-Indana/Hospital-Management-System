package com.example.Hospital.Management.System;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    HashMap<Integer,Nurse> map = new HashMap<>();
    public String addNurse(Nurse nurse){
        int key = nurse.getNurseId();
        map.put(key,nurse);

        return "Nurse added Successfully";
    }
    public List<Nurse> getList(){
        return map.values().stream().toList();
    }
}
