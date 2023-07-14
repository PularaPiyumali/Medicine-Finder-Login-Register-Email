package com.medifinder.LoginRegisterEmail.services;

import com.medifinder.LoginRegisterEmail.entities.UserSearchData;
import com.medifinder.LoginRegisterEmail.repository.UserSearchDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserSearchDataService {

    private UserSearchDataRepository userSearchDataRepository;

    public void saveSearchData (String searchName) {
        UserSearchData searchData = new UserSearchData();
        searchData.setSearchName(searchName);
        searchData.setTimestamp(LocalDateTime.now());

        userSearchDataRepository.save(searchData);
    }

    public List<Object[]> getSearchFrequencies() {
        return userSearchDataRepository.getSearchFrequencies();
    }
}
