package kr.gamso.service;

import kr.gamso.dto.DuplicateCheckIdDTO;
import kr.gamso.dto.SaveUserDTO;

public interface UsersService {
    void InsertUser(SaveUserDTO saveUserDTO);
    void duplicateCheckId(DuplicateCheckIdDTO duplicateCheckIdDTO);

}
