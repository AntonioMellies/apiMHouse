package br.com.apimhouse.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "sensors")
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String description;
    private String lastState;
    private Sector sector;

    public Sensor() {
    }

    public Sensor(String id, String description) {
        super();
        this.id = id;
        this.description = description;
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

    public String getLastState() {
        return lastState;
    }

    public void setLastState(String lastState) {
        this.lastState = lastState;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) &&
                Objects.equals(description, sensor.description) &&
                Objects.equals(lastState, sensor.lastState) &&
                Objects.equals(sector, sensor.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, lastState, sector);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", lastState='" + lastState + '\'' +
                ", sector=" + sector +
                '}';
    }
}
