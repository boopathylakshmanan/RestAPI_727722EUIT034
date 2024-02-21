package com.pharmacy.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.system.model.Medicine;



public interface MedicineRepo extends JpaRepository<Medicine,Long>{
}
