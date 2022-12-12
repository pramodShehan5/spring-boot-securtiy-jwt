package com.pramod.demo.dao;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {
    public abstract UserDetails findByUserName(String userName);
}
