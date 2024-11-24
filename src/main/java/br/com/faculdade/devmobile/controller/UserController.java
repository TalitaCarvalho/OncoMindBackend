package br.com.faculdade.devmobile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.faculdade.devmobile.model.UserModel;
import br.com.faculdade.devmobile.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("usuarios")
public class UserController {

    private final UserService userService;

    @PostMapping
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user) {
        UserModel createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

}
