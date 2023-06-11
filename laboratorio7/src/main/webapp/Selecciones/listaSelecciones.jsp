<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 10/06/2023
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.example.laboratorio7.models.beans.Jugador" %>
<%@ page import="com.example.laboratorio7.models.beans.Seleccion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<com.example.laboratorio7.models.beans.Seleccion>" scope="request" id="lista"/>
<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Selecciones"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="selecciones"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Lista de Selecciones</h1>
    </div>

    <div class="col-lg-6">
      <a class="btn btn-warning" href="<%=request.getContextPath()%>/listarSelecciones?a=agregarSeleccion">Registrar selecciones</a>
    </div>
  </div>


  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>Selección</th>
      <th>DT</th>
      <th>Estadio</th>
      <th>Proximo partido</th>
      </thead>
      <%
        for (Seleccion s : lista) {
      %>
      <tr>
        <td><%=s.getIdSeleccion()%>
        </td>
        <td><%=s.getNombre()%>
        </td>
        <td><%=s.getTecnico()%>
        </td>
        <td><%=s.getEstadio().getNombre()%>
        </td>
      </tr>
      <%
        }
      %>

    </table>
  </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
