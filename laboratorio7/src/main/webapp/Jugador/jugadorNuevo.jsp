<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.laboratorio7.models.beans.Seleccion" %>
<%@ page import="com.example.laboratorio7.models.beans.Seleccion" %>
<jsp:useBean id="lista" type="java.util.ArrayList<com.example.laboratorio7.models.beans.Seleccion>" scope="request"/>
<html>
  <jsp:include page="/static/head.jsp">
      <jsp:param name="title" value="Lista de Jugadores"/>
  </jsp:include>
  <body>
  <div class='container'>
    <jsp:include page="/includes/navbar.jsp">
      <jsp:param name="page" value="jugadores"/>
    </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
    <div class="col-lg-10">
      <h1 class='text-light'>Jugador Nuevo</h1>
    </div>
  </div>
  <div class="tabla">
    <form method="POST" action="<%=request.getContextPath()%>/listarJugadores?a=agregarJugador">
      <div class="mb-3">
        <label class='text-light' for="nombre">Nombre</label>
        <input type="text" class="form-control" name="nombre" id="nombre">
      </div>
      <div class="mb-3">
        <label class='text-light' for="edad">Edad</label>
        <input type="text" class="form-control" name="edad" id="edad">
      </div>
      <div class="mb-3">
        <label class='text-light' for="posicion">Posicion</label>
        <input type="text" class="form-control" name="posicion" id="posicion">
      </div>
      <div class="mb-3">
        <label class='text-light' for="club">Club</label>
        <input type="text" class="form-control" name="club" id="club">
      </div>
      <div class="mb-3">
        <label class='text-light' for="selecciones">Selecciones</label>
        <select class="form-select" name="selecciones" id="selecciones">
          <% for (Seleccion s : lista) { %>
          <option value="<%=s.getIdSeleccion()%>">
            <%=s.getNombre()%>
          </option>
          <% } %>
        </select>
      </div>
      <a class="btn btn-danger" href="<%=request.getContextPath()%>/listarJugadores">Cancelar</a>
      <button type="submit" class="btn btn-light">Guardar Jugador</button>
    </form>
  </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
