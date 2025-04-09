package interfaces;

import dto.DadosCadastroPaciente;
import dto.ListaPacientesDTO;
import exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import model.Paciente;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface PacienteWS {
    @WebMethod
    Paciente cadastrar(DadosCadastroPaciente paciente) throws BusinessException;

    @WebMethod
     List<ListaPacientesDTO> listarTodos() throws BusinessException;

     @WebMethod
    Paciente buscarPorId(Integer id) throws BusinessException;

     @WebMethod
    Paciente atualizar(Paciente paciente) throws BusinessException, SQLException, NamingException;

     @WebMethod
    void deletar(Integer id) throws BusinessException;

}
