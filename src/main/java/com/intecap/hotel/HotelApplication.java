package com.intecap.hotel;

import com.intecap.hotel.domain.entities.ReservationEntity;
import com.intecap.hotel.domain.entities.TicketEntity;
import com.intecap.hotel.domain.entities.TourEntity;
import com.intecap.hotel.domain.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@Slf4j  //para usar el log
public class HotelApplication  implements CommandLineRunner { //para ejecutar codigo al iniciar la aplicacion

    private final HotelRepository hotelRepository;
    private final FlyRepository flyRepository;
    private final TicketRepository ticketRepository;
    private final ReservationRepository reservationRepository;
    private final TourRepository tourRepository;
    private final CustomerRepository customerRepository;

    public HotelApplication(
            HotelRepository hotelRepository,
            FlyRepository flyRepository,
            TicketRepository ticketRepository,
            ReservationRepository reservationRepository,
            TourRepository tourRepository,
            CustomerRepository customerRepository) {

        this.hotelRepository = hotelRepository;
        this.flyRepository = flyRepository;
        this.ticketRepository = ticketRepository;
        this.reservationRepository = reservationRepository;
        this.tourRepository = tourRepository;
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        //var fly = flyRepository.findById(2L).get(); //este metodo es opcional y se usa para evitar el null pointer exception
        //var hotel = hotelRepository.findById(7L).get(); //este metodo es opcional y se usa para evitar el null pointer exception
        //var ticket = ticketRepository.findById(UUID.fromString("32345678-1234-5678-4234-567812345678")).get();

       // this.flyRepository.findByPriceLessThan(BigDecimal.valueOf(20)).forEach(fly -> {
            //log.info(fly.toString());
            //System.out.println(fly.toString());
        //});
/*
        this.flyRepository.findByPriceLessThanNative(BigDecimal.valueOf(20)).forEach(fly -> {
            //log.info(fly.toString());
            System.out.println(fly.toString());
        });
*/
        this.flyRepository.findByIdJoinFetchTickets(UUID.fromString("42345678-1234-5678-5233-567812345678")).ifPresent(fly -> {
            //log.info(fly.toString());
            System.out.println(fly.toString());
        });

        //log.info(String.valueOf(fly));
        //log.info(String.valueOf(hotel));
        //log.info(String.valueOf(ticket));





    }
}
