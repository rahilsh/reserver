package in.rsh.reserver;

import in.rsh.reserver.entity.Room;
import in.rsh.reserver.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

  private final RoomRepository roomRepository;

  @Autowired
  public H2Bootstrap(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  public void run(String... args) {

    System.out.println("Bootstrapping data: ");

    roomRepository.save(new Room(405, "200"));
    roomRepository.save(new Room(406, "220"));
    roomRepository.save(new Room(407, "250"));

    Iterable<Room> itr = roomRepository.findAll();

    System.out.println("Printing out data: ");
    for (Room room : itr) {
      System.out.println(room.getRoomNumber());
    }
  }
}
