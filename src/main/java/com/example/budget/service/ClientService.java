package com.example.budget.service;

import com.example.budget.exception.ClientNotFoundException;
import com.example.budget.model.Client;
import com.example.budget.repository.ClientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Collection<Client> listAll(){
        return clientRepository.findAll();
    }
    public List<Client> listAllOrderById(){
        return (List<Client>) clientRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }
    public void save(Client client){
        clientRepository.save(client);
    }

    public Client get(Long id) throws ClientNotFoundException {
        Optional<Client> result = clientRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ClientNotFoundException ("Could not find any client with ID " + id);
    }

    public void delete (Long id) throws ClientNotFoundException {
        Long count = clientRepository.countById(id);
        if(count == null || count ==0) {
            throw new ClientNotFoundException("Could not find any clients with ID " + id);
        }
        clientRepository.deleteById(id);
    }

}
