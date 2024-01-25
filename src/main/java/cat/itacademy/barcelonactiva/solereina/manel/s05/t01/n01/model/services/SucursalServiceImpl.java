package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.exceptions.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalDTO findById(int id) throws ResourceNotFoundException {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);

        if (sucursal.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return SucursalDTO.fromSucursal(sucursal.get());
    }

    public List<SucursalDTO> findAll() {
        return sucursalRepository.findAll().stream().map(SucursalDTO::fromSucursal).collect(Collectors.toList());

    }
    public SucursalDTO saveOrUpdate (SucursalDTO sucursal) {
        return SucursalDTO.fromSucursal(
                sucursalRepository.save(
                        SucursalDTO.toSucursal(sucursal)));
    }
    public void deleteById(int id) {
        sucursalRepository.deleteById(id);
    }
}
