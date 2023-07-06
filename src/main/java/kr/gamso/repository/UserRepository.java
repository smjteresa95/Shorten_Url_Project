package kr.gamso.repository;

import kr.gamso.dto.DuplicateCheckIdDTO;
import kr.gamso.dto.SaveUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    void saveUser(SaveUserDTO saveUsersDTO);

    void selectUserId(DuplicateCheckIdDTO duplicateCheckIdDTO);
}
