package com.westernach.user.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.westernach.user.accounts.model.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

}
