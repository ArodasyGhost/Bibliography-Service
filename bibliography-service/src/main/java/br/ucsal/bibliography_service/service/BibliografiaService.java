package br.ucsal.bibliography_service.service;

import br.ucsal.bibliography_service.dto.BibliografiaDTO;
import br.ucsal.bibliography_service.model.Bibliografia;
import br.ucsal.bibliography_service.repository.BibliografiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BibliografiaService {

    private final BibliografiaRepository repository;

    // Salva uma lista e retorna os IDs gerados (Função principal para o Orquestrador)
    public List<Long> saveAll(List<BibliografiaDTO> dtos) {
        List<Bibliografia> bibliografias = dtos.stream().map(dto -> Bibliografia.builder()
                .titulo(dto.getTitulo())
                .autor(dto.getAutor())
                .ano(dto.getAno())
                .editora(dto.getEditora())
                .edicao(dto.getEdicao())
                .link(dto.getLink())
                .build()).collect(Collectors.toList());

        List<Bibliografia> salvas = repository.saveAll(bibliografias);

        // Retorna apenas os IDs das bibliografias que acabaram de ser salvas
        return salvas.stream().map(Bibliografia::getId).collect(Collectors.toList());
    }

    public List<Bibliografia> findAll() {
        return repository.findAll();
    }

    // Novo método para buscar por ID (útil para validação e consulta)
    public Bibliografia findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bibliografia não encontrada com ID: " + id));
    }
}