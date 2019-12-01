package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Showroom {
    private UUID id;
    private String name;
    private String address;
    private Integer capacityInCars;


    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 256)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Showroom showroom = (Showroom) o;

        if (id != null ? !id.equals(showroom.id) : showroom.id != null) return false;
        if (name != null ? !name.equals(showroom.name) : showroom.name != null) return false;
        if (address != null ? !address.equals(showroom.address) : showroom.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "capacity_in_cars", nullable = true)
    public Integer getCapacityInCars() {
        return capacityInCars;
    }

    public void setCapacityInCars(Integer capacityInCars) {
        this.capacityInCars = capacityInCars;
    }
}
