/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.dto.exception;

/**
 *
 * @author felli
 */


//classe de erro para tratamento de erros na persistencia em banco de dados
public class PersistenciaException extends Exception{

    public PersistenciaException(String msg){
        super(msg);
    }
    
    
    public PersistenciaException(){
        super("Error de persistencia no banco de dados");
    }
}
