package kr.gamso.repository;

import kr.gamso.dto.FindUserDTO;
import kr.gamso.dto.SaveUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<FindUserDTO> findAllUsers();

    void saveUser(SaveUserDTO saveUsersDTO);

    int selectUserId(String id);
}
