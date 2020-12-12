package com.first.test.persister;

import com.first.test.Domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressPersister extends JpaRepository<Address, Long> {
}
