package repositories;

import Infrastructure.ConnectionFactory;
import model.Especialidade;
import model.Medico;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {
    private static final String INSERT =
            "INSERT INTO medico (nome, email, telefone, crm, especialidade, ufEndereco, cepEndereco, " +
                    "logradouroEndereco, numeroEndereco, complementoEndereco, bairroEndereco, cidadeEndereco, ativo) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE =
            "UPDATE medico SET " +
            "nome = ?, " +
            "email = ?, " +
            "telefone = ?, " +
            "crm = ?, " +
            "especialidade = ?, " +
            "ufEndereco = ?, " +
            "cepEndereco = ?, " +
            "logradouroEndereco = ?, " +
            "numeroEndereco = ?, " +
            "complementoEndereco = ?, " +
            "bairroEndereco = ?, " +
            "cidadeEndereco = ?, " +
            "ativo = ? " +
            "WHERE id = ?";

    private static final String DELETE_BY_ID = "UPDATE medico SET ativo = false WHERE id = ?";

    private static final String FIND_ALL = "SELECT * FROM medico WHERE ativo = true ORDER BY nome ASC";

    private static final String FIND_BY_ID = "SELECT * FROM medico WHERE id = ?";

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
            preparedStatement.setString(6, medico.getUfEndereco());
            preparedStatement.setString(7, medico.getCepEndereco());
            preparedStatement.setString(8, medico.getLogradouroEndereco());
            preparedStatement.setLong(9, medico.getNumeroEndereco());
            preparedStatement.setString(10, medico.getComplementoEndereco());
            preparedStatement.setString(11, medico.getBairroEndereco());
            preparedStatement.setString(12, medico.getCidadeEndereco());
            preparedStatement.setBoolean(13, true);

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
            preparedStatement.setString(6, medico.getUfEndereco());
            preparedStatement.setString(7,medico.getCepEndereco());
            preparedStatement.setString(8, medico.getLogradouroEndereco());
            preparedStatement.setLong(9, medico.getNumeroEndereco());
            preparedStatement.setString(10, medico.getComplementoEndereco());
            preparedStatement.setString(11, medico.getBairroEndereco());
            preparedStatement.setString(12, medico.getCidadeEndereco());
            preparedStatement.setBoolean(13, medico.isAtivo());
            preparedStatement.setInt(14, medico.getId());

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
                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEmail(resultSet.getString("email"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setEspecialidade(Especialidade.valueOf(resultSet.getString("especialidade").toUpperCase()));
                medico.setUfEndereco(resultSet.getString("ufEndereco"));
                medico.setCepEndereco(resultSet.getString("cepEndereco"));
                medico.setLogradouroEndereco(resultSet.getString("logradouroEndereco"));
                medico.setNumeroEndereco(resultSet.getLong("numeroEndereco"));
                medico.setComplementoEndereco(resultSet.getString("complementoEndereco"));
                medico.setBairroEndereco(resultSet.getString("bairroEndereco"));
                medico.setCidadeEndereco(resultSet.getString("cidadeEndereco"));

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

    public void delete(Integer id) throws SQLException, NamingException {
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

    public Medico findById(Integer id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Medico medico = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                medico = new Medico();

                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEmail(resultSet.getString("email"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setEspecialidade(Especialidade.valueOf(resultSet.getString("especialidade").toUpperCase()));
                medico.setUfEndereco(resultSet.getString("ufEndereco"));
                medico.setCepEndereco(resultSet.getString("cepEndereco"));
                medico.setLogradouroEndereco(resultSet.getString("logradouroEndereco"));
                medico.setNumeroEndereco(resultSet.getLong("numeroEndereco"));
                medico.setComplementoEndereco(resultSet.getString("complementoEndereco"));
                medico.setBairroEndereco(resultSet.getString("bairroEndereco"));
                medico.setCidadeEndereco(resultSet.getString("cidadeEndereco"));
            }


        }finally{
            if(preparedStatement != null)
                preparedStatement.close();

            if(resultSet != null)
                resultSet.close();

            if(connection != null)
                connection.close();
        }
        return medico;
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