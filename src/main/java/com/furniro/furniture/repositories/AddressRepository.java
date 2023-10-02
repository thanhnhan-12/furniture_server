package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.AddressDto;
import com.furniro.furniture.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "Select Ad.addressid as addressID, Ad.wardid as wardID, Ad.address_name as addressName " +
            "from address as Ad " +
            "where Ad.address_name = :addressName ", nativeQuery = true)
    Address existAddress(@Param("addressName") String addressName);

    @Query(value = "Select Ad.*, Pro.province_name as provinceName, Dis.district_name as districtName, War.ward_name as wardName\n" +
            "From address as Ad, province as Pro, district as Dis, ward as War\n" +
            "Where Pro.provinceid = Dis.provinceid and Dis.districtid = War.wardid \n" +
            "\t  and Ad.wardid = War.wardid and Ad.userid = :userID", nativeQuery = true)
    List<AddressDto> getAddressByUser(@Param("userID") int userID);

}
