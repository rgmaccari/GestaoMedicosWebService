package model;

import dto.DadosCadastroPaciente;

public class Paciente {
    private Integer id;
    private boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String ufEndereco;
    private String cepEndereco;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;

    public Paciente() {

    }
    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){
            this.ativo = true;
            this.nome = dadosCadastroPaciente.getNome();
            this.email = dadosCadastroPaciente.getEmail();
            this.telefone = dadosCadastroPaciente.getTelefone();
            this.cpf = dadosCadastroPaciente.getCpf();
            this.ufEndereco = dadosCadastroPaciente.getEndereco().getUf();
            this.cepEndereco = dadosCadastroPaciente.getEndereco().getCep();
            this.logradouroEndereco = dadosCadastroPaciente.getEndereco().getLogradouro();
            this.numeroEndereco = dadosCadastroPaciente.getEndereco().getNumero();
            this.complementoEndereco = dadosCadastroPaciente.getEndereco().getComplemento();
            this.bairroEndereco = dadosCadastroPaciente.getEndereco().getBairro();
            this.cidadeEndereco = dadosCadastroPaciente.getEndereco().getCidade();
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public boolean isAtivo() {
            return ativo;
        }
        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
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
        public String getCpf() {
            return cpf;
        }
        public void setCpf(String cpf) {
            this.cpf = cpf;
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
        public String getNumeroEndereco() {
            return numeroEndereco;
        }
        public void setNumeroEndereco(String numeroEndereco) {
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