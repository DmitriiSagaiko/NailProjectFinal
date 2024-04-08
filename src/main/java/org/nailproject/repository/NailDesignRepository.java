package org.nailproject.repository;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class NailDesignRepository {
    HashMap<String, List<NailDesign>> nailDesignsRepository = new HashMap<>();

    public Boolean addDesign(NailDesign design, Client currentClient) {
        String email = currentClient.getEmail();
        List<NailDesign> list = getListOfClient(currentClient);
        Boolean isInList = isInDesignList(design, list);
        if (isInList) {
            //cant add it, it exists already
            return false;
        } else {
            addToListAndToMap(list,email,design);
            return true;
        }
    }

    public Boolean removeDesign(Client client, String designsName) {
        List<NailDesign> list = getListOfClient(client);
        Optional<NailDesign> answer = list.stream().filter(design -> design.getName().equals(designsName)).findFirst();
        if (answer.isPresent()) {
            NailDesign design = answer.get();
            list.remove(design);
            nailDesignsRepository.put(client.getEmail(), list);
            return true;
        }
        return false;
    }

    public void shareDesign(NailDesign design) {
        //TODO need to share design with pic to TG/WA what ever
    }
    public void printDesign(NailDesign design) {
        //TODO for V2. Need to be ready to print it
    }

    public Optional<NailDesign> getOneDesign(String name,Client client) {
        List<NailDesign> list = getListOfClient(client);
        return list.stream().filter(design -> design.getName().equals(name)).findFirst();
    }

    public List<NailDesign> getAllDesigns(Client client) {
        return getListOfClient(client);
    }



    private List<NailDesign> getListOfClient(Client client) {
        return nailDesignsRepository.get(client.getEmail());
    }

    private Boolean isInDesignList(NailDesign design, List<NailDesign> list) {
        return list.stream().anyMatch(design::equals);
    }

    private void addToListAndToMap(List<NailDesign> list, String email, NailDesign design) {
        list.add(design);
        nailDesignsRepository.put(email, list);
    }
}
