/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function confirma(id){
                let resp = confirm("Deseja excluir este funcionário?");
                if(resp === true){
                    window.location.href = "deleteFunc?id=" + id;
                }
                
                
            }
