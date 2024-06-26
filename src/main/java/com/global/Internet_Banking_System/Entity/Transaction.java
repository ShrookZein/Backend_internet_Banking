package com.global.Internet_Banking_System.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
//    private Timestamp timestamp;
    private double amount;
//    @ManyToOne
//    @JoinColumn(name = "sourceAccount_id")
////    @JsonIgnore
//    private Accounts sourceAccount;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "destinationAccount_id")
////    @JsonIgnore
//    private Accounts destinationAccount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_account_id")
    @JsonIgnore
    private Accounts sourceAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_account_id")
    @JsonIgnore()
    private Accounts destinationAccount;
}
