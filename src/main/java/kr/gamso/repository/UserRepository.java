package kr.gamso.repository;

import kr.gamso.dto.SaveUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    void saveUser(SaveUserDTO saveUsersDTO);

    int selectUserId(String id);
}
