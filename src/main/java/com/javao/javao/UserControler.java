package com.javao.javao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javao.javao.database.RepositorioUser;
import com.javao.javao.entidade.User;

@RestController
@RequestMapping("/user")
public class UserControler {
    
    @Autowired
    private RepositorioUser repositorio;


    @GetMapping
    public List<User> listar(){
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody User user){
    repositorio.save(user);
    }

    @PutMapping
    public void alterar(@RequestBody User user){
        if (user.getId() > 0)
        repositorio.save(user);
        }

    @DeleteMapping
    public void excluir(@RequestBody User user){
        repositorio.delete(user);
    }
}
