/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// Gerar QR Code
var qrcode = new QRCode("qrcode", {
  text: "TelaInicialResponsavel.jsp", // URL para a qual o usuário será redirecionado
  width: 200,
  height: 200
});

// Verificar a leitura do QR Code
var video = document.createElement("video");

// Obter acesso à câmera
navigator.mediaDevices.getUserMedia({ video: { facingMode: "environment" } })
  .then(function (stream) {
    video.srcObject = stream;
    video.setAttribute("playsinline", true); // iOS
    video.play();
    requestAnimationFrame(tick);
  });

// Verificar continuamente se há QR Code na câmera
function tick() {
  if (video.readyState === video.HAVE_ENOUGH_DATA) {
    qrcodeScanner(video);
  }
  requestAnimationFrame(tick);
}

// Verificar se há QR Code na imagem da câmera
function qrcodeScanner(video) {
  var canvasElement = document.createElement("canvas");
  var canvas = canvasElement.getContext("2d");

  canvasElement.width = video.videoWidth;
  canvasElement.height = video.videoHeight;
  canvas.drawImage(video, 0, 0, canvasElement.width, canvasElement.height);

  try {
    var result = qrcode.decode(canvas.getImageData(0, 0, canvasElement.width, canvasElement.height));
    window.location.href = result;
  } catch (e) {
    // Nenhum QR Code detectado, continuar verificação
  }
}
