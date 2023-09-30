package com.furniro.furniture.controllers;

import com.furniro.furniture.models.Address;
import com.furniro.furniture.payload.request.AddressRequest;
import com.furniro.furniture.services.address.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/address")
@AllArgsConstructor
public class AddressController {

    private AddressService<Address> addressService;

    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@Valid @RequestBody AddressRequest addressRequest) {
        System.out.println("Address Name: " + addressRequest.getAddressName());
        System.out.println("Address UserID: " + addressRequest.getUserID());
        System.out.println("Address WardID: " + addressRequest.getWardID());
        return ResponseEntity.ok(addressService.addAddress(addressRequest));
    }

}
