package kr.gamso.repository;

import kr.gamso.dto.FindUserByIdDTO;
import kr.gamso.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import kr.gamso.dto.userDTO.FindUserDTO;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    List<Users> findAll();

    Long save(Users user);

    Optional<Users> findById(String id);

    Optional<Users> findByEmail(String email);

}
