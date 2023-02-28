package com.src.libraryapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Long id;

    @Column(name = "client_name", nullable = false)
     private String name;

    @Column(name = "client_birthDate")
    private int birthDate;

    @ManyToOne
    @JoinColumn(name = "id_rent", referencedColumnName = "id")
    private Book rentedBooks;

    public Client(){
    }
    public Client(Long id, String name, int birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getBirthDate() == client.getBirthDate() && getId().equals(client.getId()) && getName().equals(client.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthDate());
    }

    public Book getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(Book rentedBooks) {
        this.rentedBooks = rentedBooks;
    }
}
