package model;

import dto.ConsultaDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private int idPaciente;
    private int idMedico;
    private Timestamp data;

    public Consulta(){

    }

    public Consulta(ConsultaDTO dto) {
        this.id = dto.getId();
        this.idMedico = dto.getMedico().getId();
        this.idPaciente = dto.getPaciente().getId();
        this.data = dto.getData();
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