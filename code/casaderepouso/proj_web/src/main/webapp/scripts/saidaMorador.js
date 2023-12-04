function mostrarAtualizarContainer(id) {
    console.log("Tá chamando");
    var container = document.getElementById(id);
    container.style.display = 'grid';
}
function esconderAtualizarContainer(id) {
    var container = document.getElementById(id);
    container.style.display = 'none';
}
function ajustarAparencia() {
    var saidaContainers = document.querySelectorAll('.saida-div');

    saidaContainers.forEach(function (saidaContainer) {
        var dataRetorno = saidaContainer.getAttribute('data-retorno');
        var dataRetornoObj = new Date(dataRetorno);
        var dataAtual = new Date();

        if (dataAtual >= dataRetornoObj) {
            var botaoAtualizar = saidaContainer.querySelector('.botao-atualizar');


            botaoAtualizar.style.display = 'none';

            saidaContainer.style.backgroundColor = '#A9A9A9';
        }
    });
}
window.onload = function () {
    ajustarAparencia();
};

