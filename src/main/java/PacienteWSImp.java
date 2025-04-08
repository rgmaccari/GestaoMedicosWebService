import dto.DadosCadastroPaciente;
import exceptions.BusinessException;
import interfaces.PacienteWS;
import jakarta.jws.WebService;
import model.Paciente;
import services.PacienteService;

import java.util.List;

@WebService(endpointInterface = "interfaces.PacienteWS")
public class PacienteWSImp implements PacienteWS {
    private PacienteService pacienteService = new PacienteService();

    @Override
    public Paciente cadastrar(DadosCadastroPaciente dto) throws BusinessException {
        Paciente paciente = new Paciente(dto);
        return pacienteService.insert(paciente);
    }
    @Override
    public List<Paciente> listarTodos() throws BusinessException {
        return pacienteService.findAll();
    }
    @Override
    public Paciente buscarPorId(Integer id) throws BusinessException {
        return pacienteService.findById(id);
    }
    @Override
    public Paciente atualizar(Paciente paciente) throws BusinessException {
        return pacienteService.update(paciente);
    }

    @Override
    public void deletar(Integer id) throws BusinessException {
        pacienteService.delete(id);
    }

}