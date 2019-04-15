package br.com.apimhouse.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "setores")
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String description;
    private Boolean active;
    private List<Sensor> sensors;

    public Sector() {
    }

    public Sector(String description, Boolean active, List<Sensor> sensors) {
        super();
        this.description = description;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sector sector = (Sector) o;
        return Objects.equals(id, sector.id) &&
                Objects.equals(description, sector.description) &&
                Objects.equals(active, sector.active) &&
                Objects.equals(sensors, sector.sensors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, active, sensors);
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", sensors=" + sensors +
                '}';
    }
}
