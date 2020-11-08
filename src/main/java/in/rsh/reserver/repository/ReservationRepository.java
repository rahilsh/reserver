package in.rsh.reserver.repository;

import in.rsh.reserver.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {}
