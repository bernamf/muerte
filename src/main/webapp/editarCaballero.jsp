<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Caballero</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Editar Caballero</h1>
        <form action="EditarCaballeroServlet" method="post" class="mt-3">
            <input type="hidden" name="id" value="${caballero.id}">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${caballero.nombre}" required>
            </div>
            <div class="form-group">
                <label for="fuerza">Fuerza</label>
                <input type="number" class="form-control" id="fuerza" name="fuerza" value="${caballero.fuerza}" min="0" max="100">
            </div>
            <div class="form-group">
                <label for="experiencia">Experiencia</label>
                <input type="number" class="form-control" id="experiencia" name="experiencia" value="${caballero.experiencia}" min="0" max="100">
            </div>
            <div class="form-group">
                <label for="arma_id">Arma</label>
                <select class="form-control" id="arma_id" name="arma_id" required>
                    <option value="1" ${caballero.arma.id == 1 ? 'selected' : ''}>Espada Larga</option>
                    <option value="2" ${caballero.arma.id == 2 ? 'selected' : ''}>Hacha de Batalla</option>
                    <option value="3" ${caballero.arma.id == 3 ? 'selected' : ''}>Lanza</option>
                    <!-- Agrega aquí más opciones según los datos en la tabla de armas -->
                </select>
            </div>
            <div class="form-group">
                <label for="escudo_id">Escudo</label>
                <select class="form-control" id="escudo_id" name="escudo_id" required>
                    <option value="1" ${caballero.escudo.id == 1 ? 'selected' : ''}>Escudo de Hierro</option>
                    <option value="2" ${caballero.escudo.id == 2 ? 'selected' : ''}>Escudo de Acero</option>
                    <option value="3" ${caballero.escudo.id == 3 ? 'selected' : ''}>Escudo de bronce</option>
                    <!-- Agrega aquí más opciones según los datos en la tabla de escudos -->
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
