package com.ijse.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Therapist {
    @Id
    private String id;
    private String name;
    private String availability;
    private String description;
    @OneToMany(mappedBy = "therapist")
    private List<TherapySession> sessions;
    @ManyToOne
    @JoinColumn(name = "programId")
    private TherapyProgram therapyProgram;
}
