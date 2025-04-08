package interfaces;

import dto.DadosCadastroPaciente;
import exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import model.Paciente;

import java.util.List;

@WebService
public interface PacienteWS {
    @WebMethod
    Paciente cadastrar(DadosCadastroPaciente paciente) throws BusinessException;

    @WebMethod
     List<Paciente> listarTodos() throws BusinessException;

     @WebMethod
    Paciente buscarPorId(Integer id) throws BusinessException;

     @WebMethod
    Paciente atualizar(Paciente paciente) throws BusinessException;

     @WebMethod
    void deletar(Integer id) throws BusinessException;

}
