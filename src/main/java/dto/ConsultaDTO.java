package dto;

import model.Medico;
import model.Paciente;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class ConsultaDTO {
    private int id;
    private Medico medico;
    private Paciente paciente;
    private Timestamp data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setIdMedico(Medico idMedico) {
        this.medico = idMedico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.paciente = idPaciente;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
}
