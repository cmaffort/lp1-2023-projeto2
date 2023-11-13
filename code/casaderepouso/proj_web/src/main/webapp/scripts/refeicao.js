/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let input = document.querySelector("#inputcpf");
let cpfM = localStorage.getItem('cpf');
input.value = cpfM;
function removerMoradores(cpf){
    let remover = document.querySelectorAll('.cpf-refeicoes');
    remover.forEach(remov =>{
       if(remov.innerHTML !== cpf){
           remov.parentNode.remove();
       } 
    });
}
removerMoradores(cpfM);
const diasDaSemana = {
  domingo: 0,
  segunda: 1,
  terça: 2,
  quarta: 3,
  quinta: 4,
  sexta: 5,
  sábado: 6
};


function compararDiasETempo(a, b) {
  let diaA = a.parentNode.getElementsByTagName("td")[2].innerHTML;
  let diaB = b.parentNode.getElementsByTagName("td")[2].innerHTML;

  let horaA = a.parentNode.getElementsByTagName("td")[3].innerHTML;
  let horaB = b.parentNode.getElementsByTagName("td")[3].innerHTML;

  if (diaA.localeCompare(diaB) === 0) {
    return horaA.localeCompare(horaB, undefined, { hour: 'numeric', minute: 'numeric' });
  }

  return diaA.localeCompare(diaB);
}
    
function sortTable(index) {
  let table, rows, trocar, i, x, y, deveTrocar;
  table = document.getElementById("tabela");
  trocar = true;
  
  while (trocar) {
    trocar = false;
    rows = table.rows;

    for (i = 1; i < (rows.length - 1); i++) {
      deveTrocar = false;

      x = rows[i].getElementsByTagName("td")[index];
      y = rows[i + 1].getElementsByTagName("td")[index];

      if (compararDiasETempo(x, y) > 0) {
        deveTrocar = true;
        break;
      }
    }

    if (deveTrocar) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      trocar = true;
    }
  }
}
sortTable(2);