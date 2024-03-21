package com.auth.ProgrammingTechnology.Authorization.dal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "email")
    public String email;
    @Column(name = "password_hash")
    public String passwordHash;
    @Column(name = "refresh_token")
    public String refreshToken;
    @Column(name = "role_type")
    public String roleType;
}
