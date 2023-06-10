<%@ page import="com.example.laboratorio7.models.beans.Jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<com.example.laboratorio7.models.beans.Jugador>" scope="request" id="listarJugadores"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Jugadores"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="jugadores"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Jugadores</h1>
                </div>

                <div class="col-lg-6">
                    <a class="btn btn-warning" href="<%=request.getContextPath()%>/">Agregar Nuevos Jugadores</a>
                </div>
            </div>


            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>EDAD</th>
                        <th>POSICION</th>
                        <th>CLUB</th>
                        <th>SELECCION</th>
                    </thead>
                    <%
                        for (Jugador j : listarJugadores) {
                    %>
                    <tr>
                        <td><%=j.getIdJugador()%>
                        </td>
                        <td><%=j.getNombre()%>
                        </td>
                        <td><%=j.getEdad()%>
                        </td>
                        <td><%=j.getPosicion()%>
                        </td>
                        <td><%=j.getSeleccion().getNombre()%>
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
