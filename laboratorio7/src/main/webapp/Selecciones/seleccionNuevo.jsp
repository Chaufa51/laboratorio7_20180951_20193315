<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 10/06/2023
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.laboratorio7.models.beans.Seleccion" %>
<%@ page import="com.example.laboratorio7.models.beans.Estadio" %>
<jsp:useBean id="lista" type="java.util.ArrayList<com.example.laboratorio7.models.beans.Estadio>" scope="request"/>
<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Selecciones"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="jugadores"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
    <div class="col-lg-10">
      <h1 class='text-light'>Registrar seleccion</h1>
    </div>
  </div>
  <div class="tabla">
    <form method="POST" action="<%=request.getContextPath()%>/listarSelecciones?a=agregarSeleccion">
      <div class="mb-3">
        <label class='text-light' for="seleccion">Seleccion</label>
        <input type="text" class="form-control" name="seleccion" id="seleccion">
      </div>
      <div class="mb-3">
        <label class='text-light' for="tecnico">Tecnico</label>
        <input type="text" class="form-control" name="tecnico" id="tecnico">
      </div>
      <div class="mb-3">
        <label class='text-light' for="estadios">Estadios</label>
        <select class="form-select" name="estadios" id="estadios">
          <% for (Estadio e : lista) { %>
          <option value="<%=e.getIdEstadio()%>">
            <%=e.getNombre()%>
          </option>
          <% } %>
        </select>
      </div>
      <a class="btn btn-danger" href="<%=request.getContextPath()%>/listarSelecciones">Cancelar</a>
      <button type="submit" class="btn btn-light">Guardar seleccion</button>
    </form>
  </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
