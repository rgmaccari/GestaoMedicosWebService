package interfaces;

import dto.AtualizacaoMedicoDTO;
import dto.ListaMedicosDTO;
import model.Medico;
import dto.DadosCadastroMedico;
import exceptions.BusinessException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface MedicoWS {
    @WebMethod
    Medico insert(DadosCadastroMedico medico) throws BusinessException;

    @WebMethod
    Medico update(Integer id, AtualizacaoMedicoDTO dados) throws BusinessException;

    @WebMethod
    void delete(Integer id) throws BusinessException;

    @WebMethod
    Medico findById(Integer id) throws BusinessException;

    @WebMethod
    List<ListaMedicosDTO> findAll() throws BusinessException;
}
