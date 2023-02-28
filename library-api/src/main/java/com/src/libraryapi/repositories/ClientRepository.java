package com.src.libraryapi.repositories;

import com.src.libraryapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNameContainingIgnoreCase(String name);
    Long countClientsByNameIgnoreCase(String name);

    Set<Client> findClientByRentedBooksNameContainingIgnoreCase(String name);

    List<Client> findClientByBirthDateAfterAndBirthDateBefore(int date1, int date2);

    List<Client> findClientByRentedBooksIsNull();


}
