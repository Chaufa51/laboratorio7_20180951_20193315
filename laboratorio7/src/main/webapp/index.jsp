<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Bienvenido"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value=""/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>El camino a la clasificacion  sera largo ...</h1>
                </div>
            </div>

            <div class="text-center">
                <img src="https://hiraoka.com.pe/media/mageplaza/blog/post/m/u/mundial_2026-cuando_es-donde_se_juega-_clasificatorias-_sedes_.jpg" width="1100" class="rounded" alt="...">
            </div>


        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
