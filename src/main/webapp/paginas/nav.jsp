<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    String correoUsuario = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("correo".equals(cookie.getName())) {
                correoUsuario = cookie.getValue();
                break;
            }
        }
    }
    request.setAttribute("correoUsuario", correoUsuario);
%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active btn-primary" aria-current="page" href="LoginServlet?exit=1"> <strong><c:out value="${correoUsuario}" default="Usuario"/></strong></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ToDoListServlet">Listado</a>
                </li>
            </ul>

        </div>
    </div>
</nav>
