package kr.gamso.service;

import kr.gamso.dto.FindUserDTO;
import kr.gamso.dto.SaveUserDTO;

import java.util.List;

public interface UsersService {
    List<FindUserDTO> findAllUsers();
    void insertUser(SaveUserDTO saveUserDTO);

    boolean selectUserId(String id);
}
