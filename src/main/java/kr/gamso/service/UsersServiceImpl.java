package kr.gamso.service;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import kr.gamso.dto.userDTO.AddUserRequestDTO;
import kr.gamso.dto.userDTO.FindUserDTO;
import kr.gamso.dto.userDTO.SaveUserDTO;
import kr.gamso.entity.Users;
import kr.gamso.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<FindUserDTO> findAll() {
        List<Users> usersList = userRepository.findAll();
        List<FindUserDTO> userDTOList = new ArrayList<>();
        for(Users user : usersList) {
            //entity -> dto
            FindUserDTO userDTO = FindUserDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .pw(user.getPw())
                    .build();
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public void insert(SaveUserDTO saveUserDTO) {
        Users user = saveUserDTO.toEntity();
        userRepository.save(user);
    }

    @Override
    public boolean isIdDuplicate(String id) {
        Optional<Users> existingUser = userRepository.findById(id);
        return existingUser.isPresent();
    }

    @Override
    public Long save(AddUserRequestDTO dto) {
        return userRepository.save(Users.builder()
                .email(dto.getEmail())
                .pw(bCryptPasswordEncoder.encode(dto.getPw()))
                .build());
    }

}
