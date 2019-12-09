package com.wizerdshins.adminpanel.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
            },
            mappedBy = "roles")
    private Set<User> users = new HashSet<>();


//    @Override
//    public String toString() {
//        return String.valueOf(id);
//    }
}