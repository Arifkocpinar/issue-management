package com.arifkoc.issuemanagement.service;

import com.arifkoc.issuemanagement.Entity.User;
import com.arifkoc.issuemanagement.dto.UserDto;
import com.arifkoc.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
