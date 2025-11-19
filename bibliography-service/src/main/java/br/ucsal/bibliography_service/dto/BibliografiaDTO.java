package br.ucsal.bibliography_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BibliografiaDTO {

    @NotBlank(message = "O título é obrigatório.") //VALIDAÇÃO, PARA CERTIFICAR QUE TÍTULO E AUTOR NÃO SEJAM NULOS E NEM VAZIOS.
    @Size(max = 255, message = "O título deve ter no máximo 255 caracteres.")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório.")
    private String autor;

    @NotBlank(message = "O ano é obrigatório.")
    @Size(min = 4, max = 4, message = "O ano deve ter 4 dígitos.")
    private String ano;

    private String editora;
    private String edicao;
    private String link;
}