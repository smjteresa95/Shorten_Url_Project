package kr.gamso.service;

import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;

import java.util.List;

public interface UsersService {
    List<FindUserDTO> findAllUsers();
    void insertUser(SaveUserDTO saveUserDTO);

    int selectUserId(String id);
}
