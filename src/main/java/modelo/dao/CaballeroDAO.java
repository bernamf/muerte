package modelo.dao;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Caballero;
import modelo.bean.Escudo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaballeroDAO {
    private Conector conector;

    public CaballeroDAO() {
        conector = new Conector();
    }

    

    public Caballero obtenerCaballeroPorId(int id) {
        Caballero caballero = null;
        String query = "SELECT * FROM caballeros WHERE id = ?";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int fuerza = rs.getInt("fuerza");
                    int experiencia = rs.getInt("experiencia");
                    int armaId = rs.getInt("arma_id");
                    int escudoId = rs.getInt("escudo_id");
                    
                    Arma arma = getArmaById(conn, armaId);
                    Escudo escudo = getEscudoById(conn, escudoId);

                    caballero = new Caballero(id, nombre, fuerza, experiencia, arma, escudo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return caballero;
    }

   


    public void eliminarCaballero(int id) throws SQLException {
        String queryLuchas = "DELETE FROM luchas WHERE caballero1_id = ? OR caballero2_id = ?";
        String queryCaballeros = "DELETE FROM caballeros WHERE id = ?";

        try (Connection conn = conector.getCon()) {
            conn.setAutoCommit(false); 

            try (PreparedStatement stmtLuchas = conn.prepareStatement(queryLuchas);
                 PreparedStatement stmtCaballeros = conn.prepareStatement(queryCaballeros)) {
                
                stmtLuchas.setInt(1, id);
                stmtLuchas.setInt(2, id);
                stmtLuchas.executeUpdate();

                stmtCaballeros.setInt(1, id);
                stmtCaballeros.executeUpdate();

                conn.commit(); 
            } catch (SQLException e) {
                conn.rollback(); 
                throw e;
            }
        }
    }

    public void actualizarCaballero(Caballero caballero) throws SQLException {
        String query = "UPDATE caballeros SET nombre = ?, fuerza = ?, experiencia = ?, arma_id = ?, escudo_id = ? WHERE id = ?";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, caballero.getNombre());
            stmt.setInt(2, caballero.getFuerza());
            stmt.setInt(3, caballero.getExperiencia());
            stmt.setInt(4, caballero.getArma().getId());
            stmt.setInt(5, caballero.getEscudo().getId());
            stmt.setInt(6, caballero.getId());
            stmt.executeUpdate();
        }
    }
    
    

    public void insertCaballero(Caballero caballero) throws SQLException {
        String query = "INSERT INTO caballeros (nombre, fuerza, experiencia, arma_id, escudo_id) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, caballero.getNombre());
            stmt.setInt(2, caballero.getFuerza());
            stmt.setInt(3, caballero.getExperiencia());
            stmt.setInt(4, caballero.getArma().getId());
            stmt.setInt(5, caballero.getEscudo().getId());
            stmt.executeUpdate();
        }
    }
    
    public void insertCaballeros(ArrayList<Caballero> caballeros) throws SQLException {
        String query = "INSERT INTO caballeros (nombre, fuerza, experiencia, arma_id, escudo_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            for (Caballero caballero : caballeros) {
                stmt.setString(1, caballero.getNombre());
                stmt.setInt(2, caballero.getFuerza());
                stmt.setInt(3, caballero.getExperiencia());
                stmt.setInt(4, caballero.getArma().getId());
                stmt.setInt(5, caballero.getEscudo().getId());
                stmt.addBatch();
            }

            stmt.executeBatch();
        }
    }
    

    public ArrayList<Caballero> getAllCaballeros() {
        ArrayList<Caballero> caballeros = new ArrayList<>();
        String query = "SELECT * FROM caballeros";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int fuerza = rs.getInt("fuerza");
                int experiencia = rs.getInt("experiencia");
                int armaId = rs.getInt("arma_id");
                int escudoId = rs.getInt("escudo_id");
                
                Arma arma = getArmaById(conn, armaId);
                Escudo escudo = getEscudoById(conn, escudoId);

                Caballero caballero = new Caballero(id, nombre, fuerza, experiencia, arma, escudo);
                caballeros.add(caballero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return caballeros;
    }

    public Arma getArmaById(Connection conn, int armaId) {
        Arma arma = null;
        String query = "SELECT * FROM armas WHERE id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, armaId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    arma = new Arma(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("capacidad_danio"),
                        rs.getString("foto")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return arma;
    }

    public Escudo getEscudoById(Connection conn, int escudoId) {
        Escudo escudo = null;
        String query = "SELECT * FROM escudos WHERE id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, escudoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    escudo = new Escudo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("capacidad_defensa")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return escudo;
    }
    
    public ArrayList<Arma> getAllArmas() {
        ArrayList<Arma> armas = new ArrayList<>();
        String query = "SELECT * FROM armas";

        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Arma arma = new Arma(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("capacidad_danio"),
                    rs.getString("foto")
                );
                armas.add(arma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return armas;
    }

    public ArrayList<Escudo> getAllEscudos() {
        ArrayList<Escudo> escudos = new ArrayList<>();
        String query = "SELECT * FROM escudos";

        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Escudo escudo = new Escudo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("capacidad_defensa")
                );
                escudos.add(escudo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escudos;
    }
    
    
    public ArrayList<Caballero> buscarCaballerosPorNombre(String nombre) {
        ArrayList<Caballero> caballeros = new ArrayList<>();
        String query = "SELECT * FROM caballeros WHERE nombre LIKE ?";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + nombre + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombreCaballero = rs.getString("nombre");
                    int fuerza = rs.getInt("fuerza");
                    int experiencia = rs.getInt("experiencia");
                    int armaId = rs.getInt("arma_id");
                    int escudoId = rs.getInt("escudo_id");
                    
                    Arma arma = getArmaById(conn, armaId);
                    Escudo escudo = getEscudoById(conn, escudoId);

                    Caballero caballero = new Caballero(id, nombreCaballero, fuerza, experiencia, arma, escudo);
                    caballeros.add(caballero);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return caballeros;
    }

}
