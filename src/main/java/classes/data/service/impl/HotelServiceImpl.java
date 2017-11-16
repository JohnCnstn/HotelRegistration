package classes.data.service.impl;

import classes.data.entity.Hotel;
import classes.data.repository.HotelRepository;
import classes.data.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
