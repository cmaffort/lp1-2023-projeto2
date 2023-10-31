/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function enviarInfo(nome,cpf, estado, nomeMae, condicaoEspecial){
    let docNome = document.getElementById("name");
    let docCpf = document.getElementById("cpf");
    let docEstadoCor = document.getElementById("state-cor");
    let docEstadoNome = document.getElementById("state-nome");
    let docNomeMae = document.getElementById("nome-mae");
    let docCondicao = document.getElementById("condicoes");
    
    
    docNome.value = nome;
    docCpf.value = "CPF: " + cpf;
    docNomeMae.value = "Nome da Mãe: " + nomeMae;
    docCondicao.value = "Condições especiais: " + condicaoEspecial;
    switch(estado){
        case "Disponível":
            docEstadoNome.value = "Disponível";
            docEstadoCor.style.backgroundcolor = "green;";
            break;
        case "Saída Temporária":
            docEstadoNome.value = "Saída Temporária";
            docEstadoCor.style.backgroundcolor = "blue;";
            break;
        case "Internado":
            docEstadoNome.value = "Internado";
            docEstadoCor.style.backgroundcolor = "black;";
            break;
        case "Falecido":
            docEstadoNome.value = "Falecido";
            docEstadoCor.style.backgroundcolor = "black;";
            break;
    }
}