package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        
//package ConsultaDAO;

/**
 *
 * @author Hugo
 */
public class ConsultaDAO extends DAO {
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static ConsultaDAO getInstance() {
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }

// CRUD    
    public Consulta create(int id, Calendar data, int hora, String comentarios, int idAnimal, int idVet, int idTratamento, boolean terminou, Animal animal, Tratamento tratamento, Veterinario veterinario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (id, data, hora, comentarios, idAnimal, idVet, idTratamento, terminou) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, id);
            /*stmt.setDate(2, new java.sql.Date(data.getTimeInMillis()));*/
            stmt.setString(2, dateFormat.format(data.getTime()));
            stmt.setInt(3, hora);
            stmt.setString(4, comentarios);
            stmt.setInt(5, animal.getId());
            stmt.setInt(6, veterinario.getId());
            stmt.setInt(7, tratamento.getId());
            stmt.setBoolean(8, terminou);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Consulta","id"));
    }    
    
    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            Calendar d = Calendar.getInstance();
            d.setTime(dateFormat.parse(rs.getString("data")));
            consulta = new Consulta(rs.getInt("id"), d, rs.getInt("hora"), rs.getString("comentarios"), rs.getInt("idAnimal"), rs.getInt("idVet"), rs.getInt("idTratamento"), rs.getBoolean("terminou"));
        } 
        catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        catch (ParseException ex) {
             Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE,null,ex);
         } 
        return consulta;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consulta WHERE id = " + lastId("consulta","id"));
    }

    // RetrieveById
    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id = " + id);
        return (consultas.isEmpty()?null:consultas.get(0));
    }
    
    // RetrieveByIdConsulta
    public List retrieveByIdConsulta(int id) {
        return this.retrieve("SELECT * FROM consulta WHERE id = " + id);
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM consulta WHERE nome LIKE '%" + nome + "%'");
    }    
    
    // Updade
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET id=?, data=?, hora=?, comentarios=?, idAnimal=?, idVet=?, idTratamento=?, terminou=?, WHERE id=?");
            stmt.setInt(1, consulta.getId());
            stmt.setString(2, dateFormat.format(consulta.getData().getTime()));
            stmt.setInt(3, consulta.getHora());
            stmt.setString(4, consulta.getComentarios());
            stmt.setInt(5, consulta.getIdAnimal());
            stmt.setInt(6, consulta.getIdVet());
            stmt.setInt(7, consulta.getIdTratamento());
            stmt.setBoolean(8, consulta.getTerminou());
            stmt.setInt(9, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

