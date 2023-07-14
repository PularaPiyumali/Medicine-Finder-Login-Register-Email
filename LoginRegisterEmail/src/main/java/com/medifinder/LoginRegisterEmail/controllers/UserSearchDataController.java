package com.medifinder.LoginRegisterEmail.controllers;

import com.medifinder.LoginRegisterEmail.Requests.UserSearchDataRequest;
import com.medifinder.LoginRegisterEmail.services.UserSearchDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class UserSearchDataController {

    private UserSearchDataService userSearchDataService;

    @PostMapping("/search")
    public void saveSearchData(@RequestBody UserSearchDataRequest userSearchDataRequest) {
        userSearchDataService.saveSearchData(userSearchDataRequest.getSearchName());
    }

    @GetMapping("/search-frequencies")
    public List<Object[]> getSearchFrequencies() {
        return userSearchDataService.getSearchFrequencies();
    }
}
