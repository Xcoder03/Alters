package com.springclass.student.controller;

import com.springclass.student.model.Address;
import com.springclass.student.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/vi/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping()
    public List<Address> getallstudent(){
        return  addressService.getAllddressDetails();
    }

    @PutMapping("/{id}")
    public String  updateAddresst(@PathVariable(name="id")Long id, @Valid  @RequestBody Address address){
        return addressService.updateaddress(id,address);

    }


}

