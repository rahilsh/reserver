package in.rsh.reserver.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Room")
@NoArgsConstructor
@Getter
@Setter
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull private Integer roomNumber;

  @NotNull private String price;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  private List<Reservation> reservationList;

  public Room(Integer roomNumber, String price) {
    this.roomNumber = roomNumber;
    this.price = price;
  }

  public void addReservationEntity(Reservation reservation) {
    if (null == reservationList) reservationList = new ArrayList<>();

    reservationList.add(reservation);
  }
}
