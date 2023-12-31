<%-- 
    Document   : AgendarConsulta
    Created on : 3 de nov. de 2023, 15:50:27
    Author     : Júlia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">

        <title>JSP Page</title>
    </head>
<body>
    <%@include file="Padrão/navMorador.jsp" %>

      <article>
        <h1>Agendamento de consulta</h1>
        <form class="form-container" action="Facade" method="POST">
           <input type='hidden' name='act' value='AgendarConsulta'>
           
          <div class="form-group">
            <label>Selecione o especialista</label>
            <select class="escolha" name="especialista">
              <option value="Geriatra">Geriatra</option>
              <option value="Nutricionista">Nutricionista</option>
              <option value="Cardiologista">Cardiologista</option>
              <option value="Dermatologista">Dermatologista</option>
              <option value="Dentista">Dentista</option>
            </select>
          </div>

          <div class="form-group">
            <label>Caso exista, digite o nome do médico de acompanhamento:</label>
            <input type="text" name="medico" class="texto" placeholder="Digite aqui...">
          </div>

          <div class="form-group">
            <label>Qual tipo de consulta</label>
            <select class="escolha" name="tipoConsulta">
              <option value="Rotina">Rotina</option>
              <option value="Entregar exames">Entrega de exames</option>
              <option value="Realizar exames">Realização de exames</option>
            </select>
          </div>

          <p>Quando será a consulta?</p>
          <div class="form-group" id="marcar">
              <div>
                <label id="calendario" required>Data:</label>
                <input type="date" name="dataConsulta">
              </div>
              <div>
                <label id="Hora" required>Hora:</label>
                <input type="time" name="horaConsulta">
              </div>
          </div>

          <input type="submit" value="Agendar Consulta">

        </form>
      </article>
    </body>
</html>
