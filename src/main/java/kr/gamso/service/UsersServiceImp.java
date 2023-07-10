package kr.gamso.service;

import kr.gamso.dto.FindUserDTO;
import kr.gamso.dto.SaveUserDTO;
import kr.gamso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService{
    UserRepository userRepository;
    @Autowired
    public UsersServiceImp(UserRepository userRepository){
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
    public boolean selectUserId(String id) {
        int idCnt = userRepository.selectUserId(id);
        if (idCnt == 0){
            return true;
        }
        return false;
    }
}
