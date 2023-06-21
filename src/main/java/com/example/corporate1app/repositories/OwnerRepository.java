package com.example.corporate1app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corporate1app.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
  
}
