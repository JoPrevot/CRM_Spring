package com.poe.crm.business.service;

import com.poe.crm.business.Client;
import org.springframework.stereotype.Service;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CrmService {

    ArrayList<Client> clients = new ArrayList<>();
    long index = 0;

    public List<Client> getAllClients() {

        return clients;
    }

    public void addClient(Client client){
        index++;
        client.setId(index);
        clients.add(client);
    }

    public Optional<Client> findClient(Long id){
        for(Client client : clients){
            if(client.getId().equals(id)){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    public boolean deleteClient(Long id){
        Iterator<Client> it = clients.iterator();
        while(it.hasNext()){
            Client client = it.next();
            if(client.getId().equals(id)) {
                it.remove();
                return true;

                //break;  // Continue la boucle pour tester l'accès concurrentiel
            }
        }
        return false;

//        for(Client client: clients){
//            if(client.getId().equals(id)){
//                clients.remove(client);
//                break;
//            }
//        }
    }

    public boolean updateClient(Client client){

        for(Client c: clients){
            if(c.getId().equals(client.getId())){
                clients.remove(c);
                clients.add(client);
                return true;
            }
        }
        return false;
    }
}
