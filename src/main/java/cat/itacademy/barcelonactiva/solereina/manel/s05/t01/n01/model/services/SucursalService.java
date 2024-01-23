package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {
    public SucursalDTO findById(int id);

    public List<SucursalDTO> findAll();

    public SucursalDTO saveOrUpdate (SucursalDTO sucursal);

    public void deleteById(int id);

}
