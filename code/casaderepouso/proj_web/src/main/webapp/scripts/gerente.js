
let infoFuncionarios = document.querySelectorAll(".funcionario-container");
infoFuncionarios.forEach(info => {
    info.addEventListener("click", function onClick() {
        let containerInfo = info.lastElementChild;
        let seta = info.firstElementChild;

        let cpf = info.children;
        cpf = cpf[1].firstElementChild;
        window.console.log(cpf.innerHTML);
        if (containerInfo.style.display === "grid" && estaNosStatus === 0) {
            containerInfo.style.display = "none";
            info.style.borderRadius = "50px";
            seta.style.transform = "rotate(180deg)";
        } else if (containerInfo.style.display === "none" && estaNosStatus === 0) {
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

document.addEventListener("DOMContentLoaded", function () {

    var botoesAtualizar = document.querySelectorAll(".botao-atualizar");

    // Itera sobre cada botão e adiciona um ouvinte de evento
    botoesAtualizar.forEach(function (botaoAtualizar) {
        botaoAtualizar.addEventListener("click", function () {
            // Obtém o índice do botão atual na lista de botões de atualização
            var index = Array.from(botoesAtualizar).indexOf(botaoAtualizar);

            // Seletor do contêiner de atualização correspondente
            var atualizarContainers = document.querySelectorAll(".atualizar-container");
            var atualizarContainer = atualizarContainers[index];

            // Exibe a div 'atualizar-container'
            if (atualizarContainer) {
                atualizarContainer.style.display = "flex";
            }


            var cancelarAtualizacoes = document.querySelectorAll(".cancelUpdate");

            // Adiciona um ouvinte de evento para cada elemento "cancelUpdate"
            cancelarAtualizacoes.forEach(function (cancelarUpdate) {
                cancelarUpdate.addEventListener("click", function () {
                    // Encontra o contêiner de atualização correspondente
                    var atualizarContainer = cancelarUpdate.closest(".atualizar-container");

                    // Esconde a div 'atualizar-container'
                    if (atualizarContainer) {
                        atualizarContainer.style.display = "none";
                    }
                });
            });
        });
    });
});



