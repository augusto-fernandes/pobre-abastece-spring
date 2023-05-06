package fatec.probreabastece.com.pobreabastece.controller;

import fatec.probreabastece.com.pobreabastece.model.User;
import fatec.probreabastece.com.pobreabastece.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id ){
        User user = service.findById(id);
     return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userCreated = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser( @PathVariable(name = "id") Long id, @RequestBody User user ){
        User userActual = service.findById(id);
        if(userActual != null && userActual.toString().length() > 0){
            userActual.setNome(user.getNome());
            userActual.setLocalizacao(user.getLocalizacao());
            userActual.setEmail(user.getEmail());
            userActual.setPhone(user.getPhone());
            userActual.setPassword(user.getPassword());

            User save = service.save(userActual);
            return ResponseEntity.ok(save);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
