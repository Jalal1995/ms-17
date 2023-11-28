package com.example.ms17task.service.impl;

import com.example.ms17task.dto.ClientDto;
import com.example.ms17task.dto.ClientPagingDto;
import com.example.ms17task.model.onetomany.Client;
import com.example.ms17task.repository.ClientPageAndSortingRepository;
import com.example.ms17task.repository.ClientRepository;
import com.example.ms17task.service.ClientService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientPageAndSortingRepository pageAndSortingRepository;


    private final ModelMapper modelMapper;
    private final EntityManagerFactory emf;


    //per 100k
    @Override
    //@Transactional
    @Cacheable(key = "#id", value = "findById")
    public ClientDto findById(long id) {
        return clientRepository
                .findById(id)
                .map(client -> modelMapper.map(client, ClientDto.class))
                .orElseThrow(() -> new RuntimeException("Client not found with id = " + id));
    }

    @Override
    public ClientDto findByIdCash(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();


        Client client = em.find(Client.class, 1L);

        Client client1 = em.find(Client.class, 1L);

        Client client2 = em.find(Client.class, 1L);

        //  transaction.commit();

        em.flush();

        //  em.clear();

        return modelMapper.map(client, ClientDto.class);


    }

    @Override
    @CachePut(key = "#id", value = "findById")
    public ClientDto edit(long id, ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        Optional<Client> findById = clientRepository.findById(id);
        updateClient(client, findById);
        return clientDto;
    }

    private void updateClient(Client client, Optional<Client> findById) {
        if (findById.isPresent()) {
            findById.get().setName(client.getName());
            clientRepository.save(findById.get());
        }
    }

    @Override
    @SneakyThrows
    public Page<Client> findAll(ClientPagingDto pagingDto) {

        Pageable pr = PageRequest.of(pagingDto.getPage(), pagingDto.getPageSize(), Sort.by(pagingDto.getSort()).descending());

        return pageAndSortingRepository.findAll(pr);

    }


    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);

        client.getOrders()
                .forEach(order -> {
                    order.setClient(client);
                });

        client.getCards()
                .forEach(card -> {
                    card.setClient(client);
                });

        return modelMapper.map(clientRepository.save(client), ClientDto.class);
    }

}


