package Model;

import dto.DadosCadastroMedico;

public class Medico {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Especialidade especialidade;
    private Endereco endereco;
    private boolean ativo;

    public Medico() {
    }

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.ativo = true;
        this.nome = dadosCadastroMedico.getNome();
        this.email = dadosCadastroMedico.getEmail();
        this.telefone = dadosCadastroMedico.getTelefone();
        this.crm = dadosCadastroMedico.getCrm();
        this.especialidade = dadosCadastroMedico.getEspecialidade();
        this.endereco = dadosCadastroMedico.getEndereco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
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
