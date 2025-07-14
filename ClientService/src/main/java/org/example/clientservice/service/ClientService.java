package org.example.clientservice.service;

import lombok.AllArgsConstructor;
import org.example.clientservice.Client;
import org.example.clientservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;


    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client getById(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

    public Client update(long id, Client client) {
        Client updateClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        updateClient.setMoney(client.getMoney());
        updateClient.setPassword(client.getPassword());

        if(!client.getPhone().equals(updateClient.getPhone())) {
            updateClient.setPhone(client.getPhone());
        }

        return clientRepository.save(updateClient);
    }
}
