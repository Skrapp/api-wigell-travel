package com.nilsson.api_wigell_travel.config;

import com.nilsson.api_wigell_travel.entity.Address;
import com.nilsson.api_wigell_travel.entity.Customer;
import com.nilsson.api_wigell_travel.entity.Destination;
import com.nilsson.api_wigell_travel.repo.AddressRepo;
import com.nilsson.api_wigell_travel.repo.BookingRepo;
import com.nilsson.api_wigell_travel.repo.CustomerRepo;
import com.nilsson.api_wigell_travel.repo.DestinationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(AddressRepo addressRepo, BookingRepo bookingRepo, CustomerRepo customerRepo, DestinationRepo destinationRepo){
        return args -> {
            if(destinationRepo.count() == 0){
                Destination d1 = new Destination(2000, "Lilla hotellet", "Sundsvall", "Sverige");
                Destination d2 = new Destination(1500, "Rasta", "Harmånger", "Sverige");
                Destination d3 = new Destination(10000, "Pequeña casa", "Barcelona", "Spanien");
                Destination d4 = new Destination(5000, "Wood hotel", "Bodo", "Norge");
                Destination d5 = new Destination(1000, "Hotel Bristol", "Oslo", "Norge");
                destinationRepo.saveAll(List.of(d1, d2, d3, d4, d5));
            }
            if(customerRepo.count() == 0){
                Address address1 = new Address("Mystikgatan 17", "123 45", "Gnarp");
                Address address2 = new Address("Långvägen 469", "899 90", "Njurunda");
                Address address3 = new Address("Hasselavägen 7", "887 76", "Hassela");
                Address address4 = new Address("Gammelgatan 45", "657 90", "Bergsjö");
                addressRepo.saveAll(List.of(address1, address2, address3, address4));

                Customer c1 = new Customer("Nils", "Nilsson", LocalDate.ofYearDay(2000, 200), "nisse@mail.com", "076-333 22 11", null);
                Customer c2 = new Customer("Sanne", "Radio", LocalDate.ofYearDay(1968, 130), "sanne@mail.com", "073-987 65 43", null);
                Customer c3 = new Customer("Fia-Li", "Lo", LocalDate.ofYearDay(1997, 10), "lilo@mail.com", "074-111 22 33", null);
                Customer c4 = new Customer("Gustaf", "Henriksson", LocalDate.ofYearDay(1999, 300), "gurra@mail.com", "073-001 02 03", null);
                Customer c5 = new Customer("Nora", "Fisk", LocalDate.ofYearDay(1974, 100), "nora@mail.com", "072-678 45 23", null);
                c1.addAddress(address1);
                c2.addAddress(address2);
                c3.addAddress(address2);
                c4.addAddress(address3);
                c5.addAddress(address4);
                customerRepo.saveAll(List.of(c1, c2, c3, c4));
            }

        };
    }
}
