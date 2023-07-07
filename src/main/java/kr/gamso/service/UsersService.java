package kr.gamso.service;

import kr.gamso.dto.SaveUserDTO;

public interface UsersService {
    void insertUser(SaveUserDTO saveUserDTO);

    int selectUserId(String id);
}
