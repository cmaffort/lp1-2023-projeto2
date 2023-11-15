
let infoEventos = document.querySelectorAll(".lista");
infoEventos.forEach(info => {
    info.addEventListener("click", function onClick() {
        let containerInfo = info.lastElementChild;
        let seta = info.firstElementChild;
        window.console.log("clicado");
        window.console.log(info);
        window.console.log(containerInfo);
        let id = info.children;
        id = id[1].firstElementChild;
        if (containerInfo.style.display === "grid") {
            containerInfo.style.display = "none";
            info.style.borderRadius = "50px";
            seta.style.transform = "rotate(180deg)";
        } else if (containerInfo.style.display === "none") {
            containerInfo.style.display = "grid";
            seta.style.transform = "rotate(270deg)";
            info.style.borderRadius = "0px";
            localStorage.setItem("id", id.innerHTML);
        }
    });
});


document.addEventListener("DOMContentLoaded", function () {



    var campoPesquisa = document.getElementById("pesquisa");
    var btnPesquisar = document.getElementById("btnPesquisar");
    var receitas = document.querySelectorAll(".lista");


    btnPesquisar.addEventListener("click", function () {

        var termoPesquisa = campoPesquisa.value;


        receitas.forEach(function (event) {
            var idReceita = event.querySelector(".receita-id").innerText.toLowerCase();


            if (idReceita.includes(termoPesquisa)) {
                event.style.display = "grid";
            } else {
                event.style.display = "none";
            }
        });
    });
});
