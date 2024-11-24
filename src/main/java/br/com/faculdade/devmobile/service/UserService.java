package br.com.faculdade.devmobile.service;

import org.springframework.stereotype.Service;

import br.com.faculdade.devmobile.model.UserModel;
import br.com.faculdade.devmobile.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
}
