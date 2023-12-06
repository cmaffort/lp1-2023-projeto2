document.addEventListener("DOMContentLoaded", function () {

    var botoesCadastrar = document.querySelectorAll(".botao-cadastrar");

    botoesCadastrar.forEach(function (botaoCadastrar) {
        botaoCadastrar.addEventListener("click", function () {
            var index = Array.from(botoesCadastrar).indexOf(botaoCadastrar);

            var cadastrarContainers = document.querySelectorAll(".cadastrar-container");
            var cadastrarContainer = cadastrarContainers[index];

            if (cadastrarContainer) {
                cadastrarContainer.style.display = "flex";
            }


            var cancelarCadastros = document.querySelectorAll(".cancelarCadastro");

            cancelarCadastros.forEach(function (cancelarCadastro) {
                cancelarCadastro.addEventListener("click", function () {
                    var cadastrarContainer = cancelarCadastro.closest(".cadastrar-container");

                    if (cadastrarContainer) {
                        cadastrarContainer.style.display = "none";
                    }
                });
            });
        });
    });

});

document.addEventListener("DOMContentLoaded", function () {

    var botoesEquipamento = document.querySelectorAll(".equipamento");

    botoesEquipamento.forEach(function (botaoEquipamento) {
        botaoEquipamento.addEventListener("click", function () {
            var index = Array.from(botoesEquipamento).indexOf(botaoEquipamento);

            var exibirContainers = document.querySelectorAll(".container-info");
            var exibirContainer = exibirContainers[index];

            if (exibirContainer) {
                exibirContainer.style.display = "flex";
            }


            var cancelarExibicoes = document.querySelectorAll(".cancelarExibicao");

            cancelarExibicoes.forEach(function (cancelarExibicao) {
                cancelarExibicao.addEventListener("click", function () {
                    var cadastrarContainer = cancelarExibicao.closest(".container-info");

                    if (cadastrarContainer) {
                        exibirContainer.style.display = "none";
                    }
                });
            });
        });
    });

});

document.addEventListener("DOMContentLoaded", function () {



    var campoPesquisa = document.getElementById("pesquisa");
    var btnPesquisar = document.getElementById("btnPesquisar");
    var equipamento = document.querySelectorAll(".equipamento");


    btnPesquisar.addEventListener("click", function () {

        var termoPesquisa = campoPesquisa.value.toLowerCase();


        equipamento.forEach(function (event) {
            var nomeEquipamento = event.querySelector(".info-container").innerText.toLowerCase();


            if (nomeEquipamento.includes(termoPesquisa)) {
                event.style.display = "grid";
            } else {
                event.style.display = "none";
            }
        });
    });
});

document.addEventListener("DOMContentLoaded", function () {

    var botoesCadastrar = document.querySelectorAll(".botao-atualizar");

    botoesCadastrar.forEach(function (botaoCadastrar) {
        botaoCadastrar.addEventListener("click", function () {
            var index = Array.from(botoesCadastrar).indexOf(botaoCadastrar);

            var cadastrarContainers = document.querySelectorAll(".atualizar-container");
            var cadastrarContainer = cadastrarContainers[index];

            if (cadastrarContainer) {
                cadastrarContainer.style.display = "flex";
            }


            var cancelarCadastros = document.querySelectorAll(".cancelarCadastro");

            cancelarCadastros.forEach(function (cancelarCadastro) {
                cancelarCadastro.addEventListener("click", function () {
                    var cadastrarContainer = cancelarCadastro.closest(".cadastrar-container");

                    if (cadastrarContainer) {
                        cadastrarContainer.style.display = "none";
                    }
                });
            });
        });
    });

});


document.addEventListener("DOMContentLoaded", function () {



    var campoPesquisa = document.getElementById("estados");
    var btnPesquisar = document.getElementById("pesquisaEstado");
    var equipamento = document.querySelectorAll(".equipamento");


    btnPesquisar.addEventListener("click", function () {

        var termoPesquisa = campoPesquisa.value.toLowerCase();


        equipamento.forEach(function (event) {
            var nomeEquipamento = event.querySelector(".estado").innerText.toLowerCase();


            if (nomeEquipamento.includes(termoPesquisa)) {
                event.style.display = "grid";
            } else {
                event.style.display = "none";
            }
        });
    });
});