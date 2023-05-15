package fatec.probreabastece.com.pobreabastece.controller;
import fatec.probreabastece.com.pobreabastece.model.User;
import fatec.probreabastece.com.pobreabastece.model.dto.UserResponseDTO;
import fatec.probreabastece.com.pobreabastece.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    ModelMapper mapper;

    @GetMapping
    ResponseEntity<List<UserResponseDTO >> findAll(){
        List<UserResponseDTO> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id ){
        return ResponseEntity.ok().body((mapper.map(service.findById(id),UserResponseDTO.class)));
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
