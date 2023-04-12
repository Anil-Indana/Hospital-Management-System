package com.example.Hospital.Management.System;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    NurseService nurseService = new NurseService();
    @PostMapping("/addNurse")
    public String addNurse(@RequestBody Nurse nurse){
        String ans = nurseService.addNurse(nurse);
        return ans;
    }
    @GetMapping("/getList")
    public List<Nurse> getList(){
        return nurseService.getList();
    }
    @GetMapping("/getListWithQ")
    public List<Nurse> getListWithQ(@RequestParam("qualification")String qualification){
        return  nurseService.getLIstWithQualification(qualification);
    }
}
