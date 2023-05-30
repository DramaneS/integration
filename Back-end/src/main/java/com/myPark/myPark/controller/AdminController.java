package com.myPark.myPark.controller;


import com.myPark.myPark.model.Admin;
import com.myPark.myPark.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/myPark/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/listerId/{id}")
    public ResponseEntity<Admin> adminById (@PathVariable("id") Long id) {
        Admin admin = adminService.findAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @GetMapping("/lister")
    public ResponseEntity <List<Admin>> admin() {
        List<Admin> admin = adminService.findAllAdmin();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Admin> ajoutAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.addAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Admin> modifiAdmin(@RequestBody Admin admin, @PathVariable("id") Long id) {
        Admin updateAdmin = adminService.updateAdmin(admin, id);
        return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login/{telephone}&{mdp}")
    Admin login(@PathVariable("telephone") String telephone, @PathVariable("mdp") String mdp){
        return adminService.login(telephone, mdp);
    }

    @GetMapping("/allAdmin/{sup}")
    List<Admin> allAdmin(@PathVariable("sup") boolean sup){
        return adminService.allAdmin(sup);
    }
}