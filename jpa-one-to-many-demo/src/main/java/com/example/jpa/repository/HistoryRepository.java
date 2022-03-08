package com.example.jpa.repository;

import com.example.jpa.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    Page<History> findByTasteZipId(Long tasteZipId, Pageable pageable);
    Optional<History> findByIdAndTasteZipId(Long id, Long tasteZipId);
}
