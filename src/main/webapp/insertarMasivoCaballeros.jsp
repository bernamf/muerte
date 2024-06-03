<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar Caballeros Masivamente</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Insertar Caballeros Masivamente</h1>
        <form action="StoreMasivoCaballerosServlet" method="post" class="mt-3">
            <div class="form-group">
                <label for="caballeros">Caballeros (nombre, fuerza, experiencia, arma_id, escudo_id separados por coma)</label>
                <textarea class="form-control" id="caballeros" name="caballeros" rows="10" placeholder="Ejemplo:
Juan, 50, 60, 1, 2
Pedro, 70, 80, 2, 3
Luis, 40, 30, 3, 1" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Caballeros</button>
        </form>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
