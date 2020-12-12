package com.first.test.service.impl;

import com.first.test.Domain.Address;
import com.first.test.Domain.User;
import com.first.test.persister.AddressPersister;
import com.first.test.persister.UserPersister;
import com.first.test.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressPersister addressPersister;

    @Autowired
    UserPersister userPersister;

    public Address getAddress(Long id) {
        return addressPersister.findById(id).get();
    }

    public Address saveAddress(Address address, Long userId) {
        User user = userPersister.findById(userId).get();
        address.setUser(user);
        return addressPersister.save(address);
    }

    @Transactional
    public List<Address> saveAddress2(Address address, Long userId) {
        User user = userPersister.findById(userId).get();
        address.setUser(user);
        user.getAddress().add(address);
        user = userPersister.save(user);
        return user.getAddress();
    }
}
