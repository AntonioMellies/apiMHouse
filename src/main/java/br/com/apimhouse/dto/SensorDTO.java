package br.com.apimhouse.dto;

import br.com.apimhouse.domain.Sensor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class SensorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String description;

    public SensorDTO() {
    }

    public SensorDTO(Sensor sensor) {
        id = sensor.getId();
        description = sensor.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
