package in.rsh.reserver.model.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationRequest {

  private Long id;
  private Long roomId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate checkin;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate checkout;
}
