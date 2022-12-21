package com.springclass.student.service;

import com.springclass.student.model.Address;
import com.springclass.student.dao.AddressRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRespository addressrepo;

  public List<Address> getAllddressDetails(){
      return  addressrepo.findAll();
  }

  public  String updateaddress(Long id, Address addid){
      if (addressrepo.existsById(id)){
          Address addr =  addressrepo.findById(id).get();
          addr.setState(addid.getState());
          addr.setCity(addid.getCity());
          addr.setStreetAddress(addid.getStreetAddress());
          addr.setType(addid.getType());
          addressrepo.save(addr);
          return  "updated";
      }

      return  null;
  }

}
