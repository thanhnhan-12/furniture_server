package com.furniro.furniture.services.address;

import com.furniro.furniture.dto.AddressDto;
import com.furniro.furniture.payload.request.AddressRequest;

import java.util.List;

public interface AddressService<A> {

    List<AddressDto> getAddressByUser();

    A addAddress(AddressRequest addressRequest);

    A existAddress(String addressName);

}
