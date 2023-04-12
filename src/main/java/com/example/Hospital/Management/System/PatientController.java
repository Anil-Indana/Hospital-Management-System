package com.example.Hospital.Management.System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    HashMap<Integer,Patient> map = new HashMap<>();
    @PostMapping("/addPatientViaBody")
    public String addPatient(@RequestBody Patient patient){
        int patientId = patient.getPatientId();
        map.put(patientId,patient);
        return "Patient added via body";
    }
    @PostMapping("/addListOfPatients")
    public String addPatients(@RequestBody List<Patient> list){
        for(Patient p : list){
            addPatient(p);
        }
        return "Added";
    }
    @PostMapping("/addPatientViaParams")
    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,@RequestParam
            ("age")Integer age,@RequestParam("disease")String disease){
        Patient patient = new Patient(patientId,name,age,disease);
        map.put(patientId,patient);

        return "Patient added via params";
    }
    @GetMapping("/getPatient")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){
        if(map.containsKey(patientId)) return map.get(patientId);
        return null;
    }
    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getInfo(@PathVariable("patientId")Integer patientId){
        return map.get(patientId);
    }
    @GetMapping("/getListOfPatients")
    public List<Patient>  getList(@RequestParam("age")Integer age){
        List<Patient> list = new ArrayList<>();
        for(Patient p : map.values()){
            if(p.getAge() > age){
                list.add(p);
            }
        }
        return list;
    }
    @GetMapping("/getEntireList")
    public List<Patient> getList(){
        List<Patient> patients = new ArrayList<>();
        for(Patient p : map.values()){
            patients.add(p);
        }
        return patients;
    }
    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientId")Integer patientId,@RequestParam("disease")String disease){
        if(map.containsKey(patientId)){
            Patient p = map.get(patientId);
            p.setDisease(disease);
            map.put(patientId,p);
            return "Updated disease";
        }
        return "Patient not Found";
    }
    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId")Integer patientId){
        map.remove(patientId);
        return "Deleted Successfully";
    }
}
