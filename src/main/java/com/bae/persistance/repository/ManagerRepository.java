package com.bae.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.persistance.domain.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
