package kr.gamso.service;

import kr.gamso.dto.DuplicateCheckIdDTO;
import kr.gamso.dto.SaveUserDTO;

import kr.gamso.dto.FindUserDTO;
import kr.gamso.dto.SaveUserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<FindUserDTO> findAllUsers();
    void insertUser(SaveUserDTO saveUserDTO);

    boolean selectUserId(String id);
}
