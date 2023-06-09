<%@ page import="models.Beans.Canciones" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<models.Beans.Canciones>" scope="request" id="listaCanciones"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones por Banda</h1>
                </div>

                <div class="col-lg-6">
                    <a class="btn btn-warning" href="http://localhost:8080/LAB6_SW1_BASE_war_exploded//listaCanciones">Mostrar todas las canciones</a>
                </div>

            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>FAVORITO</th>
                    </thead>
                    <%
                        for (Canciones canciones : listaCanciones) {
                    %>
                    <tr method="POST" action="<%=request.getContextPath()%>/listaFavoritos">
                        <td id="idcancion"><%=canciones.getIdCancion()%>
                        </td>
                        <td><%=canciones.getNombreCancion()%>
                        </td>
                        <td><%=canciones.getIdBanda()%>
                        </td>
                        <td>
                            <form action="<%=request.getContextPath()%>/listaFavoritos" method="post">
                                <input type="hidden" name="idcancion" value="<%=canciones.getIdCancion()%>">
                                <input type="hidden" name="favorito" value="<%=canciones.getFavorito()%>">
                                <button type="button" class="btn btn-outline-success rounded-circle" data-toggle="button" aria-pressed="true" autocomplete="off"></button>
                            </form>
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
