package app.controller.rest;

import app.exception.ConflictException;
import app.exception.HttpException;
import app.model.Car;
import app.model.Insurence;
import app.model.Repair;
import app.model.RepairStatus;
import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/service/car/{tablePlate}")
public class ServiceCarRestController {
    @Autowired
    CarService insurenceService;

    @PostMapping
    // – wstawia samochód do naprawy.
    // Na podstawie numeru rejestracyjnego następuje sprawdzenie czy samochód posiada aktualne ubezpieczenie,
    // jeśli nie to nie jest przyjmowany.
    public ResponseEntity postTablePlate(@PathVariable("tablePlate") String tablePlate, @RequestBody Repair repair)
            throws HttpException {
        Car car = insurenceService.getCar (tablePlate);
        if (car.getRepair () != null) throw new ConflictException ();
        Insurence insurence = car.getInsurence ();
        if (insurence != null && insurence.getInsurenceEndDateLocalDate ().compareTo (LocalDate.now ()) >= 0
                && (insurence.getDateOfSigningLocalDate ().compareTo (LocalDate.now ()) <= 0)) {
            repair.setCar (car);
            RepairStatus repairStatus = new RepairStatus ();
            repairStatus.setCurrentStatus ("ACCEPTED");
            repairStatus.setStatusHistory (new ArrayList<> (Arrays.asList (repairStatus.getCurrentStatus ())));
            repairStatus.getStatusHistory ();
            repair.setRepairStatus (repairStatus);
            repair.setRepairStartDateLocalDate (LocalDate.now ());
            car.setRepair (repair);
            return ResponseEntity.status (HttpStatus.CREATED).body (repair);
        }
        throw new ConflictException ();
    }

    @PatchMapping
    // – aktualizacja naprawy w zakresie stanu i opisu.
    // Odpowiedzią jest pełny JSON ze zaktualizowanym opisem naprawy.
    // W przypadku zamknięcia naprawy aktualizowany jest stan ubezpieczenia (dodanie nowego wpisu w historii).
    public ResponseEntity patchTablePlate(@PathVariable("tablePlate") String tablePlate, @RequestBody Repair repair)
            throws HttpException {
        Car car = insurenceService.getCar (tablePlate);
        Repair currentRepair = car.getRepair ();
        String descriptin = repair.getDescription ();
        RepairStatus repairStatus = repair.getRepairStatus ();
        if (currentRepair != null) {
            if (descriptin != null) {
                currentRepair.setDescription (descriptin);
            }
            if (repairStatus != null && repairStatus.getCurrentStatus () != null) {
                RepairStatus currentRepairStatus = currentRepair.getRepairStatus ();
                currentRepairStatus.getStatusHistory ().add (repairStatus.getCurrentStatus ());
                currentRepairStatus.setCurrentStatus (repairStatus.getCurrentStatus ());
            }
            return ResponseEntity.ok (currentRepair);
        }
        throw new ConflictException ();
    }
}
