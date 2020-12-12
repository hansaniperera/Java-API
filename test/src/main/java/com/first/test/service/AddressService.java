package com.first.test.service;

import com.first.test.Domain.Address;

import java.util.List;

public interface AddressService {

    Address getAddress(Long id);

    Address saveAddress(Address address, Long userId);

    List<Address> saveAddress2(Address address, Long userId);
}
