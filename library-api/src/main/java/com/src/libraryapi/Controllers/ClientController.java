package com.src.libraryapi.Controllers;

import com.src.libraryapi.Services.ClientService;
import com.src.libraryapi.models.Client;
import com.src.libraryapi.repositories.ClientRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClient(){
        List<Client> list = clientService.getAllClients();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id){
        Client client = clientService.getClient(id);
        return ResponseEntity.ok().body(client);
    }

    @GetMapping("/consulta/find")
    public ResponseEntity<List<Client>> findByName(@RequestParam(name = "nome") String name){
        List<Client> list = clientService.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/consulta/count")
    public ResponseEntity<Long> countClientsByName(@RequestParam(name = "countName") String name){
        Long count = clientService.countClientsByName(name);
        return ResponseEntity.ok().body(count);
    }

    @GetMapping("/consulta/clientBook")
    public ResponseEntity<Set<Client>> clientByBook(@RequestParam(name = "bookName") String name){
        Set<Client> set = clientService.clientByBook(name);
        return ResponseEntity.ok().body(set);
    }

    @GetMapping("/consulta/date")
    public ResponseEntity<List<Client>> clientByDate(@RequestParam(name = "after") int date1, @RequestParam(name = "before") int date2){
        List<Client> list = clientService.clientByDate(date1, date2);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/consulta/noBooks")
    public ResponseEntity<List<Client>> clientsNoBooks(){
        List<Client> list = clientService.clientsNoBooks();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        clientService.addClient(client);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeClient(@PathVariable Long id){
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id){
        clientService.updateClient(client, id);
        return ResponseEntity.ok().body(client);
    }
}
