package com.myPark.myPark.service;


import com.myPark.myPark.model.Admin;
import com.myPark.myPark.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> findAllAdmin() {
        return adminRepository.findAll();
    }

    public Admin updateAdmin(Admin admin, Long id) {
        Admin moAdmin = adminRepository.findById(id).get();
        moAdmin.setNom(admin.getNom());
        moAdmin.setPrenom(admin.getPrenom());
        moAdmin.setTelephone(admin.getTelephone());
        moAdmin.setMdp(admin.getMdp());
        moAdmin.setNomUtilisateur(admin.getNomUtilisateur());

        return adminRepository.save(moAdmin);
    }

    public Admin findAdminById(Long id){
        return adminRepository.findById(id).get();
    }

    @Transactional
    public void deleteAdmin(Long id) {
        Admin admin = adminRepository.getById(id);
        admin.setSupprimer(true);
    }

    public Admin login(String telephone, String mdp){
        Optional<Admin> admin = adminRepository.findAdminByTelephoneAndMdp(telephone, mdp);
        if (admin.isEmpty()){
            return null;
            //throw new InvalidEntityException("Login ou mot de passe incorrect", ErrorCode.ADMIN_AUTHENTICATION_EXCEPTION);
        }
        return admin.get();
    }

    public List<Admin> allAdmin(boolean sup){
        return adminRepository.findAdminBySupprimer(sup);
    }
}

