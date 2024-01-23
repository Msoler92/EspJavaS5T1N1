package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal findById(int id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        return sucursal.orElse(null);
    }

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();

    }
    public Sucursal saveOrUpdate (Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }
    public void deleteById(int id) {
        sucursalRepository.deleteById(id);
    }
}
