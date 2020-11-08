package in.rsh.reserver.convertor;

import in.rsh.reserver.entity.Room;
import in.rsh.reserver.model.Self;
import in.rsh.reserver.rest.ResourceConstants;
import java.util.function.Function;
import in.rsh.reserver.model.Links;
import in.rsh.reserver.model.response.ReservableRoomResponse;

public class RoomEntityToReservableRoomResponseConverter
    implements Function<Room, ReservableRoomResponse> {

  @Override
  public ReservableRoomResponse apply(Room source) {
    ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
    if (null != source.getId()) reservationResponse.setId(source.getId());
    reservationResponse.setRoomNumber(source.getRoomNumber());
    reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
    Links links = new Links();
    Self self = new Self();
    self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
    links.setSelf(self);
    reservationResponse.setLinks(links);
    return reservationResponse;
  }
}
