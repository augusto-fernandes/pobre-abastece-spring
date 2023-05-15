package fatec.probreabastece.com.pobreabastece.service;

import fatec.probreabastece.com.pobreabastece.model.User;
import fatec.probreabastece.com.pobreabastece.model.dto.UserRequestDTO;
import fatec.probreabastece.com.pobreabastece.model.dto.UserResponseDTO;
import fatec.probreabastece.com.pobreabastece.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    ModelMapper mapper;

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public List<UserResponseDTO> findAll() {
        logger.info("Find All!");

        List<User> result = repository.findAll();
        List<UserResponseDTO> dto = result.stream().map(UserResponseDTO::new).toList();
        return dto;
    }

    public User findById(Long id) {
        logger.info("Find One by id!");

        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User save(User user) {
        logger.info("Save!");

        return repository.save(user);
    }

    public User update(UserRequestDTO user){
        logger.info("Update!");
        return repository.save(mapper.map(user, User.class));
    }
    public void delete(Long id) {
        logger.info("Delete!");

        repository.deleteById(id);
    }
}
