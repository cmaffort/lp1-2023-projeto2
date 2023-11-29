/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

// aumentar meses
let nMeses = document.querySelector("#meses");
let botaoAddMes = document.querySelector("#addMes");
let botaoSubMes = document.querySelector("#subMes");
let preco = document.querySelector("#valor-preco");


botaoAddMes.addEventListener("click", () => {
    n = parseInt(nMeses.innerHTML) + 1;
    nMeses.innerHTML = n.toString() + "x";
    preco.innerHTML = parseInt(preco.innerHTML) + 120;
});
botaoSubMes.addEventListener("click", () => {
    n = parseInt(nMeses.innerHTML);
    if (n === 1) {
    } else {
        n = n - 1;
        nMeses.innerHTML = n.toString() + "x";
        preco.innerHTML = parseInt(preco.innerHTML) - 120;
    }
});
// aparecer containers
let containerImg = document.querySelector("#pagamento-formas");
let marca = document.querySelector("#marca-cartao");
let containerCartao = document.querySelector("#pagamentoCartao");
let marcaType = sessionStorage.getItem('marca');
let inputCardType = document.querySelector("#cardtype");

containerImg.children[0].addEventListener('click', () => {
    marca.src = "./imgs/visa.png";
    inputCardType.value = "visa";
    marcaType = "visa";
    sessionStorage.setItem("marca", marcaType);
    containerCartao.style.display = "flex";
});

containerImg.children[1].addEventListener('click', () => {
    marca.src = "./imgs/mastercard.png";
    inputCardType.value = "mastercard";
    marcaType = "mastercard";
    sessionStorage.setItem("marca", marcaType);
    containerCartao.style.display = "flex";
});

containerImg.children[2].addEventListener('click', () => {
 
});

let botaoLista = document.querySelector("#botao-cartoes-salvos");
let lista = document.querySelector("#lista-cartoes");
let cartoesLista = document.querySelectorAll(".cartao-salvo");
function ocultarCaracteres(string){
    let ultimosQuatroCaracteres = string.substring(string.length - 4);
    let stringOcultada = "*".repeat(string.length - 4) + ultimosQuatroCaracteres;

    return stringOcultada;
}
function mostrarLista(){
    if(lista.style.display === "none"){
        lista.style.display = "flex";
        sessionStorage.setItem('lista','display');
        cartoesLista.forEach(car =>{
            let numero = car.children[0];
            car.children[1] = ocultarCaracteres(numero);
            if(car.lastChild.innerHTML !== marcaType){
                car.style.display = "none";
            }
            else{
                car.style.display = "block";
            }
        });
    }
    else{
        lista.style.display = "none";
        sessionStorage.setItem('lista','none');
    }       
}
botaoLista.addEventListener("click", mostrarLista);
if(sessionStorage.getItem('marca') === "visa"){    
        marca.src = "imgs/visa.png";
        containerCartao.style.display = "flex";
    }
    else if(sessionStorage.getItem('marca') === "mastercard"){
        marca.src = "imgs/mastercard.png";
        containerCartao.style.display = "flex";
    }
if(sessionStorage.getItem('lista') === "display"){
    mostarLista();
}
