package com.example.Hospital.Management.System;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse){
        if(nurse.getNurseId() < 0){
            return "Enter valid nurseId";
        }
        if(nurse.getName().equals(null)) return "Enter valid name";

        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }
    public List<Nurse> getList(){
        return nurseRepository.getList();
    }
    public List<Nurse> getLIstWithQualification(String qualification){
        List<Nurse> entireList = nurseRepository.getList();
        List<Nurse> listWithQ = new ArrayList<>();
        for(Nurse n : entireList){
            if(n.getQualification().equals("B.sc")){
                listWithQ.add(n);
            }
        }
        return listWithQ;
    }
}
