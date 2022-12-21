package com.springclass.student.dao;

import com.springclass.student.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRespository  extends JpaRepository<Address, Long> {
}
