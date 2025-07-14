package org.example.driverservice.controller;


import lombok.AllArgsConstructor;
import org.example.driverservice.Driver;
import org.example.driverservice.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@AllArgsConstructor
public class DriverController {
    private final DriverService driverService;


    @PostMapping()
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        Driver clientSaved = driverService.create(driver);
        return ResponseEntity.ok(clientSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getById(@PathVariable long id) {
        return ResponseEntity.ok(driverService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Driver>> getAll() {
        return ResponseEntity.ok(driverService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        driverService.deleteById(id);
        return ResponseEntity.ok("Пользователь удален");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateById(@PathVariable long id, @RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.update(id, driver));
    }
}
