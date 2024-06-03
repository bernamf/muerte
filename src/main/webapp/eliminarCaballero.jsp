<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Caballeros</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Lista de Caballeros</h1>
        <form action="BuscarCaballeroServlet" method="get" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar" name="nombre">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
        </form>
        <form action="EliminarCaballerosServlet" method="get" class="mt-3">
            <div class="form-group">
                <label for="ids">Eliminar Caballeros (IDs separados por coma)</label>
                <input type="text" class="form-control" id="ids" name="ids" placeholder="1,2,3">
            </div>
            <button type="submit" class="btn btn-danger">Eliminar</button>
        </form>
        
        <!-- Mensaje de error -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">
                ${error}
            </div>
        </c:if>
        
        <table class="table table-striped mt-3">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Fuerza</th>
                    <th>Experiencia</th>
                    <th>Arma</th>
                    <th>Escudo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="caballero" items="${caballeros}">
                    <tr>
                        <td>${caballero.id}</td>
                        <td>${caballero.nombre}</td>
                        <td>${caballero.fuerza}</td>
                        <td>${caballero.experiencia}</td>
                        <td>${caballero.arma.nombre}</td>
                        <td>${caballero.escudo.nombre}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
