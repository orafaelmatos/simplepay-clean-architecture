package com.matos.curso.infrastructure.mapper;

import com.matos.curso.core.domain.TaxNumber;
import com.matos.curso.core.domain.User;
import com.matos.curso.infrastructure.dto.request.CreateUserRequest;
import com.matos.curso.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
                request.email(),
                request.password(),
                new TaxNumber(request.taxNumber()),
                request.fullname(),
                request.type()
        );
    }
    public User toUser(UserEntity userEntity) throws Exception {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                new TaxNumber(userEntity.getTaxNumber()),
                userEntity.getFullname(),
                userEntity.getType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdateAt()
        );
    }
}
