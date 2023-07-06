package kr.gamso.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersRepository {
    void saveUser();

    void selectUserId();
}
