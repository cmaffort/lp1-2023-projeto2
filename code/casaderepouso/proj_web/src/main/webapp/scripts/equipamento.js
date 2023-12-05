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


