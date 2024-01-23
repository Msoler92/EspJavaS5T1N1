package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {}
