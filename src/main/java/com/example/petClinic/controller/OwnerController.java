package com.example.petClinic.controller;

import com.example.petClinic.model.Owner;
import com.example.petClinic.repository.OwnerRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner){
        return ownerRepository.save(owner);
    }

    @GetMapping("{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id){
        Owner owner = ownerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Owner not exist with id: " + id));
    return ResponseEntity.ok(owner);
    }

    @PutMapping("{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody Owner ownerDetails){
        Owner updateOwner = ownerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Owner not exist with id: " + id));

        updateOwner.setName(ownerDetails.getName());
        updateOwner.setSurname(ownerDetails.getSurname());
        updateOwner.setCity(ownerDetails.getCity());
        updateOwner.setAddress(ownerDetails.getAddress());
        updateOwner.setEmail(ownerDetails.getEmail());
        updateOwner.setTelephone(ownerDetails.getTelephone());

        ownerRepository.save(updateOwner);

        return ResponseEntity.ok(updateOwner);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable long id){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Owner not exist with id: " + id));

        ownerRepository.delete(owner);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
