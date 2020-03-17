package com.company.ru.billing.client;

import com.company.ru.billing.stocklist.ItemCatalog;
import com.company.ru.itmo.exceptions.CatalogLoadExceptions;

import java.io.IOException;

public interface CatalogLoader{
    void load (ItemCatalog itemCatalog) throws CatalogLoadExceptions, IOException;
}
