package Model;

public class Medico {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Especialidade especialidade;
    private Endereco endereco;

    //teste
}

/**
 * RQF-001 Cadastro de médicos
 * O sistema deve possuir uma funcionalidade de cadastro de médicos, na qual as
 * seguintes informações deverão ser preenchidas:
 * Nome
 * E-mail
 * Telefone
 * CRM
 * Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia)
 * Endereço completo (logradouro, número, complemento, bairro)
 * Todas as informações são de preenchimento obrigatório, exceto o número e o
 * complemento do endereço.
 * */
