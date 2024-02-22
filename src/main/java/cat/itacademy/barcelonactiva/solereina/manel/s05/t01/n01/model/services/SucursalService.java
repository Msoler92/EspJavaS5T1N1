package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.exceptions.ResourceNotFoundException;

import java.util.List;

public interface SucursalService {
    SucursalDTO findById(int id) throws ResourceNotFoundException;

    List<SucursalDTO> findAll();

    SucursalDTO saveOrUpdate (SucursalDTO sucursal);

    void deleteById(int id);

}
