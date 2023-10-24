/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.dto.exception;

/**
 *
 * @author Aluno
 */
public class CadastroException extends Exception {
    public CadastroException(String mensagem) {
        super(mensagem);
    }
    
    public CadastroException() {
        super("Cadastro Incompleto");
    }
}