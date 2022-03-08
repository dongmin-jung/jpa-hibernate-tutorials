package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.TasteZip;
import com.example.jpa.repository.TasteZipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TasteZipController {

    @Autowired
    private TasteZipRepository tasteZipRepository;

    @GetMapping("/tastezips")
    public Page<TasteZip> getAllTasteZips(Pageable pageable) {
        return tasteZipRepository.findAll(pageable);
    }

    @PostMapping("/tastezips")
    public TasteZip createTasteZip(@Valid @RequestBody TasteZip tasteZip) {
        return tasteZipRepository.save(tasteZip);
    }

    @PutMapping("/tastezips/{tasteZipId}")
    public TasteZip updateTasteZip(@PathVariable Long tasteZipId, @Valid @RequestBody TasteZip tasteZipRequest) {
        return tasteZipRepository.findById(tasteZipId).map(tasteZip -> {
            tasteZip.setName(tasteZipRequest.getName());
            tasteZip.setThumbnailUrl(tasteZipRequest.getThumbnailUrl());
            tasteZip.setDescription(tasteZipRequest.getDescription());
            tasteZip.setMainMenu(tasteZipRequest.getMainMenu());
            tasteZip.setLocation(tasteZipRequest.getLocation());
            tasteZip.setAvgPrice(tasteZipRequest.getAvgPrice());
            tasteZip.setWorkTime(tasteZipRequest.getWorkTime());
            tasteZip.setExternalUrl(tasteZipRequest.getExternalUrl());
            tasteZip.setMapUrl(tasteZipRequest.getMapUrl());
            // tasteZip.setAvgRating(tasteZipRequest.getAvgRating());
            // tasteZip.setNumOrders(tasteZipRequest.getNumOrders());
            // tasteZip.setRank(tasteZipRequest.getRank());
            return tasteZipRepository.save(tasteZip);
        }).orElseThrow(() -> new ResourceNotFoundException("TasteZipId " + tasteZipId + " not found"));
    }


    @DeleteMapping("/tastezips/{tasteZipId}")
    public ResponseEntity<?> deletePost(@PathVariable Long tasteZipId) {
        return tasteZipRepository.findById(tasteZipId).map(tasteZip -> {
            tasteZipRepository.delete(tasteZip);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("TasteZipId " + tasteZipId + " not found"));
    }

}
