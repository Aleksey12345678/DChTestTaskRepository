package com.dchcompany.dchtesttask.service;

import com.dchcompany.dchtesttask.dto.UserCreateEditDto;
import com.dchcompany.dchtesttask.dto.UserReadDto;
import com.dchcompany.dchtesttask.entity.Role;
import com.dchcompany.dchtesttask.entity.User;
import com.dchcompany.dchtesttask.mapper.UserCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.UserReadMapper;
import com.dchcompany.dchtesttask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;


//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//
//            public UserDetails loadUserByUsername(String username) {
//                return userRepository.findFirstByUsername(username)
//                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//            }
//        };
//    }



    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findFirstById(id)
                .map(userReadMapper::map);
    }

    public Optional<UserReadDto> findByUsername(String username) {
        return userRepository.findFirstByUsername(username)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(dto -> userCreateEditMapper.map(dto))
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
