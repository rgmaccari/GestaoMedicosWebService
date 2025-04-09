package repositories;

import Infrastructure.ConnectionFactory;
import dto.ListaPacientesDTO;
import model.Paciente;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    private static final String INSERT =
            "INSERT INTO paciente (nome, email, telefone, cpf, ufEndereco, cepEndereco, " +
                    "logradouroEndereco, numeroEndereco, complementoEndereco, bairroEndereco, cidadeEndereco, ativo) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE =
            "UPDATE paciente SET nome = ?, telefone = ?, ufEndereco = ?, cepEndereco = ?, " +
                    "logradouroEndereco = ?, numeroEndereco = ?, complementoEndereco = ?, bairroEndereco = ?, cidadeEndereco = ? " +
                    "WHERE id = ?";

    private static final String DELETE_BY_ID = "UPDATE paciente SET ativo = false WHERE id = ?";

    private static final String FIND_ALL = "SELECT * FROM paciente WHERE ativo = true ORDER BY nome ASC";

    private static final String FIND_BY_ID = "SELECT * FROM paciente WHERE id = ?";

    public Paciente insert(Paciente paciente) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getTelefone());
            preparedStatement.setString(4, paciente.getCpf());
            preparedStatement.setString(5, paciente.getUfEndereco());
            preparedStatement.setString(6, paciente.getCepEndereco());
            preparedStatement.setString(7, paciente.getLogradouroEndereco());
            preparedStatement.setLong(8, paciente.getNumeroEndereco());
            preparedStatement.setString(9, paciente.getComplementoEndereco());
            preparedStatement.setString(10, paciente.getBairroEndereco());
            preparedStatement.setString(11, paciente.getCidadeEndereco());
            preparedStatement.setBoolean(12, true);

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                paciente.setId(resultSet.getInt(1));
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return paciente;
    }


    public void update(Paciente paciente) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getTelefone());
            preparedStatement.setString(3, paciente.getUfEndereco());
            preparedStatement.setString(4, paciente.getCepEndereco());
            preparedStatement.setString(5, paciente.getLogradouroEndereco());
            preparedStatement.setLong(6, paciente.getNumeroEndereco());
            preparedStatement.setString(7, paciente.getComplementoEndereco());
            preparedStatement.setString(8, paciente.getBairroEndereco());
            preparedStatement.setString(9, paciente.getCidadeEndereco());
            preparedStatement.setInt(10, paciente.getId());

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }


    public void delete(Integer id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    public List<ListaPacientesDTO> findAll() throws SQLException, NamingException {
        List<ListaPacientesDTO> pacientes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ListaPacientesDTO paciente = new ListaPacientesDTO();
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setAtivo(resultSet.getBoolean("ativo"));

                pacientes.add(paciente);
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

        return pacientes;
    }


    public Paciente findById(Integer id) throws SQLException, NamingException {
        Paciente paciente = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                paciente = new Paciente();
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setUfEndereco(resultSet.getString("ufEndereco"));
                paciente.setCepEndereco(resultSet.getString("cepEndereco"));
                paciente.setLogradouroEndereco(resultSet.getString("logradouroEndereco"));
                paciente.setNumeroEndereco(resultSet.getLong("numeroEndereco"));
                paciente.setComplementoEndereco(resultSet.getString("complementoEndereco"));
                paciente.setBairroEndereco(resultSet.getString("bairroEndereco"));
                paciente.setCidadeEndereco(resultSet.getString("cidadeEndereco"));
                paciente.setAtivo(resultSet.getBoolean("ativo"));
            }
        }finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();

        }
        return paciente;
    }
}
