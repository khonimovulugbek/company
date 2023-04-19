package com.company.repository;

import com.company.entity.Address;
import org.springframework.data.jpa.repository.*;

public interface AddressRepository extends JpaRepository<Address, Long> {
}