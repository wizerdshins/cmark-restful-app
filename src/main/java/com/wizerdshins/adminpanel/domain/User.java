package com.wizerdshins.adminpanel.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "roles")
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "userSequence",
            sequenceName = "JPA_SEQUENCE",
            allocationSize = 1, initialValue = 4 // value was hardcoded in bd
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;
    @Column
    @NotBlank(message = "Please, enter a login")
    private String login;
    @Column
    @NotBlank(message = "Please, enter a name")
    private String name;
    @Column
    @NotBlank(message = "Please, enter a password")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {CascadeType.MERGE}
            )
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, updatable = false)}
    )
    private Set<Role> roles = new HashSet<>();

}
