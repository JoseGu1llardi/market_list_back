package com.guillard.appmarketlist.service;

import com.guillard.appmarketlist.model.ItemList;
import com.guillard.appmarketlist.model.List;
import com.guillard.appmarketlist.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class ListService implements IListService {

    @Autowired
    private IListRepository repository;

    @Override
    public List createNewList(List newList) {
        return repository.save(newList);
    }

    @Override
    public java.util.List<List> getAllList() {
        return (java.util.List<List>) repository.findAll();
    }

    @Override
    public List searchById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List closeList(Integer id) {
        return repository.findById(id)
                .map(list -> {
                    double total = Optional.ofNullable(list.getItems())
                            .orElse(Collections.emptyList())
                            .stream()
                            .mapToDouble(ItemList::getTotalPrice)
                            .sum();

                    list.setTotalValue(total);
                    list.setStatus(1);

                    return repository.save(list);
                }).orElseThrow(() -> new IllegalArgumentException("List with id " + id + " not found"));
    }

    @Override
    public void removeList(Integer id) {
        repository.deleteById(id);
    }
}
