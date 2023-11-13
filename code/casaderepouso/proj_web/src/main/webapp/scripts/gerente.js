
let infoFuncionarios = document.querySelectorAll(".funcionario-container");
infoFuncionarios.forEach(info => {
    info.addEventListener("click", function onClick() {
        let containerInfo = info.lastElementChild;
        let seta = info.firstElementChild;
        let cpf = info.children;
        cpf = cpf[1].firstElementChild;
        if (containerInfo.style.display === "grid" && estaNosStatus === 0 && estaNoUpdate === 0) {
            containerInfo.style.display = "none";
            info.style.borderRadius = "50px";
            seta.style.transform = "rotate(180deg)";
        } else if (containerInfo.style.display === "none" && estaNosStatus === 0 && estaNoUpdate === 0) {
            containerInfo.style.display = "grid";
            seta.style.transform = "rotate(270deg)";
            info.style.borderRadius = "0px";
            localStorage.setItem("cpf", cpf.innerHTML);
        }
    });
});
let estaNosStatus = 0;
let mudancaStatus = document.querySelector("#status-container");
let containerStatus = document.querySelectorAll(".state-container");
containerStatus.forEach(stat => {
    stat.addEventListener("click", () => {
        mudancaStatus.style.display = "flex";
        estaNosStatus = 1;
    });
});
let cancela = document.querySelector("#cancelar");
cancela.addEventListener("click", () => {
    mudancaStatus.style.display = "none";
    estaNosStatus = 0;
});

let marcadores = document.querySelectorAll(".marks");
let elementoSelecionado = null;
marcadores.forEach(marc => {
    marc.addEventListener("click", () => {
        if (elementoSelecionado) {
            elementoSelecionado.style.backgroundColor = "#D9D9D9";
        }
        marc.style.backgroundColor = "black";
        elementoSelecionado = marc;
    });
});



let containerUpdate = document.querySelector("#atualizar-container");
let botaoUpdate = document.querySelectorAll(".botao-atualizar");
let estaNoUpdate = 0;
let botaoCancelarUpdate = document.querySelector("#cancelarUpdate");
function placeholder(funcionario){
    window.console.log(funcionario);
    window.console.log(containerUpdate.children[0].children[0].children[1]);
    containerUpdate.children[0].children[0].children[1].value = funcionario.children[0].children[0].innerHTML;
    containerUpdate.children[0].children[5].children[1].value = funcionario.children[0].children[1].innerHTML;
    containerUpdate.children[0].children[1].children[1].value = funcionario.children[1].children[0].children[0].innerHTML;
    containerUpdate.children[0].children[2].children[1].value = funcionario.children[1].children[1].children[0].innerHTML;
    containerUpdate.children[0].children[3].children[1].value = funcionario.children[1].children[2].children[0].innerHTML;
     containerUpdate.children[0].children[4].children[1].value = funcionario.children[1].children[3].children[0].innerHTML;
      containerUpdate.children[0].children[6].children[1].value = funcionario.children[1].children[4].children[0].innerHTML;
      containerUpdate.children[0].children[7].children[1].value = funcionario.children[1].children[5].children[0].innerHTML;
      containerUpdate.children[0].children[8].children[1].value = funcionario.children[1].children[6].children[0].innerHTML;
      
    containerUpdate.children[0].children[0].children[1].placeholder = funcionario.children[0].children[0].innerHTML;
    containerUpdate.children[0].children[5].children[1].placeholder = funcionario.children[0].children[1].innerHTML;
    containerUpdate.children[0].children[1].children[1].placeholder = funcionario.children[1].children[0].children[0].innerHTML;
    containerUpdate.children[0].children[2].children[1].placeholder = funcionario.children[1].children[1].children[0].innerHTML;
    containerUpdate.children[0].children[3].children[1].placeholder = funcionario.children[1].children[2].children[0].innerHTML;
     containerUpdate.children[0].children[4].children[1].placeholder = funcionario.children[1].children[3].children[0].innerHTML;
      containerUpdate.children[0].children[6].children[1].placeholder = funcionario.children[1].children[4].children[0].innerHTML;
      containerUpdate.children[0].children[7].children[1].placeholder = funcionario.children[1].children[5].children[0].innerHTML;
      containerUpdate.children[0].children[8].children[1].placeholder = funcionario.children[1].children[6].children[0].innerHTML;
}
botaoUpdate.forEach(bot =>{
   bot.addEventListener("click", ()=>{
       containerUpdate.style.display = "flex";
       estaNoUpdate = 1;
       placeholder(bot.parentNode.parentNode);
   }); 
});
botaoCancelarUpdate.addEventListener("click", () =>{
    containerUpdate.style.display = "none";
    estaNoUpdate = 0;
});