package com.furniro.furniture.services.address;

import com.furniro.furniture.dto.AddressDto;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Address;
import com.furniro.furniture.models.User;
import com.furniro.furniture.models.Ward;
import com.furniro.furniture.payload.request.AddressRequest;
import com.furniro.furniture.repositories.AddressRepository;
import com.furniro.furniture.repositories.WardRepository;
import com.furniro.furniture.services.user.UserService;
import com.furniro.furniture.services.ward.WardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImp implements AddressService<Address> {

    private UserService userService;
    private AddressRepository addressRepository;
    private WardRepository wardRepository;

    @Override
    public List<AddressDto> getAddressByUser() {
        User userID = (User) userService.getUserLogin();
        return addressRepository.getAddressByUser(userID.getUserID());
    }

    @Override
    public Address addAddress(AddressRequest addressRequest) {
        User user = (User) userService.getUserLogin();

        Ward ward = wardRepository.findById(addressRequest.getWardID())
                .orElseThrow(() -> new ResourceNotFoundException("Ward not found with ID: " + addressRequest.getWardID()));


//        Address addressFound = this.existAddress(user.getAddressList().toString());
//        System.out.println("Address Found: " + addressFound);

        Address address = new Address();

//        if(addressFound != null) {
//            addressFound.setUser(user);
//            addressFound.setAddressName(address.getAddressName());
//            addressFound.setWard(address.getWard());
//            return addressRepository.save(addressFound);
//        }

        address.setUser(user);
        address.setAddressName(addressRequest.getAddressName());
        address.setWard(ward);

        System.out.println("Address Name: " + address.getAddressName());

        return addressRepository.save(address);
    }

    @Override
    public Address existAddress(String addressName) {
        return addressRepository.existAddress(addressName);
    }
}
