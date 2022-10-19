package com.javao.javao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javao.javao.database.RepositorioUser;
import com.javao.javao.entidade.User;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", maxAge = 3600)
// @CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private RepositorioUser repositorio;
    //PEGA POR ID
    @GetMapping("user/{id}")
    public User getById(@PathVariable(value = "id") Long id) {
        return repositorio.findById(id).get();
    }
    //PEGA TODOS OS USUARIOS
    @GetMapping("/user")
    public List<User> get() {
        return repositorio.findAll();
    }
    //ADICIONA UM USUARIO
    @PostMapping("/user")
    public void post(@RequestBody User user) {
        repositorio.save(user);
    }
    //MODIFICA USUARIO POR ID
    @PutMapping("/user/{id}")
    public void update(@PathVariable(value = "id") Long id, @RequestBody User user){
            User update = repositorio.findById(id).get();
            update.setNome(user.getNome());
            update.setSobrenome(user.getSobrenome());
            update.setIdade(user.getIdade());
            update.setProfissao(user.getProfissao());
                repositorio.save(update);
           // return repositorio.findById(id).get();
        }
    //DELETA O USUARIO
    @DeleteMapping("/user/{id}") 
    public void delete(@PathVariable Long id) {
        User user = repositorio.getReferenceById(id);
        repositorio.delete(user);
    }
}
