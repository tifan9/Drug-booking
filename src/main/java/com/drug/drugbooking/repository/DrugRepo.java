package com.drug.drugbooking.repository;

import com.drug.drugbooking.domain.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepo extends JpaRepository<Drug, Integer> {

}
