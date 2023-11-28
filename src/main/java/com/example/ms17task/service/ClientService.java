package com.example.ms17task.service;


import com.example.ms17task.dto.ClientDto;
import com.example.ms17task.dto.ClientPagingDto;
import com.example.ms17task.model.onetomany.Client;
import org.springframework.data.domain.Page;

public interface ClientService {

    ClientDto findById(long id);

    ClientDto findByIdCash(long id);

    ClientDto edit(long id, ClientDto clientDto);

    Page<Client> findAll(ClientPagingDto clientPagingDto);

    ClientDto save(ClientDto clientDto);
}
