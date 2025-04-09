package model;

import dto.DadosCadastroMedico;

public class Medico {
    private Integer id;
    private boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Especialidade especialidade;
    private String ufEndereco;
    private String cepEndereco;
    private String logradouroEndereco;
    private Long numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;

    public Medico() {
    }

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.ativo = true;
        this.nome = dadosCadastroMedico.getNome();
        this.email = dadosCadastroMedico.getEmail();
        this.telefone = dadosCadastroMedico.getTelefone();
        this.crm = dadosCadastroMedico.getCrm();
        this.especialidade = dadosCadastroMedico.getEspecialidade();
        this.ufEndereco = dadosCadastroMedico.getEndereco().getUf();
        this.cepEndereco = dadosCadastroMedico.getEndereco().getCep();
        this.logradouroEndereco = dadosCadastroMedico.getEndereco().getLogradouro();
        this.numeroEndereco = dadosCadastroMedico.getEndereco().getNumero();
        this.complementoEndereco = dadosCadastroMedico.getEndereco().getComplemento();
        this.bairroEndereco = dadosCadastroMedico.getEndereco().getBairro();
        this.cidadeEndereco = dadosCadastroMedico.getEndereco().getCidade();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public Long getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(Long numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }
}
