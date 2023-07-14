package com.medifinder.LoginRegisterEmail.repository;

import com.medifinder.LoginRegisterEmail.entities.UserSearchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSearchDataRepository extends JpaRepository <UserSearchData, Long> {

    @Query("SELECT s.searchName, COUNT(s.searchName) AS frequency FROM UserSearchData s GROUP BY s.searchName ORDER BY frequency DESC")
    List<Object[]> getSearchFrequencies();
}
