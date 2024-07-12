package com.example.timetracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String username;

    @Transient
    private String email;

    private String task;

    private String loginTime ;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    @JsonBackReference
    @JsonIgnoreProperties("tasks") // This will ignore the 'tasks' property when serializing the User object
    private User user;

    //many task can be assign only single user

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
