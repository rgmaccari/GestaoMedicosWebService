import dto.ConsultaDTO;
import exceptions.BusinessException;
import interfaces.ConsultaWS;
import jakarta.jws.WebService;
import model.Consulta;
import services.ConsultaService;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "interfaces.ConsultaWS")
public class ConsultaWSImp implements ConsultaWS {
    @Override
    public Consulta insert(ConsultaDTO dto) throws BusinessException, NamingException {
        Consulta consulta = new Consulta();
        ConsultaService consultaService = new ConsultaService();
        return consultaService.insert(consulta);
    }

    @Override
    public List<Consulta> findAll() throws BusinessException, NamingException {
        ConsultaService consultaService = new ConsultaService();
        return consultaService.findAll();
    }

    @Override
    public void delete(int id) throws BusinessException, NamingException {
        ConsultaService consultaService = new ConsultaService();
        consultaService.delete(id);
    }
}
