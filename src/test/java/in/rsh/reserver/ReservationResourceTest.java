package in.rsh.reserver;

import static io.restassured.RestAssured.given;

import in.rsh.reserver.rest.ResourceConstants;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = ReserverApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationResourceTest {

  private static final Integer EXPECTED_ITEM_ID_FOR_GET = 1;

  @LocalServerPort private int port;

  @BeforeEach
  public void setUp() {

    RestAssured.port = port;
    RestAssured.basePath = ResourceConstants.ROOM_RESERVATION_V1;
    RestAssured.baseURI = "http://localhost";
  }

  @Test
  void getAvailableRooms() {
    given().when().get("/" + EXPECTED_ITEM_ID_FOR_GET).then().statusCode(200);
  }
}
