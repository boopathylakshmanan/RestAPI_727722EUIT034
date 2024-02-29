package com.pharmacy.system.repository;
import com.pharmacy.system.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long>{
    
}
