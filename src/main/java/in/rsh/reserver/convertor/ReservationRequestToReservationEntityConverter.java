package in.rsh.reserver.convertor;

import in.rsh.reserver.entity.Reservation;
import in.rsh.reserver.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

public class ReservationRequestToReservationEntityConverter
    implements Converter<ReservationRequest, Reservation> {

  @Override
  public Reservation convert(ReservationRequest source) {

    Reservation reservation = new Reservation();
    reservation.setCheckin(source.getCheckin());
    reservation.setCheckout(source.getCheckout());
    if (null != source.getId()) reservation.setId(source.getId());

    return reservation;
  }
}
