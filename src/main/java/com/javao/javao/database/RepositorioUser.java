package com.javao.javao.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javao.javao.entidade.User;

public interface RepositorioUser extends JpaRepository<User,Long>{

    
}
