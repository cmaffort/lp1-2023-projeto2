

let documentoEl = document.querySelector("article");
let baixarEl = document.querySelector("#baixar");


baixarEl.addEventListener("click", function () {
    html2canvas(documentoEl, {useCORS: true}).then(function (canvas) {
        let imagemCodificadaEmURL = canvas.toDataURL();
        let linkEl = document.createElement('a');
        linkEl.download = 'despesas.png';
        linkEl.href = imagemCodificadaEmURL;
        document.body.appendChild(linkEl);
        linkEl.click();
    });
}); 