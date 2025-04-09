package services;

import exceptions.BusinessException;
import model.Consulta;
import repositories.ConsultaRepository;

import javax.naming.NamingException;
import java.util.List;

public class ConsultaService {
    private ConsultaRepository consultaRepository;

    public ConsultaService() {
        this.consultaRepository = new ConsultaRepository();
    }

    public Consulta insert(Consulta consulta) throws BusinessException, NamingException {
        try{
            return consultaRepository.insert(consulta);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao inserir consulta (service): " + e.getMessage());
        }
    }

    public void delete(int id) throws BusinessException, NamingException {
        try{
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
