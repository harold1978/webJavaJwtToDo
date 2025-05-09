<%-- 
    Document   : login
    Created on : 5 may 2025, 13:58:27
    Author     : Administrator
--%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <h1>Inicia Sesión</h1>
        
        <form action="LoginServlet" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th colspan="2" class="text-center">LOGIN</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>CORREO:</td>
                        <td><input type="text" name="correo" value="" /></td>
                    </tr>
                    <tr>
                        <td>CONTRASEÑA:</td>
                        <td><input type="text" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="LOGIN" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>
        <p class="bg-danger">${error==1?"error generado":""}</p>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>

    </body>
</html>
