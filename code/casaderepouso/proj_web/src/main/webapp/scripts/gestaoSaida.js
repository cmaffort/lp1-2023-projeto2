
let infoSaidas = document.querySelectorAll(".saida-container");
infoSaidas.forEach(info => {
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

   
    botoesAtualizar.forEach(function (botaoAtualizar) {
        botaoAtualizar.addEventListener("click", function () {
           
            var index = Array.from(botoesAtualizar).indexOf(botaoAtualizar);

           
            var atualizarContainers = document.querySelectorAll(".atualizar-container");
            var atualizarContainer = atualizarContainers[index];

            // Exibe a div 'atualizar-container'
            if (atualizarContainer) {
                atualizarContainer.style.display = "flex";
            }


            var cancelarAtualizacoes = document.querySelectorAll(".cancelUpdate");

           
            cancelarAtualizacoes.forEach(function (cancelarUpdate) {
                cancelarUpdate.addEventListener("click", function () {
                    // Pega o conteiner de atualização 
                    var atualizarContainer = cancelarUpdate.closest(".atualizar-container");

                    // Esconde a div 'atualizar-container'
                    if (atualizarContainer) {
                        atualizarContainer.style.display = "none";
                    }
                });
            });
        });
    });


    var pesquisaInput = document.getElementById('pesquisa');

    pesquisaInput.addEventListener('input', function () {
        // Obtém o valor da entrada de pesquisa
        var termoPesquisa = pesquisaInput.value.toLowerCase();

        // Seleciona todos os containers de saída
        var containersSaida = document.querySelectorAll('.saida-container');

        containersSaida.forEach(function (container) {
            // Obtém o nome e o CPF do container atual
            var nome = container.querySelector('.nome-cpf').textContent.toLowerCase();
            var cpf = container.querySelector('.cpf').textContent.toLowerCase();

            var correspondencia = nome.includes(termoPesquisa) || cpf.includes(termoPesquisa);

            container.style.display = correspondencia ? 'grid' : 'none';
        });
    });

});

// Função que deixa cinza e tira o botão atualizar das saídas que já ocorreram
function ajustarAparencia() {
    var saidaContainers = document.querySelectorAll('.saida-container');

    saidaContainers.forEach(function (saidaContainer) {
        var dataRetorno = saidaContainer.getAttribute('data-retorno');
        var dataRetornoObj = new Date(dataRetorno);
        var dataAtual = new Date();

        if (dataAtual >= dataRetornoObj) {
            var botaoAtualizar = saidaContainer.querySelector('.botao-atualizar');
            var containerInfo = saidaContainer.querySelector('.container-info');

            botaoAtualizar.style.display = 'none';
            containerInfo.style.backgroundColor = '#A9A9A9';
            saidaContainer.style.backgroundColor = '#A9A9A9';
        }
    });
}

// Chamo a função depois de renderizar a página
window.onload = function () {
    ajustarAparencia();
};




