package com.src.libraryapi.Services;

import com.src.libraryapi.models.Client;
import com.src.libraryapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClient(Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.get();
    }

    public Client addClient(Client client){
        return clientRepository.save(client);
    }

    public void removeClient(Long id){
        clientRepository.deleteById(id);
    }

    public Client updateClient(Client client, Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()){
            System.out.println("Client not registered.");
            return null;
        }
        else {
            client.setId(id);
            return clientRepository.save(client);
        }
    }

    public List<Client> findByName(String name) {
        List<Client> list = clientRepository.findByNameContainingIgnoreCase(name);
        return list;
    }

    public Long countClientsByName(String name){
        Long count = clientRepository.countClientsByNameIgnoreCase(name);
        return count;
    }

    public Set<Client> clientByBook(String name){
        Set<Client> set = clientRepository.findClientByRentedBooksNameContainingIgnoreCase(name);
        return set;
    }

    public List<Client> clientByDate(int date1, int date2){
        List<Client> list = clientRepository.findClientByBirthDateAfterAndBirthDateBefore(date1, date2);
        return list;
    }

    public List<Client> clientsNoBooks(){
        List<Client> list = clientRepository.findClientByRentedBooksIsNull();
        return list;
    }
}
