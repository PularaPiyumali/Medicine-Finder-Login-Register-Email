package com.medifinder.LoginRegisterEmail.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(Confirmation token){
        confirmationTokenRepository.save(token);
    }

    public Optional<Confirmation> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
