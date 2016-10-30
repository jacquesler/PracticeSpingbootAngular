package eCom.repository;

import eCom.domain.cart.Catalog;

public interface CataglogRepository {

	Catalog load() throws Exception;
}
