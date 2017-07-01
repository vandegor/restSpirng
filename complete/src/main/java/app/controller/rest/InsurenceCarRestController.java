package app.controller.rest;

import app.exception.ConflictException;
import app.exception.HttpException;
import app.exception.NoContentException;
import app.model.Car;
import app.model.Insurence;
import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/insurence/car/{tablePlate}")
public class InsurenceCarRestController {

    @Autowired
    CarService insurenceService;

    @PostMapping
    /// – dodaje ubezpieczenie dla samochodu.
    public ResponseEntity postTablePlate(@PathVariable("tablePlate") String tablePlate, @RequestBody Insurence insurence) throws HttpException {
        insurenceService.getCars ().put (tablePlate, insurence.getCar ());
        Car car = insurence.getCar ();
        car.setInsurence (insurence);
        car.setPlateNumber (tablePlate);
        return ResponseEntity.status (HttpStatus.CREATED).build ();
    }

    @GetMapping
    /// – zwraca szczegóły ubezpieczenia samochodu na podstawie numeru rejestracyjnego.
    public ResponseEntity getTablePlate(@PathVariable("tablePlate") String tablePlate) throws HttpException {
        return ResponseEntity.ok (insurenceService.getCar (tablePlate).getInsurence ());
    }

    @PutMapping
    /// – modyfikuje dane ubezpieczenia. Zmianie nie może ulec numer ubezpieczenia.
    public ResponseEntity putTablePlate(@PathVariable("tablePlate") String tablePlate, @RequestBody Insurence insurence) throws HttpException {
        Car car = insurenceService.getCar (tablePlate);
        if (car.getInsurence () == null) throw new ConflictException ();
        int insurenceNumber = car.getInsurence ().getInsurenceNumber ();
        insurence.setCar (car);
        insurence.setInsurenceNumber (insurenceNumber);
        car.setInsurence (insurence);
        return ResponseEntity.ok ().build ();
    }

    @DeleteMapping
    /// – usuwa ubezpieczanie. Usunięte może być tylko ubezpieczenie o zakończonym terminie.
    public ResponseEntity deleteTablePlate(@PathVariable("tablePlate") String tablePlate) throws HttpException {
        Car car = insurenceService.getCar (tablePlate);
        Insurence insurence = car.getInsurence ();
        if (insurence != null && insurence.getInsurenceEndDateLocalDate ().isBefore (LocalDate.now ())) {
            car.setInsurence (null);
            return ResponseEntity.ok ().build ();
        } else
            throw new NoContentException ();
    }
}
