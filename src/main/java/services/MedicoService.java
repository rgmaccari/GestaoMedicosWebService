package services;

import dto.ListaMedicosDTO;
import exceptions.BusinessException;
import model.Medico;
import repositories.MedicoRepository;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {
    private MedicoRepository medicoRepository;

    public MedicoService(){
        medicoRepository = new MedicoRepository();
    }

    public Medico insert(Medico medico) throws BusinessException {

        if(medico.getNome() == null || medico.getNome().isEmpty() ||
            medico.getEmail() == null || medico.getEmail().isEmpty() ||
            medico.getTelefone() == null || medico.getTelefone().isEmpty() ||
            medico.getCrm() == null ||
            medico.getEspecialidade() == null){

            throw new BusinessException("Os dados pessoais do médico estão incorretos.");
        }

        if (!medico.getTelefone().matches("\\d{10,11}")) {
            throw new BusinessException("Telefone inválido.");
        }

        if(medico.getUfEndereco() == null || medico.getUfEndereco().isEmpty() ||
           medico.getCepEndereco() == null || medico.getCepEndereco().isEmpty() ||
           medico.getLogradouroEndereco() == null || medico.getLogradouroEndereco().isEmpty() ||
           medico.getCidadeEndereco() == null || medico.getCidadeEndereco().isEmpty() ||
           medico.getBairroEndereco() == null || medico.getBairroEndereco().isEmpty()){

            throw new BusinessException("Os dados do endereço estão incorretos.");
        }

        if (!medico.getUfEndereco().matches("[A-Z]{2}")) {
            throw new BusinessException("UF inválida.");
        }

        try{
            return medicoRepository.insert(medico);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao inserir medico (service).");
        }

    }

    public Medico update(Medico medico) throws BusinessException {
        if(medico.getId() == null){
            throw new BusinessException("O id do médico é obrigatório.");
        }

        if(medico.getNome() == null || medico.getNome().isEmpty() ||
           medico.getTelefone() == null || medico.getTelefone().isEmpty()){
            throw new BusinessException("Atualize os dados faltantes.");
        }

        try{
            medicoRepository.update(medico);
            return medico;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao atualizar medico (service).");
        }
    }

    public List<ListaMedicosDTO> findAll() throws BusinessException{
        try{
            List<Medico> medicos = medicoRepository.findAll();
            List<ListaMedicosDTO> listaDTO = new ArrayList<>();

            for (Medico medico : medicos) {
                ListaMedicosDTO dto = new ListaMedicosDTO();
                dto.setNome(medico.getNome());
                dto.setEmail(medico.getEmail());
                dto.setCrm(medico.getCrm());
                dto.setEspecialidade(medico.getEspecialidade());
                listaDTO.add(dto);
            }

            return listaDTO;
        } catch (NamingException e){
            e.printStackTrace();
            throw new BusinessException("Erro ao buscar médicos (service).");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) throws BusinessException{
        if(id == null){
            throw new BusinessException("O id não pode ser nulo.");
        }

        try{
            medicoRepository.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao excluir medico (service).");
        }
    }

    public Medico findById(Integer id) throws BusinessException{
        if(id == null){
            throw new BusinessException("O id não pode ser nulo.");
        }

        try{
            return medicoRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("Erro ao localizar médico (service).");
        }
    }
}