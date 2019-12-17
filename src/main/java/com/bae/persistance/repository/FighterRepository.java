package com.bae.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bae.persistance.domain.Fighters;

public interface FighterRepository extends JpaRepository<Fighters, Long> {

}
