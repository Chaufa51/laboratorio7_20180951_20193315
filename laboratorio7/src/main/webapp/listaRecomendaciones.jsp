<%@ page import="models.Beans.Canciones" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<models.Beans.Canciones>" scope="request" id="listaRecomendaciones"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Recomendaciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="recomendaciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>VER</th>
                        <th>FAVORITO</th>
                    </thead>
                    <%
                        for (Canciones canciones : listaRecomendaciones) {
                    %>
                    <tr>
                        <td><%=canciones.getIdCancion()%>
                        </td>
                        <td><%=canciones.getNombreCancion()%>
                        </td>
                        <td><%=canciones.getIdBanda()%>
                        </td>
                        <td> <a class="btn btn-success" href="http://localhost:8080/LAB6_SW1_BASE_war_exploded//listaCancionesPorBanda?banda=<%=canciones.getIdBanda()%>">Mas de la Banda</a>
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
