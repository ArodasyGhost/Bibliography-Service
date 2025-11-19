package br.ucsal.bibliography_service.repository;

import br.ucsal.bibliography_service.model.Bibliografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliografiaRepository extends JpaRepository<Bibliografia, Long> {
    // O JpaRepository já fornece save, saveAll, findById, findAll, etc.
}