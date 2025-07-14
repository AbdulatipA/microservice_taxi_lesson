package org.example.clientservice.controller;

import lombok.AllArgsConstructor;
import org.example.clientservice.Client;
import org.example.clientservice.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping()
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client clientSaved = clientService.create(client);
        return ResponseEntity.ok(clientSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable long id) {
        return ResponseEntity.ok(clientService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        clientService.deleteById(id);
        return ResponseEntity.ok("Пользователь удален");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateById(@PathVariable long id, @RequestBody Client client) {
        return ResponseEntity.ok(clientService.update(id, client));
    }
}
