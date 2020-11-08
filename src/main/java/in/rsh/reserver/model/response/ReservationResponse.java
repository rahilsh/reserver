package in.rsh.reserver.model.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReservationResponse {

  private Long id;
  private LocalDate checkin;
  private LocalDate checkout;
}
