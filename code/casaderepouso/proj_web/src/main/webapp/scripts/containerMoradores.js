/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let aberto = false;
let infoMoradores = document.querySelectorAll(".morador-container");
infoMoradores.forEach(info =>{
    info.addEventListener("click", function onClick() {
    let containerInfo = info.lastElementChild;
    let seta = info.firstElementChild;
    window.console.log("clicado");
    let cpf = info.children[1].firstElementChild;
    let nome = info.children[3].children[0].children[0];
    if (containerInfo.style.display === "grid" && estaNosStatus === 0 && aberto === true && estaNoUpdate  === 0) {
        containerInfo.style.display = "none";
        info.style.borderRadius = "50px";
        seta.style.transform = "rotate(180deg)";
        aberto = false;
    } else if (containerInfo.style.display === "none" && estaNosStatus === 0 && aberto === false  && estaNoUpdate  === 0) {
        containerInfo.style.display = "grid";
        seta.style.transform = "rotate(270deg)";
        info.style.borderRadius = "0px";
        localStorage.setItem("cpf", cpf.innerHTML);
        localStorage.setItem("nome", nome.innerHTML);
        aberto = true;
    }
});
});
let estaNosStatus = 0;
let mudancaStatus = document.querySelector("#status-container");
let containerStatus = document.querySelectorAll(".state-container");

containerStatus.forEach(stat =>{
   stat.addEventListener("click", () =>{
      mudancaStatus.style.display = "flex";
      estaNosStatus = 1;
      comecarMarcado(stat.children[1].innerHTML);
      atualizarEstado(stat.parentNode.children[3]);
   }); 
});
let cancela = document.querySelector("#cancelar");
cancela.addEventListener("click", () =>{
    mudancaStatus.style.display = "none";
    estaNosStatus = 0;
});

let marcadores = document.querySelectorAll(".marks");
let elementoSelecionado = null;

function atualizarEstado(moradorParaAtualizar){
    window.console.log(moradorParaAtualizar);
    document.querySelector('#enviarNome').value = moradorParaAtualizar.children[0].children[0].innerHTML;
    document.querySelector('#enviarCpf').value = moradorParaAtualizar.children[1].children[0].children[0].innerHTML;
    document.querySelector('#enviarPlano').value = moradorParaAtualizar.children[1].children[3].children[0].innerHTML;
    document.querySelector('#enviarCondic').value = moradorParaAtualizar.children[1].children[4].children[0].innerHTML;
    document.querySelector('#enviarNasc').value = moradorParaAtualizar.children[0].children[1].innerHTML;
    document.querySelector('#enviarMae').value = moradorParaAtualizar.children[1].children[1].children[0].innerHTML;
    document.querySelector('#enviarEndereco').value = moradorParaAtualizar.children[1].children[2].children[0].innerHTML;
    window.console.log(document.querySelector('#enviarCpf').value);
}
function comecarMarcado(estadoBD){
    marcadores.forEach(marc =>{
        if(marc.parentNode.children[1].innerHTML === estadoBD){
            document.querySelector('#enviarEstado').value = marc.parentNode.children[1].innerHTML;;
            window.console.log(document.querySelector('#enviarEstado').value);
            marc.style.backgroundColor = "black";
            elementoSelecionado = marc;
        }
    });
}
marcadores.forEach(marc => {
    marc.addEventListener("click", () => {
        if (elementoSelecionado) { 
            elementoSelecionado.style.backgroundColor = "#D9D9D9";
        }
        document.querySelector('#enviarEstado').value = marc.parentNode.children[1].innerHTML;;
        window.console.log(document.querySelector('#enviarEstado').value);
        marc.style.backgroundColor = "black";
        elementoSelecionado = marc;
    });
});

function corDoEstado(){
    let estados = document.querySelectorAll(".state-nome");
    estados.forEach(est => {
       let novaCor = "";
       switch(est.innerHTML){ 
           case "Disponível": novaCor = "#14FF00";
               break;
           case "Saída Temporária": novaCor = "#2882EB";
               est.parentNode.style.width = "18vh"; 
               break;
           case "Internado": novaCor = "#FF0000";
               break;
           case "Falecido": novaCor = "#1E1E1E";
       }
       est.parentNode.children[0].style.backgroundColor = novaCor;
    });       
}
corDoEstado();


let containerUpdate = document.querySelector("#atualizar-container");
let botaoUpdate = document.querySelectorAll(".botao-atualizar");
let estaNoUpdate = 0;
let botaoCancelarUpdate = document.querySelector("#cancelarUpdate");
function placeholder(){
    
}
botaoUpdate.forEach(bot =>{
   bot.addEventListener("click", ()=>{
       containerUpdate.style.display = "flex";
       estaNoUpdate = 1;
   }); 
});
botaoCancelarUpdate.addEventListener("click", () =>{
    containerUpdate.style.display = "none";
    estaNoUpdate = 0;
});