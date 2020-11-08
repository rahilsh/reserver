package in.rsh.reserver.repository;

import in.rsh.reserver.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableRoomRepository extends PagingAndSortingRepository<Room, Long> {

  Page<Room> findById(Long id, Pageable page);
}
