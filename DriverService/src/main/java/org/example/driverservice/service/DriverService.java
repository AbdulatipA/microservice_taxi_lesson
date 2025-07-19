package org.example.driverservice.service;

import lombok.AllArgsConstructor;
import org.example.driverservice.Driver;
import org.example.driverservice.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;


    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getById(long id) {
        return driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public void deleteById(long id) {
        driverRepository.deleteById(id);
    }

    public Driver update(long id, Driver driver) {
        Driver updateDriver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        updateDriver.setFullName(driver.getFullName());
        updateDriver.setPassword(driver.getPassword());
        updateDriver.setStatus(driver.getStatus());

        return driverRepository.save(updateDriver);
    }

    public Driver updateStatus(long id, Boolean status) {
        Driver updateDriver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        updateDriver.setStatus(status);

        return driverRepository.save(updateDriver);
    }
}
