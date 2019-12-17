package com.wizerdshins.adminpanel.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private Integer id;
    @Column
    private String name;

    public Role() {}

    @JoinTable(
            name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "roles_id", nullable = false,
                            updatable = false, insertable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id",
                            nullable = false, updatable = false)}
    )

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                ", name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId()) &&
                Objects.equals(getName(), role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
