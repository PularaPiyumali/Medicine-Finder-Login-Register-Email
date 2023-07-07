package com.medifinder.LoginRegisterEmail.services;

import com.medifinder.LoginRegisterEmail.Requests.GenericRequest;
import com.medifinder.LoginRegisterEmail.entities.Generic;
import com.medifinder.LoginRegisterEmail.repository.GenericRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class GenericService implements Serializable {

    private GenericRepository genericRepository;
    public Generic addGeneric(GenericRequest genericRequest) {
        Generic generic = new Generic();
        generic.setName(genericRequest.getName());
        return genericRepository.save(generic);
    }
}
