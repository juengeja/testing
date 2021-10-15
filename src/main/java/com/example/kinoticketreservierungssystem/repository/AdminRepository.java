package com.example.kinoticketreservierungssystem.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.example.kinoticketreservierungssystem.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends ReactiveCosmosRepository<Admin, String> {

}