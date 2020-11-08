package in.rsh.reserver.rest;

import in.rsh.reserver.convertor.RoomEntityToReservableRoomResponseConverter;
import in.rsh.reserver.entity.Reservation;
import in.rsh.reserver.entity.Room;
import in.rsh.reserver.model.request.ReservationRequest;
import in.rsh.reserver.model.response.ReservableRoomResponse;
import in.rsh.reserver.model.response.ReservationResponse;
import in.rsh.reserver.repository.PageableRoomRepository;
import in.rsh.reserver.repository.ReservationRepository;
import in.rsh.reserver.repository.RoomRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {

  private final PageableRoomRepository pageableRoomRepository;

  private final RoomRepository roomRepository;

  private final ReservationRepository reservationRepository;

  private final ConversionService conversionService;

  @Autowired
  public ReservationResource(
      PageableRoomRepository pageableRoomRepository,
      RoomRepository roomRepository,
      ReservationRepository reservationRepository,
      ConversionService conversionService) {
    this.pageableRoomRepository = pageableRoomRepository;
    this.roomRepository = roomRepository;
    this.reservationRepository = reservationRepository;
    this.conversionService = conversionService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<ReservableRoomResponse> getAvailableRooms(
      @RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate checkin,
      @RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
          LocalDate checkout,
      Pageable pageable) {

    Page<Room> roomEntityList = pageableRoomRepository.findAll(pageable);

    return roomEntityList.map(new RoomEntityToReservableRoomResponseConverter());
  }

  @GetMapping(path = "/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Room> getRoomById(@PathVariable Long roomId) {

    Optional<Room> optionalRoomEntity = roomRepository.findById(roomId);
    return optionalRoomEntity
        .map(room -> new ResponseEntity<>(room, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ReservationResponse> createReservation(
      @RequestBody ReservationRequest reservationRequest) {

    Reservation reservation = conversionService.convert(reservationRequest, Reservation.class);
    reservationRepository.save(reservation);

    Room room = roomRepository.findById(reservationRequest.getRoomId()).get();
    room.addReservationEntity(reservation);
    roomRepository.save(room);
    reservation.setRoom(room);

    ReservationResponse reservationResponse =
        conversionService.convert(reservation, ReservationResponse.class);

    return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
  }

  @PutMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ReservableRoomResponse> updateReservation(
      @RequestBody ReservationRequest reservationRequest) {

    return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
  }

  @DeleteMapping(path = "/{reservationId}")
  public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
