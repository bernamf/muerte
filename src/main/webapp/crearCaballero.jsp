<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar Caballero</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Insertar Nuevo Caballero</h1>
        <form action="StoreCaballeroServlet" method="post" class="mt-3">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="fuerza">Fuerza</label>
                <input type="number" class="form-control" id="fuerza" name="fuerza" min="0" max="100" value="0">
            </div>
            <div class="form-group">
                <label for="experiencia">Experiencia</label>
                <input type="number" class="form-control" id="experiencia" name="experiencia" min="0" max="100" value="0">
            </div>
            <div class="form-group">
                <label for="arma_id">Arma</label>
                <select class="form-control" id="arma_id" name="arma_id" required>
                    <option value="">Seleccione un arma</option>
                    <c:forEach var="arma" items="${armas}">
                        <option value="${arma.id}">${arma.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="escudo_id">Escudo</label>
                <select class="form-control" id="escudo_id" name="escudo_id" required>
                    <option value="">Seleccione un escudo</option>
                    <c:forEach var="escudo" items="${escudos}">
                        <option value="${escudo.id}">${escudo.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Caballero</button>
        </form>
        
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
