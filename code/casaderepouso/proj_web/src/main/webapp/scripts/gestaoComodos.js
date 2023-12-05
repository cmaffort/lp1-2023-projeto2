/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



    function ToggleForm() {
        let cadastro = document.getElementById("formulario");
        let listar = document.getElementById("listar");
        if (cadastro.style.display !== "flex") {
            cadastro.style.display = "flex";
            listar.style.display = "none";
        } else {
            cadastro.style.display = "none";
            listar.style.display = "flex";
        }
    }

    function MostraCondicao() {
        let condicao = document.getElementById("condicao");
        let ocupado = document.querySelectorAll('.ocupado');
        let manutencao = document.querySelectorAll('.manutencao');
        let livre = document.querySelectorAll('.livre');

        if (condicao.value === 'OCUPADO') {
            ocupado.forEach(function (ocu) {
                ocu.style.display = "block";
            });
            manutencao.forEach(function (manu) {
                manu.style.display = "none";
            });
            livre.forEach(function (liv) {
                liv.style.display = "none";
            });
        } else if (condicao.value === 'MANUTENCAO') {
            ocupado.forEach(function (ocu) {
                ocu.style.display = "none";
            });
            manutencao.forEach(function (manu) {
                manu.style.display = "block";
            });
            livre.forEach(function (liv) {
                liv.style.display = "none";
            });
        } else if (condicao.value === 'LIVRE') {
            
            ocupado.forEach(function (ocu) {
                ocu.style.display = "none";
            });
            manutencao.forEach(function (manu) {
                manu.style.display = "none";
            });
            livre.forEach(function (liv) {
                liv.style.display = "block";
            });
        }

    }


    let comodos = document.querySelectorAll('.comodoDIV');
    let content = document.getElementById('content');
    let minhaDiv = document.getElementById('DivCriada');


    comodos.forEach(comodo => {
        comodo.addEventListener("click", () => {

            minhaDiv = document.getElementById('DivCriada');

            if (minhaDiv) {
                minhaDiv.remove();
            }

            let id = comodo.children[0].value;


            let divHTML = `
            <form class="FormCriado" id="formCriado" >
                <div>
                <p>ATUALIZAR COMODO</p>
                </div>
                <input type="hidden" name="act" value="atualizarComodo">
                <input type="hidden" id="ID" name="ID" value="id" >
                <div>
                <p id="nomeCriado"><p>
                </div>
                <div>
                <label> Nome:<input type="text" name="nome"></label>
                </div>
                <div>
                <label> capacidade do comodo:<input type="text" name="capacidade"> </label>
                </div>
                <div>
                    <label class="condicao">Condicao dos comodos<br><select name="condicao"  required>
                            <option value="OCUPADO">ocupado</option>
                            <option value="MANUTENCAO" selected>manutenção</option>
                            <option value="LIVRE">livre</option>
                            <option value="OUTRO">outro</option>
                        </select>
                    </label>
                </div>
                <div>
                    <label>descricao do comodo<br>
                        <textarea id="texto" name="descricao" rows="10" cols="50"></textarea>
                    </label>
                </div>

                    <input type="submit">
                    <button id="fechar">fechar</button>
`;

            let div = document.createElement('div');
            div.class = "DivCriada";
            div.id = "DivCriada";
            div.innerHTML = divHTML;

            content.appendChild(div);

            document.getElementById('ID').value = id;
            botaoFechar = document.getElementById('fechar');

            botaoFechar.addEventListener("click", () => {
                div = document.getElementById('DivCriada');
                div.remove();

            });


        });
    });


 
function validarFormulario() {
    let nomes = document.querySelectorAll('.nome');
    let capacidade = document.querySelectorAll('.capacidade');
    let revisoes = document.querySelectorAll('.revisao');
    let condicao = document.querySelectorAll('.condicao');
    let descricao = document.querySelectorAll('.descricao');

    nomes.forEach(function (nome) {
        if (nome.value === '') {
            document.getElementById('nomeErro').textContent = 'Campo obrigatório';
        } else {
            document.getElementById('nomeErro').textContent = '';
        }
    });

    capacidade.forEach(function (capa) {
        if (capa.value === '') {
            document.getElementById('capaErro').textContent = 'Campo obrigatório';
        } else {
            let valor = capa.value.replace(/[^\d]/g, '');
            capa.value = valor;
            document.getElementById('capaErro').textContent = '';
        }
    });

    revisoes.forEach(function (revi) {
        if (revi.value === '') {
            document.getElementById('reviErro').textContent = 'Campo obrigatório';
        } else {
            document.getElementById('reviErro').textContent = '';
        }
    });

    condicao.forEach(function (cond) {
        if (cond.value === '') {
            document.getElementById('condErro').textContent = 'Campo obrigatório';
        } else {
            document.getElementById('condErro').textContent = '';
        }
    });

    descricao.forEach(function (desc) {
        if (desc.value === '') {
            document.getElementById('descErro').textContent = 'Campo obrigatório';
        } else {
            document.getElementById('descErro').textContent = '';
        }
    });
}
