package services;

import Model.Medico;

public class MedicoService {
 private MedicoRepository medicoRepository;

 public void cadastrarMedico(Medico medico) {
     medicoRepository.salvar(medico);
 }
 public void atualizarMedico(Medico medico){
     medicoRepository.atualizar(medico);
 }
} // bom na vdd vou esperar vc macari pq eu tava fazendo o service pq tem muita regras,
//só q eu n sei se vamos fazer o crud completo pelo banco, pq dai a gente só usaria o repository?
//pq ele vai interagir com o banco ou eui estou ficandoooo loucaaaaaaaaaa
