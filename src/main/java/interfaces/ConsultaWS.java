package interfaces;

import dto.ConsultaDTO;
import exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import model.Consulta;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface ConsultaWS {

    @WebMethod
    Consulta insert(ConsultaDTO dto) throws BusinessException, NamingException;

    @WebMethod
    List<Consulta> findAll() throws BusinessException, NamingException;

    @WebMethod
    void delete(int id, String motivo) throws BusinessException, NamingException, SQLException;
}
