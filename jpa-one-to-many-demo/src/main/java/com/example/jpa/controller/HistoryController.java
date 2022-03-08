package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.History;
import com.example.jpa.repository.HistoryRepository;
import com.example.jpa.repository.TasteZipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private TasteZipRepository tasteZipRepository;

    @GetMapping("/tastezips/{tasteZipId}/history")
    public Page<History> getAllHistorysByTasteZipId(@PathVariable (value = "tasteZipId") Long tasteZipId,
                                                Pageable pageable) {
        return historyRepository.findByTasteZipId(tasteZipId, pageable);
    }

    @PostMapping("/tastezips/{tasteZipId}/history")
    public History createHistory(@PathVariable (value = "tasteZipId") Long tasteZipId,
                                 @Valid @RequestBody History history) {
        return tasteZipRepository.findById(tasteZipId).map(tasteZip -> {
            history.setTasteZip(tasteZip);
            return historyRepository.save(history);
        }).orElseThrow(() -> new ResourceNotFoundException("TasteZipId " + tasteZipId + " not found"));
    }

    @PutMapping("/tastezips/{tasteZipId}/history/{historyId}")
    public History updateHistory(@PathVariable (value = "tasteZipId") Long tasteZipId,
                                 @PathVariable (value = "historyId") Long historyId,
                                 @Valid @RequestBody History historyRequest) {
        if(!tasteZipRepository.existsById(tasteZipId)) {
            throw new ResourceNotFoundException("TasteZipId " + tasteZipId + " not found");
        }

        return historyRepository.findById(historyId).map(history -> {
            history.setImageUrl(historyRequest.getImageUrl());
            history.setOrderedDate(historyRequest.getOrderedDate());
            history.setNumPeople(historyRequest.getNumPeople());
            history.setPrice(historyRequest.getPrice());
            history.setOrderedMenu(historyRequest.getOrderedMenu());
            history.setComment(historyRequest.getComment());
            history.setRating(historyRequest.getRating());
            return historyRepository.save(history);
        }).orElseThrow(() -> new ResourceNotFoundException("HistoryId " + historyId + "not found"));
    }

    @DeleteMapping("/tastezips/{tasteZipId}/history/{historyId}")
    public ResponseEntity<?> deleteHistory(@PathVariable (value = "tasteZipId") Long tasteZipId,
                              @PathVariable (value = "historyId") Long historyId) {
        return historyRepository.findByIdAndTasteZipId(historyId, tasteZipId).map(history -> {
            historyRepository.delete(history);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("History not found with id " + historyId + " and tasteZipId " + tasteZipId));
    }
}
