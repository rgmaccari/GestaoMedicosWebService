package repositories;

import Infrastructure.ConnectionFactory;
import model.Consulta;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {
    private static final String INSERT = "INSERT INTO consulta(medico_id, paciente_id, data) VALUES(?, ?, ?)";
    private static final String DELETE = "DELETE FROM consulta WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM consulta";

    public Consulta insert(Consulta consulta) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, consulta.getIdMedico());
            preparedStatement.setInt(2, consulta.getIdPaciente());
            preparedStatement.setTimestamp(3, consulta.getData());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao inserir consulta: " + e.getMessage());
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                connection.close();
            }

            if(resultSet != null){
                resultSet.close();
            }
        }

        return consulta;
    }

    public void delete(int id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao deletar consulta: " + e.getMessage());
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                connection.close();
            }
        }
    }

    public List<Consulta> findAll() throws SQLException, NamingException {
        List<Consulta> listaConsultas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Consulta consulta = new Consulta();

                consulta.setId(resultSet.getInt("id"));
                consulta.setIdMedico(resultSet.getInt("medico_id"));
                consulta.setIdPaciente(resultSet.getInt("paciente_id"));
                consulta.setData(resultSet.getTimestamp("data"));
                listaConsultas.add(consulta);
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao buscar consultas: " + e.getMessage());
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                connection.close();
            }

            if(resultSet != null){
                resultSet.close();
            }
        }
        return listaConsultas;
    }
}

