package kr.gamso.repository;

import kr.gamso.dto.FindUserByIdDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    FindUserByIdDTO findUserById(String email);
}
