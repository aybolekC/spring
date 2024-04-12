package com.aya.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String username;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private Account account;

}
