package com.mybank.atm.repository;

import com.mybank.atm.model.Acount;
import com.mybank.atm.model.Card;
import com.mybank.atm.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientsRepository {

    List<Client> clients = new ArrayList<Client>();

    public void creatClients() {
        Acount acount1 = new Acount(1, 11111, 100, true);
        Acount acount2 = new Acount(2, 22222, 200, true);
        Acount acount3 = new Acount(3, 33333, 300, true);
        Acount acount4 = new Acount(4, 44444, 400, true);
        Acount acount5 = new Acount(5, 55555, 500, false);
        Card card1 = new Card(1, 11111, 1111, "Visa", acount1);
        Card card2 = new Card(2, 22222, 2222, "Visa", acount2);
        Card card3 = new Card(3, 33333, 3333, "Visa", acount3);
        Card card4 = new Card(4, 44444, 4444, "Visa", acount4);
        Card card5 = new Card(5, 55555, 5555, "Master Card", acount5);
        clients.add(new Client(1, card1, "Yuriy", "Kozlov"));
        clients.add(new Client(2, card2, "Kostya", "Ivanv"));
        clients.add(new Client(3, card3, "Tom", "Cruze"));
        clients.add(new Client(4, card4, "Kate", "Mose"));
        clients.add(new Client(5, card5, "Rory", "Banger"));
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClientByID(int id) {
        List<Client> clients = getClients();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientId() == id) {
                return clients.get(i);
            }
        }
        return null;
    }
    public Client getClientByCardNum(int cardNum) {
        List<Client> clients = getClients();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCard().getCardNum() == cardNum) {
                return clients.get(i);
            }
        }
        return null;
    }
}
