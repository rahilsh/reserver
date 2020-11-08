package in.rsh.reserver.model.response;

import in.rsh.reserver.model.Links;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReservableRoomResponse {

  private Long id;
  private Integer roomNumber;
  private Integer price;
  private Links links;

  public ReservableRoomResponse(Integer roomNumber, Integer price) {
    this.roomNumber = roomNumber;
    this.price = price;
  }
}
