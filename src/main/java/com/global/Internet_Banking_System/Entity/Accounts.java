package com.global.Internet_Banking_System.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(value={ "user"},allowSetters =true)
public class Accounts {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private Long accountNumber;
    private Double balance;
    private Long boolNationalId;
    @ManyToOne
    @JoinColumn(name = "national_id")
    @JsonIgnore()
//    @JsonProperty("user")
    private User user;
    @OneToMany(mappedBy ="sourceAccount",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
//    @JsonIgnore
    private List<Transaction> transaction;
//    @OneToOne(mappedBy = "destinationAccount")
//    @JsonIgnore
//    private Transaction transaction1;
}
