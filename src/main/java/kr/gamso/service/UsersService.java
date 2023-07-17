package kr.gamso.service;

import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;
import kr.gamso.dto.userDTO.AddUserRequestDTO;

import java.util.List;

public interface UsersService {
    List<FindUserDTO> findAll();
    void insert(SaveUserDTO saveUserDTO);

    boolean isIdDuplicate(String id);
    Long save(AddUserRequestDTO dto);
}
