package kr.gamso.repository;

import kr.gamso.dto.FindUserByIdDTO;
import org.apache.ibatis.annotations.Mapper;

import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;

import java.util.List;

@Mapper
public interface UserRepository {
    List<FindUserDTO> findAllUsers();

    void saveUser(SaveUserDTO saveUsersDTO);

    int selectUserId(String id);

    FindUserByIdDTO findUserById(String email);

}
