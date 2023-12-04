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
    dataVLocal = adicionarUmMes(dataVLocal);
    datavencimento.innerHTML = dataVLocal;
    sessionStorage.setItem("meses", nMeses.innerHTML);
});
botaoSubMes.addEventListener("click", () => {
    n = parseInt(nMeses.innerHTML);
    if (n === 1) {
    } else {
        n = n - 1;
        nMeses.innerHTML = n.toString() + "x";
        preco.innerHTML = parseInt(preco.innerHTML) - 120;
        dataVLocal = diminuirUmMes(dataVLocal);
        datavencimento.innerHTML = dataVLocal;
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
    cartoesDoTipo();
});

containerImg.children[1].addEventListener('click', () => {
    marca.src = "./imgs/mastercard.png";
    inputCardType.value = "mastercard";
    marcaType = "mastercard";
    sessionStorage.setItem("marca", marcaType);
    containerCartao.style.display = "flex";
    cartoesDoTipo();
});

containerImg.children[2].addEventListener('click', () => {

});

let botaoLista = document.querySelector("#botao-cartoes-salvos");
let lista = document.querySelector("#lista-cartoes");
let cartoesLista = document.querySelectorAll(".cartao-salvo");
function ocultarCaracteres(string) {
    let numeroSemEspacos = string.replace(/\s/g, '');
    let ultimosQuatroDigitos = numeroSemEspacos.slice(-4);
    let stringMascarada = numeroSemEspacos.slice(0, -4).replace(/./g, '*')+ ultimosQuatroDigitos;

    return stringMascarada;
}
function cartoesDoTipo(){
    cartoesLista.forEach(car => {
            let numero = car.children[0];
            car.children[1].innerHTML = ocultarCaracteres(numero.innerHTML);
            if (car.children[2].innerHTML !== marcaType) {
                car.style.display = "none";
            } else {
                car.style.display = "block";
            }
        });
}
function mostrarLista() {
    if (lista.style.display === "none") {
        lista.style.display = "flex";
        sessionStorage.setItem('lista', 'display');
        cartoesDoTipo();
    } else {
        lista.style.display = "none";
        sessionStorage.setItem('lista', 'none');
    }
}
botaoLista.addEventListener("click", mostrarLista);
if (sessionStorage.getItem('marca') === "visa") {
    marca.src = "imgs/visa.png";
    containerCartao.style.display = "flex";
} else if (sessionStorage.getItem('marca') === "mastercard") {
    marca.src = "imgs/mastercard.png";
    containerCartao.style.display = "flex";
}
if (sessionStorage.getItem('lista') === "display") {
    mostrarLista();
}

function srcMiniImg(){
    cartoesLista.forEach(car =>{
        let type = car.children[2];
        if(type === 'visa'){
            car.children[3].src = "imgs/visa.png";
        }
        if(type === 'mastercard'){
            car.children[3].src = "imgs/mastercard.png";
        }
    });
}
srcMiniImg();




// nome
let nome = document.querySelector("#nome-morador");
nome.innerHTML = localStorage.getItem('nomeMorador');

let datainicio = document.querySelector("#data-inicio");
let datavencimento = document.querySelector("#data-vencimento");
let dataILocal = localStorage.getItem('data-inicio');
let dataVLocal = localStorage.getItem('data-vencimento');
let estadoMen = localStorage.getItem('estadoMensalidade');

function adicionarUmMes(data) {
    let dataMoment = moment(data, 'DD/MM/YYYY');
    let novaDataMoment = dataMoment.add(1, 'months');

    return novaDataMoment.format('DD/MM/YYYY');
}
function diminuirUmMes(data) {
    let dataMoment = moment(data, 'DD/MM/YYYY');
    let novaDataMoment = dataMoment.subtract(1, 'months');

    return novaDataMoment.format('DD/MM/YYYY');
}
if (estadoMen === 'naopaga' || estadoMen === 'hoje') {
    let dataAtual = moment();
    datainicio.innerHTML = dataAtual.format("DD/MM/YYYY");
    dataILocal = dataAtual.format("DD/MM/YYYY");
    console.log(dataILocal);
    dataVLocal = adicionarUmMes(dataAtual);
    console.log(dataVLocal);
    datavencimento.innerHTML = dataVLocal;
}
if (estadoMen === 'ok') {
    dataILocal = dataVLocal;
    datainicio.innerHTML = dataILocal;
    console.log(dataILocal);
    dataVLocal = adicionarUmMes(dataILocal);
    console.log(dataVLocal);
    datavencimento.innerHTML = dataVLocal;
}


// Preencher Inputs para mandar informações
let numeroInput = document.querySelector('#numeroInput');
let nomeInput = document.querySelector('#nomeInput');
let validadeInput = document.querySelector('#validadeInput');
let codigoInput = document.querySelector('#codigoInput');

let inputInicio = document.querySelector('#inicioInput');
let inputFim = document.querySelector('#fimInput');
let cpfMoradorInput = document.querySelector('#cpfMoradorInput');
let cpfResponsavelInput = document.querySelector('#cpf');
let totalPagarInput = document.querySelector('#totalPagarInput');

inputInicio.value = dataILocal;
inputFim.value = dataVLocal;
cpfResponsavelInput.value = localStorage.getItem('cpfResponsavel');
cpfMoradorInput.value = localStorage.getItem('cpfMorador');
totalPagarInput.value = preco.innerHTML;


cartoesLista.forEach(car =>{
   car.addEventListener('click', () =>{
      car.style.borderColor = 'red';
      numeroInput.value = car.children[0].innerHTML;
      nomeInput.value = car.children[4].innerHTML;
      validadeInput.value = car.children[5].innerHTML;
   }); 
});

// botao pagamento 

let botao = document.querySelector("#efetua-pagamento");
botao.addEventListener('click', () =>{
   localStorage.setItem('data-inicio', dataILocal);
   localStorage.setItem('data-vencimento', dataVLocal);
});
    