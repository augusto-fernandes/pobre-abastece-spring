package fatec.probreabastece.com.pobreabastece.controller;
import fatec.probreabastece.com.pobreabastece.model.User;
import fatec.probreabastece.com.pobreabastece.model.dto.UserRequestDTO;
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
    public ResponseEntity<UserRequestDTO> updateUser( @PathVariable(name = "id") Long id, @RequestBody UserRequestDTO user ){
        user.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(user), UserRequestDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
