/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



var qrcode = new QRCode("qrcode", {
    text: "https://youtu.be/DCOonkQtoeQ?t=17",
    width: 200,
    height: 200
});
// aumentar meses
let nMeses = document.querySelector("#meses");
let botaoAddMes = document.querySelector("#addMes");
let botaoSubMes = document.querySelector("#subMes");


botaoAddMes.addEventListener("click", () => {
    n = Number(nMeses.innerHTML) + 1;
    nMeses.innerHTML = n.toString();
});
botaoSubMes.addEventListener("click", () => {
    n = Number(nMeses.innerHTML);
    if (n === 1) {
    } else {
        n = n - 1;
        nMeses.innerHTML = n.toString();
    }
});
// aparecer containers
let containerImg = document.querySelector("#pagamento-formas");
let marca = document.querySelector("#marca-cartao");
let containerCartao = document.querySelector("#pagamentoCartao");
let containerPix = document.querySelector("#pagamentoPIX");
let visaTypeOn = false;
let inputCardType = document.querySelector("#cardtype");
if (marca.src === "./imgs/Visa.png") {
    visaTypeOn = true;
} else {
    visaTypeOn = false;
}
containerImg.children[0].addEventListener('click', () => {
    marca.src = "./imgs/Visa.png";
    inputCardType.value = "visa";
    containerPix.style.display = "none";
    if (containerCartao.style.display === "block") {
    } else
        containerCartao.style.display = "block";
});

containerImg.children[1].addEventListener('click', () => {
    marca.src = "./imgs/MASTERCARD.png";
    inputCardType.value = "mastercard";
    containerPix.style.display = "none";
    if (containerCartao.style.display === "block") {
    } else
        containerCartao.style.display = "block";
});

containerImg.children[2].addEventListener('click', () => {
    if (containerCartao.style.display === "block") {
        containerCartao.style.display = "none";
    } else
        containerPix.style.display = "block";
});