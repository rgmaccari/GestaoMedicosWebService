package model;

import dto.ConsultaDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private int idPaciente;
    private int idMedico;
    private Timestamp data;
    private String motivoCancelamento;
    private boolean cancelada;

    public Consulta(){

    }

    public Consulta(ConsultaDTO dto) {
        this.id = dto.getId();
        this.idMedico = dto.getMedico().getId();
        this.idPaciente = dto.getPaciente().getId();
        this.data = dto.getData();
        this.motivoCancelamento = "";
        this.cancelada = false;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
}