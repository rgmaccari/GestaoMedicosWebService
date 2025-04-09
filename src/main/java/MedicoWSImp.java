import dto.AtualizacaoMedicoDTO;
import dto.DadosCadastroMedico;
import dto.ListaMedicosDTO;
import exceptions.BusinessException;
import interfaces.MedicoWS;
import jakarta.jws.WebService;
import model.Medico;
import services.MedicoService;

import java.util.List;

@WebService(endpointInterface = "interfaces.MedicoWS")
public class MedicoWSImp implements MedicoWS {

    @Override
    public Medico insert(DadosCadastroMedico medicoDTO) throws BusinessException {
        MedicoService service = new MedicoService();
        Medico medico = new Medico(medicoDTO);
        return service.insert(medico);
    }

    @Override
    public Medico update(Integer id, AtualizacaoMedicoDTO dados) throws BusinessException {
        MedicoService service = new MedicoService();
        return service.update(id, dados);
    }

    @Override
    public void delete(Integer id) throws BusinessException {
        MedicoService service = new MedicoService();
        service.delete(id);
    }

    @Override
    public Medico findById(Integer id) throws BusinessException {
        MedicoService service = new MedicoService();
        return service.findById(id);
    }

    @Override
    public List<ListaMedicosDTO> findAll() throws BusinessException {
        MedicoService service = new MedicoService();
        return service.findAll();
    }
}
