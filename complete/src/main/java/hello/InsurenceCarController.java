package hello;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurence/car/{tablePlate}")
public class InsurenceCarController {
    @PostMapping
    /// – dodaje ubezpieczenie dla samochodu.
    public String postTablePlate(@PathVariable("tablePlate") String tablePlate) {
        return "postTablePlate";
    }

    @GetMapping
    /// – zwraca szczegóły ubezpieczenia samochodu na podstawie numeru rejestracyjnego.
    public String getTablePlate(@PathVariable("tablePlate") String tablePlate) {
        return "getTablePlate" + tablePlate;
    }

    @PutMapping
    /// – modyfikuje dane ubezpieczenia. Zmianie nie może ulec numer ubezpieczenia.
    public String putTablePlate(@PathVariable("tablePlate") String tablePlate) {
        return "putTablePlate";
    }

    @DeleteMapping
    /// – usuwa ubezpieczanie. Usunięte może być tylko ubezpieczenie o zakończonym terminie.
    public String deleteTablePlate(@PathVariable("tablePlate") String tablePlate) {
        return "putTablePlate";
    }


}
