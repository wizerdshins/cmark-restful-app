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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
                    {CascadeType.MERGE, CascadeType.PERSIST}
            )
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

}
