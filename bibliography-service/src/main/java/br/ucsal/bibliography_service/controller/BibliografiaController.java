package br.ucsal.bibliography_service.controller;

import br.ucsal.bibliography_service.dto.BibliografiaDTO;
import br.ucsal.bibliography_service.model.Bibliografia;
import br.ucsal.bibliography_service.service.BibliografiaService;
import jakarta.validation.Valid; // Nova importação
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliografias")
@RequiredArgsConstructor
public class BibliografiaController {

    private final BibliografiaService service;

    // Endpoint usado pelo Orquestrador, agora com @Valid para aplicar as regras do DTO
    @PostMapping("/batch")
    public ResponseEntity<List<Long>> createBatch(@RequestBody @Valid List<BibliografiaDTO> dtos) {
        List<Long> ids = service.saveAll(dtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(ids);
    }

    @GetMapping
    public ResponseEntity<List<Bibliografia>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Novo endpoint para buscar uma única bibliografia
    @GetMapping("/{id}")
    public ResponseEntity<Bibliografia> findById(@PathVariable Long id) {
        Bibliografia bibliografia = service.findById(id);
        return ResponseEntity.ok(bibliografia);
    }
}