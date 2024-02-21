package com.pharmacy.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.system.model.Medicine;
import com.pharmacy.system.service.MedicineService;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;
    
    @PostMapping("/add/medicine")
     public List<Medicine> addMedicine(@RequestBody List<Medicine>medicine) {
        return medicineService.postMedicine(medicine);
    }

    @GetMapping("/get/medicines")
    public List<Medicine> getMedicines()
    {
        return medicineService.getMedicine();
    }
   @GetMapping("/find/medicine/{medicineId}")
   public Optional<Medicine> getmedById(@PathVariable Long medicineId)
   {
    return medicineService.getMedicineById(medicineId);
   }

    @PutMapping("/update/medicine/{medicineId}")
    public ResponseEntity<Medicine>alterMedicine(@PathVariable Long medicineId,@RequestBody Medicine medicine)
    {
        return new ResponseEntity<>(medicineService.AlterMedicine(medicineId,medicine),HttpStatus.CREATED);
    }

    @DeleteMapping("/drop/medicine/{medicineId}")
    public String deleteUser(@PathVariable Long medicineId) {
        return medicineService.deleteMedicine(medicineId);
    }
    

}