package com.pharmacy.system.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.system.model.Medicine;
import com.pharmacy.system.repository.MedicineRepo;


@Service
public class MedicineService {
    @Autowired 
    MedicineRepo medicineRepo;

    public List<Medicine> postMedicine(List<Medicine> newMed)
    {
        return medicineRepo.saveAll(newMed);
    }
    public List<Medicine> getMedicine()
    {
        return medicineRepo.findAll();
    }
    public Optional<Medicine> getMedicineById(Long Id)
    {
        return medicineRepo.findById(Id);
    }

    public Medicine AlterMedicine(Long id,Medicine med)
    {  
         Medicine medAvail=medicineRepo.findById(id).orElse(null);
        if(medAvail!=null)
        {
            medAvail.setMedicineName(med.getMedicineName());
            medAvail.setMedicinePrice(med.getMedicinePrice());
            medAvail.setMedicineBrand(med.getMedicineBrand());
            medAvail.setExpiryDate(med.getExpiryDate());
            medAvail.setManufacturedIn(med.getManufacturedIn());
            return medicineRepo.saveAndFlush(medAvail);
        }
        else
        return null;
    }
    public String deleteMedicine(Long id)
    {
        medicineRepo.deleteById(id);
        return ("sucessfully dropped!");
    }
}
