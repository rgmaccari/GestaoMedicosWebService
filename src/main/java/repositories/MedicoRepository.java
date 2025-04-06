package repositories;

import Infrastructure.ConnectionFactory;
import Model.Medico;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {
    private static final String INSERT = "INSERT INTO medico (nome, email, telefone, crm, especialidade, endereceo) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE medico SET nome = ?, email = ?, telefone = ?, crm = ?, especialidade = ?, endereco = ?, ativo = ? WHERE id = ?";

    private static final String DELETE_BY_ID = "DELETE FROM medico WHERE id = ?";

    private static final String FIND_ALL = "SELECT * FROM medico";

    public Medico insert(Medico medico) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getTelefone());
            preparedStatement.setString(4, medico.getCrm());
            preparedStatement.setString(5, medico.getEspecialidade().toString());
            preparedStatement.setString(6, medico.getEndereco().toString());

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                medico.setId(resultSet.getInt(1));
            }

        }finally{
            if (preparedStatement != null)
                preparedStatement.close();

            if(resultSet != null)
                resultSet.close();

            if(connection != null)
                connection.close();
        }

        return medico;
    }


    public void update(Medico medico) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getTelefone());
            preparedStatement.setString(4, medico.getCrm());
            preparedStatement.setString(5, medico.getEspecialidade().toString());
            preparedStatement.setString(6, medico.getEndereco().toString());

        }finally{
            if(preparedStatement != null)
                preparedStatement.close();

            if(connection != null)
                connection.close();
        }
    }

    public List<Medico> findAll() throws SQLException, NamingException{
        List<Medico> listaMedicos = new ArrayList<Medico>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medico medico = new Medico();
                medico.setId(resultSet.getInt(1));
                medico.setNome(resultSet.getString(2));
                medico.setEmail(resultSet.getString(3));
                medico.setTelefone(resultSet.getString(4));
                medico.setCrm(resultSet.getString(5));
                medico.setEndereco(resultSet.getString(6));
                medico.setEspecialidade(resultSet.getString(7));
                listaMedicos.add(medico);
            }
        }finally{
            if(preparedStatement != null)
                preparedStatement.close();

            if(resultSet != null)
                resultSet.close();

            if(connection != null)
                connection.close();
        }
        return listaMedicos;
    }

    public void delete(int id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }finally {
            if(preparedStatement != null)
                preparedStatement.close();

            if(connection != null)
                connection.close();
        }

    }
}

/**
 * private int id;
 *     private String nome;
 *     private String email;
 *     private String telefone;
 *     private String crm;
 *     private Especialidade especialidade;
 *     private Endereco endereco;
 *     private boolean ativo;*/