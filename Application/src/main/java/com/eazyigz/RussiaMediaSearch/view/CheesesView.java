package com.eazyigz.RussiaMediaSearch.view;

import java.util.List;

public interface CheesesView<Cheese> {
    void addItem(Cheese item);

    void addItems(List<Cheese> items);

    void clearItems();

    void showError();
}