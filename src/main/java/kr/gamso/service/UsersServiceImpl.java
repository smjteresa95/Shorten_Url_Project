package kr.gamso.service;

import kr.gamso.dto.DuplicateCheckIdDTO;
import kr.gamso.dto.SaveUserDTO;
import kr.gamso.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    @Override
    public void InsertUser(SaveUserDTO saveUserDTO) {
        usersRepository.saveUser();
    }

    @Override
    public void duplicateCheckId(DuplicateCheckIdDTO duplicateCheckIdDTO) {
        usersRepository.selectUserId();
    }
}
