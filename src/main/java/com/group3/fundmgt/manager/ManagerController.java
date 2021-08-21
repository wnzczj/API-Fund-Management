package com.group3.fundmgt.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/managers")
public class ManagerController {
    private final ManagerService managerService;


    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    
    @GetMapping 
    public List<Manager> getManager() {
        return managerService.getManagers();
    }
    
    @GetMapping("{employeeId}")
    public Manager getManager(@PathVariable("employeeId") Long employeeId) {
        return managerService.getManager(employeeId);
    }


    @PostMapping
    public void createNewManager(@RequestBody Manager manager) {
         managerService.createNewManager(manager);
    }

    @PutMapping("{employeeId}")
    public void updateManager(@PathVariable("employeeId") Long employeeId, @RequestBody Manager manager) {
         managerService.updateManager(employeeId, manager);
    }


    @DeleteMapping("{employeeId}")
    public void deleteManager(@PathVariable("employeeId") Long employeeId) {
         managerService.deleteManager(employeeId);

    }

}
