package in.rsh.reserver.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Reservation")
@Getter
@Setter
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull private LocalDate checkin;

  @NotNull private LocalDate checkout;

  @ManyToOne private Room room;

  public Reservation() {}

  public Reservation(LocalDate checkin, LocalDate checkout, Room room) {
    this.checkin = checkin;
    this.checkout = checkout;
    this.room = room;
  }

  @Override
  public String toString() {
    return "ReservationEntity{"
        + "id="
        + id
        + ", checkin="
        + checkin
        + ", checkout="
        + checkout
        + ", roomEntity="
        + room
        + '}';
  }
}
