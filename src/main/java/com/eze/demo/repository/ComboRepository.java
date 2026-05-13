package com.eze.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Integer> {
}
