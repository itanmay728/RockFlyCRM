package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockfly.models.RackNumber;

public interface RackNumberRepository extends JpaRepository<RackNumber, Long> {

}
