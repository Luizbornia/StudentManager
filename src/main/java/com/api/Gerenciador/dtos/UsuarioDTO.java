package com.api.gerenciador.dtos;


import javax.validation.constraints.NotBlank;


public class UsuarioDTO {

    @NotBlank
    private String funcao;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @NotBlank
    private String cidade;
    @NotBlank
    private String bairro;
    @NotBlank
    private String numero;
    private String complemento;

    public String getFuncao(){
        return this.funcao;
    }

}
