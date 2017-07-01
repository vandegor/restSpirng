package app.service;


import app.exception.NoContentException;
import app.model.Car;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarService {
    private Map<String, Car> cars = new HashMap<> ();

    public Map<String, Car> getCars() {
        return cars;
    }


    public Car getCar(String key) throws NoContentException {
        if (key == null) return null;
        if (cars.get (key) == null) throw new NoContentException ("No Car");
        return cars.get (key);
    }
}
