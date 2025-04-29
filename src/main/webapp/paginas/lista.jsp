<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TODO</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav.jsp"/>
            <h1>TAREAS</h1>
            <a class="btn btn-primary btn-sm" href="ToDoAgregarServlet">NUEVA TAREA</a>
            <h2>LISTADO DE TAREAS</h2>
            <div class="table-responsive">
                <table class="table table-sm table-hover table-borderless table-primary align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th>
                            <th>DESCRIPCIO</th>
                            <th>COMPLETADO</th>
                            <th>COMANDOS</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach var="item" items="${lista}">
                            <tr class="table-primary">
                                <td>${item.getId()}</td>
                                <td>${item.getDescripcion()}</td>
                                <td>${item.getCompletada()}</td>
                                <td>
                                    <a class="btn btn-secondary btn-sm" href="ToDoActualizarServlet?id=${item.getId()}">ACTUALIZAR</a>
                                    <a class="btn btn-danger btn-sm" href="ToDoEliminarServlet?id=${item.getId()}">ELIMINAR</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>


        </div>








    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>
