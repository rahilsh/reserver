package in.rsh.reserver.convertor;

import in.rsh.reserver.entity.Reservation;
import in.rsh.reserver.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

public class ReservationEntityToReservationResponseConverter
    implements Converter<Reservation, ReservationResponse> {

  @Override
  public ReservationResponse convert(Reservation source) {

    ReservationResponse reservationResponse = new ReservationResponse();
    reservationResponse.setCheckin(source.getCheckin());
    reservationResponse.setCheckout(source.getCheckout());

    if (null != source.getRoom()) reservationResponse.setId(source.getRoom().getId());
    return reservationResponse;
  }
}
