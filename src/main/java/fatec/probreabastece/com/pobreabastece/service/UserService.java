package fatec.probreabastece.com.pobreabastece.service;

import fatec.probreabastece.com.pobreabastece.model.User;
import fatec.probreabastece.com.pobreabastece.model.dto.UserResponseDTO;
import fatec.probreabastece.com.pobreabastece.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserResponseDTO> findAll() {
        List<User> result = repository.findAll();
        List<UserResponseDTO> dto = result.stream().map(UserResponseDTO::new).toList();
        return dto;
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
