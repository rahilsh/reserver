package in.rsh.reserver.repository;

import in.rsh.reserver.entity.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableRoomRepository extends PagingAndSortingRepository<Room, Long> {}
