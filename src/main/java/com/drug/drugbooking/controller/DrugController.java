package com.drug.drugbooking.controller;

import com.drug.drugbooking.domain.Drug;
import com.drug.drugbooking.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping
    public ResponseEntity<List<Drug>> getAllDrugs() {
        List<Drug> drugs = drugService.getAllDrugs();
        return new ResponseEntity<>(drugs, HttpStatus.OK); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drug> getDrugById(@PathVariable int id) {
        Drug drug = drugService.getDrugById(id);
        if (drug != null) {
            return new ResponseEntity<>(drug, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Drug> createDrug(@RequestBody Drug drug) {
        Drug createdDrug = drugService.createDrug(drug);
        return new ResponseEntity<>(createdDrug, HttpStatus.CREATED); // 201 Created
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable int id, @RequestBody Drug drugDetails) {
        Drug updatedDrug = drugService.updateDrug(id, drugDetails);
        if (updatedDrug != null) {
            return new ResponseEntity<>(updatedDrug, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable int id) {
        boolean isDeleted = drugService.deleteDrug(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}
