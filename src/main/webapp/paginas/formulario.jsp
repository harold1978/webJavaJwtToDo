
<form action="ToDoAgregarServlet.do" method="POST">
  
    <div class="mb-3">
    <label for="id" class="form-label">ID</label>
    <input class="form-control" type="text" name="id" value="${todo.getId()}" />
    </div>
    <div class="mb-3">
    <label for="nombre" class="form-label">DESCRIPCION</label>
    <input class="form-control" type="text" name="descripcion" value="${todo.getDescripcion()}" />
    </div>
    <div class="mb-3">
    <label for="clase" class="form-label">COMPLETADA</label>
    <input class="form-control" type="text" name="completada" value="${todo.getCompletada()}" />
    </div>
    <input class="btn btn-primary btn-sm" type="submit" value="PROCESAR" />
</form>
    
    <form action="dfgdfg" method="POST">
    </form> 