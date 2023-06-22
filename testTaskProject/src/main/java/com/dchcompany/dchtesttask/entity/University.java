package com.dchcompany.dchtesttask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    private String address;
    private String email;
    private String phone;
    @Builder.Default
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List <Student> students=new ArrayList<>();
}
