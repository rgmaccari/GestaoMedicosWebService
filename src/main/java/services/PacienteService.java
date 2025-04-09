package services;

import dto.ListaPacientesDTO;
import exceptions.BusinessException;
import model.Paciente;
import repositories.PacienteRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    private PacienteRepository pacienteRepository = new PacienteRepository();

    public Paciente insert(Paciente paciente) throws BusinessException {
        if (paciente.getNome() == null || paciente.getNome().isEmpty() ||
                paciente.getEmail() == null || paciente.getEmail().isEmpty() ||
                paciente.getTelefone() == null || paciente.getTelefone().isEmpty() ||
                paciente.getCpf() == null || paciente.getCpf().isEmpty()) {

            throw new BusinessException("Os dados pessoais do paciente estão incorretos.");
        }
        if (paciente.getUfEndereco() == null || paciente.getUfEndereco().isEmpty() ||
                paciente.getCepEndereco() == null || paciente.getCepEndereco().isEmpty() ||
                paciente.getLogradouroEndereco() == null || paciente.getLogradouroEndereco().isEmpty() ||
                paciente.getCidadeEndereco() == null || paciente.getCidadeEndereco().isEmpty() ||
                paciente.getBairroEndereco() == null || paciente.getBairroEndereco().isEmpty()) {

            throw new BusinessException("Os dados do endereço estão incorretos.");
        }
        try {
            return pacienteRepository.insert(paciente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao inserir paciente (service).");
        }

    }
    public Paciente update(Paciente paciente) throws BusinessException, SQLException, NamingException {
        if (paciente.getId() == null) {
            throw new BusinessException("O id do paciente é obrigatório.");
        }

        if (paciente.getNome() == null || paciente.getNome().isEmpty() ||
                paciente.getTelefone() == null || paciente.getTelefone().isEmpty()) {
            throw new BusinessException("Atualize os dados faltantes.");
        }

        Paciente pacienteAtual = pacienteRepository.findById(paciente.getId());
        if (!pacienteAtual.getEmail().equals(paciente.getEmail())) {
            throw new BusinessException("O e-mail não pode ser alterado.");
        }
        if (!pacienteAtual.getCpf().equals(paciente.getCpf())) {
            throw new BusinessException("O CPF não pode ser alterado.");
        }

        try {
            pacienteRepository.update(paciente);
            return paciente;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao atualizar paciente (service).");
        }
    }

    public List<ListaPacientesDTO> findAll() throws BusinessException {
        try {
            return pacienteRepository.findAll();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao buscar pacientes (service).");
        }
    }
    public void delete(Integer id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("O id não pode ser nulo.");
        }

        try {
            pacienteRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao excluir paciente (service).");
        }
    }

    public Paciente findById(Integer id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("O id não pode ser nulo.");
        }
        try {
            return pacienteRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao localizar paciente (service).");
        }
    }

}