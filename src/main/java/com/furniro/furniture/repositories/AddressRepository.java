package com.furniro.furniture.repositories;

import com.furniro.furniture.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "Select Ad.addressid as addressID, Ad.wardid as wardID, Ad.address_name as addressName " +
            "from address as Ad " +
            "where Ad.address_name = :addressName ", nativeQuery = true)
    Address existAddress(@Param("addressName") String addressName);

}
