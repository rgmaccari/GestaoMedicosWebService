package interfaces;

import dto.ConsultaDTO;
import exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import model.Consulta;

import javax.naming.NamingException;
import java.util.List;

@WebService
public interface ConsultaWS {

    @WebMethod
    Consulta insert(ConsultaDTO dto) throws BusinessException, NamingException;

    @WebMethod
    List<Consulta> findAll() throws BusinessException, NamingException;

    @WebMethod
    void delete(int id) throws BusinessException, NamingException;
}
