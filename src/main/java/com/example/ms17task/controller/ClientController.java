package com.example.ms17task.controller;


import com.example.ms17task.dto.ClientDto;
import com.example.ms17task.dto.ClientPagingDto;
import com.example.ms17task.model.onetomany.Client;
import com.example.ms17task.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/id/{id}")
    public ClientDto getById(@PathVariable long id, @RequestHeader String channel) {

        return clientService.findById(id);
    }


    @GetMapping("/find-all")
    public Page<Client> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int pageSize,
                                @RequestParam(required = false, defaultValue = "name") String sort) {

        return clientService.findAll(ClientPagingDto.builder().page(page).pageSize(pageSize).sort(sort).build());
    }


    @PostMapping("/save")
    public ClientDto save(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto);
    }


    @PutMapping("/edit/id/{id}")
    public ClientDto edit(@RequestBody ClientDto clientDto, @PathVariable long id) {
        return clientService.edit(id, clientDto);
    }

}
