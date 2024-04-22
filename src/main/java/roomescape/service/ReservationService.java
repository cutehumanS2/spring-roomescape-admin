package roomescape.service;

import org.springframework.stereotype.Service;
import roomescape.controller.dto.ReservationCreateRequest;
import roomescape.domain.Reservation;
import roomescape.repository.ReservationRepository;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //TODO DTO 리턴하도록 변경
    public Reservation createReservation(final ReservationCreateRequest request) {
        final Long id = reservationRepository.save(request);
        return request.toReservation(id);
    }

    public List<Reservation> readAllReservations() {
        return reservationRepository.findAll();
    }

    public void cancelReservation(final Long id) {
        reservationRepository.deleteById(id);
    }
}
