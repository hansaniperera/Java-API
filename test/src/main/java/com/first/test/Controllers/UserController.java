package com.first.test.Controllers;

import com.first.test.Domain.Address;
import com.first.test.Domain.User;
import com.first.test.service.AddressService;
import com.first.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<User> createUser(@RequestBody @Validated User user){
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PostMapping(value = "/{id}/address")
    public ResponseEntity<Address> addAddressForUser(@RequestBody @Validated Address address,
                                                     @PathVariable(value = "id") Long userId){
        return ResponseEntity.ok().body(addressService.saveAddress(address, userId));
    }

    @PostMapping(value = "/{id}/address2")
    public ResponseEntity<List<Address>> addAddressForUser2(@RequestBody @Validated Address address,
                                                   @PathVariable(value = "id") Long userId){
        return ResponseEntity.ok().body(addressService.saveAddress2(address, userId));
    }

    @PutMapping(value = "/{id}/name/{name}")
    public ResponseEntity<User> updateUserName(@PathVariable(value = "name") String name,
                                               @PathVariable(value = "id") long id){
        return ResponseEntity.ok().body(userService.updateUser(name, id));
    }


}
