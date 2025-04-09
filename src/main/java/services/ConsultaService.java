package services;

import exceptions.BusinessException;
import model.Consulta;
import model.Medico;
import model.Paciente;
import repositories.ConsultaRepository;
import repositories.MedicoRepository;
import repositories.PacienteRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;

    public ConsultaService() {
        this.consultaRepository = new ConsultaRepository();
    }

    public Consulta insert(Consulta consulta) throws BusinessException, NamingException {
        LocalDateTime dataConsulta = consulta.getData().toLocalDateTime();

        if(dataConsulta.getDayOfWeek().getValue() > 6 || dataConsulta.getHour() < 7 || dataConsulta.getHour() >= 19) {
            throw new BusinessException("Consulta fora do horário de funcionamento.");
        }

        if (dataConsulta.isBefore(LocalDateTime.now().plusMinutes(30))) {
            throw new BusinessException("Consulta deve ser agendada com 30 minutos de antecedência.");
        }

        try{
            Paciente paciente = pacienteRepository.findById(consulta.getIdPaciente());
            Medico medico = medicoRepository.findById(consulta.getIdMedico());

            if (!paciente.isAtivo() || !medico.isAtivo()) {
                throw new BusinessException("Paciente ou médico inativo.");
            }

            return consultaRepository.insert(consulta);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao inserir consulta (service): " + e.getMessage());
        }
    }

    public void delete(int id, String motivo) throws BusinessException, NamingException, SQLException {
        try{
            Consulta consulta = consultaRepository.findById(id);
            LocalDateTime dataConsulta = consulta.getData().toLocalDateTime();
            if (dataConsulta.isBefore(LocalDateTime.now().plusHours(24))) {
                throw new BusinessException("Cancelamento deve ser feito com 24h de antecedência.");
            }
            consulta.setMotivoCancelamento(motivo);
            consulta.setCancelada(true);

            consultaRepository.delete(id);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao deletar consulta (service): " + e.getMessage());
        }
    }

    public List<Consulta> findAll() throws BusinessException, NamingException {
        try{
            return consultaRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao listar consultas (service): " + e.getMessage());
        }
    }
}
