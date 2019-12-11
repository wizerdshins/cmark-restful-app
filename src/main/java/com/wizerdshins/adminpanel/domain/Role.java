package com.wizerdshins.adminpanel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long id;
    @Column
    private String name;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = {
//            CascadeType.MERGE, CascadeType.PERSIST
//            },
//            mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "roles_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )

    @Override
    public String toString() {
        return "Id: " + id +
                ", name: " + name;
    }

}
