package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.Requests.MedicineRequest;
import com.example.LoginRegisterEmail.Requests.UserRequest;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.exceptions.MedicineNotFoundException;
import com.example.LoginRegisterEmail.repository.UserRepository;
import com.example.LoginRegisterEmail.entities.User;
import com.example.LoginRegisterEmail.jwt.JwtTokenUtil;
import com.example.LoginRegisterEmail.registration.token.Confirmation;
import com.example.LoginRegisterEmail.registration.token.ConfirmationTokenService;
import com.example.LoginRegisterEmail.utils.Util;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(Util.FIND_BY_EMAIL);
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(Util.USER_NOT_FOUND_MSG, email)));

    }

    public String signUp (User user){
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = jwtTokenUtil.generateToken(user);
        Confirmation confirmationToken = new Confirmation(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Transactional
    public void enableAppUser(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        optionalUser.ifPresent(user -> {
            user.setEnabled(true);
            userRepository.save(user);
        });
    }

    public User updateUserDetails(Long userId, UserRequest updatedUser) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new MedicineNotFoundException("User not found with id: " + userId));

        BeanUtils.copyProperties(updatedUser, existingUser, getNullPropertyNames(updatedUser));

        if (updatedUser.getFirstName() != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
        }

        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setMobileNo(updatedUser.getMobileNo());
        existingUser.setEmail(updatedUser.getEmail());


        return userRepository.save(existingUser);
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
