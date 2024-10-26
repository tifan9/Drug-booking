package com.drug.drugbooking.service;

import com.drug.drugbooking.domain.Drug;
import com.drug.drugbooking.repository.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DrugService {
    @Autowired
    private DrugRepo drugRepository;

    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    public Drug getDrugById(int id) {
        return drugRepository.findById(id).orElse(null);
    }

    public Drug createDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public Drug updateDrug(int id, Drug drugDetails) {
        Drug drug = drugRepository.findById(id).orElse(null);
        if (drug != null) {
            drug.setDrugName(drugDetails.getDrugName());
            drug.setDose(drugDetails.getDose());
            drug.setPrice(drugDetails.getPrice());
            drug.setFilePath(drugDetails.getFilePath());
            return drugRepository.save(drug);
        }
        return null;
    }

    public boolean deleteDrug(int id) {
        if (drugRepository.existsById(id)) {
            drugRepository.deleteById(id);
            return true; // Drug was found and deleted
        } else {
            return false; // Drug not found
        }
    }
}
