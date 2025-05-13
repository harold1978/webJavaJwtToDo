<%-- 
    Document   : eliminar
    Created on : 29 abr 2025, 13:26:34
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ELIMINAR</title>
    </head>
    <body>
        <div class="container">
        <jsp:include page="nav.jsp"/>
        <h1>ELIMINAR LA TAREA: </h1>
        <form action="ToDoEliminarServlet.do" method="POST">
            <label class="form-label" for="id">${todo.getId()}</label>
            <input hidden="true" type="text" name="id" value="${todo.getId()}" />
            <label class="form-label" for="nombre">${todo.getDescripcion()}</label>

            <label class="form-label" for="clase">${todo.getCompletada()}</label>

            <input class="btn btn-danger btn-sm" type="submit" value="ELIMINAR" />
        </form>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    </body>
</html>
