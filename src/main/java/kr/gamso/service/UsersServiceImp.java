package kr.gamso.service;

import kr.gamso.dto.SaveUserDTO;
import kr.gamso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UsersService{
    UserRepository userRepository;
    @Autowired
    public UsersServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void insertUser(SaveUserDTO saveUserDTO) {
        userRepository.saveUser(saveUserDTO);
    }
}
