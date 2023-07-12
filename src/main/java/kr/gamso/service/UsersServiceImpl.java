package kr.gamso.service;

import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;
import kr.gamso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    UserRepository userRepository;
    @Autowired
    public UsersServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<FindUserDTO> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public void insertUser(SaveUserDTO saveUserDTO) {
        userRepository.saveUser(saveUserDTO);
    }

    @Override
    public int selectUserId(String id) {
        return userRepository.selectUserId(id);
    }
}
