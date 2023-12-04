/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function compararDatas(data1, data2) {
    let formatoData = "DD/MM/YYYY";

    try {
        let data1Obj = moment(data1, formatoData);
        let data2Obj = moment(data2, formatoData);

        if (data1Obj.isBefore(data2Obj)) {
            return 0;
        } else if (data1Obj.isAfter(data2Obj)) {
            return 1;
        } else if (data1Obj === data2Obj){
            return 2;
        }
        else{
            return 3;
        }
    } catch (error) {
        return 3;
    }
}
let cpfMorador = localStorage.getItem("cpfResponsavel");
let moradores = document.querySelectorAll(".morador");
let mensalidade = document.querySelectorAll(".mensalidade");
let moradorRes;
let mensalidadeRes;
moradores.forEach(mor => {
    if (mor.children[0].innerHTML === cpfMorador) {
        moradorRes = mor;
        console.log(moradorRes);
        localStorage.setItem('nomeMorador', moradorRes.children[1].innerHTML);
    } else {
        mor.remove();
    }
});
// se não funcionar trocar para a mensalidade armazenar o nome do morador tbm
mensalidade.forEach(men => {
    console.log(men.children[0].innerHTML);
    if (men.children[0].innerHTML === moradorRes.children[0].innerHTML) {
        mensalidadeRes = men;
    } else {
        men.remove();
    }
});
cpfDoMorador = mensalidadeRes.children[1].innerHTML;
datainicio = mensalidadeRes.children[2].innerHTML;
datavencimento = mensalidadeRes.children[3].innerHTML;
localStorage.setItem('data-inicio', datainicio);
localStorage.setItem('data-vencimento', datavencimento);
localStorage.setItem('cpfMorador', cpfDoMorador);

let diavencimento = document.querySelector("#diavencimento");
let mensagem = document.querySelector("#mensagem");
if(datavencimento === "null"){
}
else{
    diavencimento.innerHTML = datavencimento;
}
let dataAtual = moment();
dataAtual.format("DD/MM/YYYY");
if (compararDatas(datavencimento, dataAtual) === 3) {
    alert("Mensalidade não foi paga");
    localStorage.setItem('estadoMensalidade', 'naopaga');
    mensagem.innerHTML = "Mensalidade ainda não foi paga";
}
if (compararDatas(datavencimento, dataAtual) === 0) {
    alert("Mensalidade em atrazo");
    localStorage.setItem('estadoMensalidade', 'atrazo');
    mensagem.innerHTML = "Mensalidade atrazada";
}
if (compararDatas(datavencimento, dataAtual) === 1) {
    localStorage.setItem('estadoMensalidade', 'ok');
}
if (compararDatas(datavencimento, dataAtual) === 2) {
    alert("Sua mensalidade vence hoje");
    localStorage.setItem('estadoMensalidade', 'hoje');
}
let nomeBemvindo = document.querySelector("#nomeMorador");
nomeBemvindo.innerHTML = moradorRes.children[1].innerHTML;