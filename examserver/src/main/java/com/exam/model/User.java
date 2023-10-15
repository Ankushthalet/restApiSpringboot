package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users")
public class User {

    @Id

    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String FirstName;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled=true;



    // users many roles
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles=new HashSet<>();

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


    public User(long id, String username, String password, String firstName, String lastname, String email, String phone, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        FirstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
    }



    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
