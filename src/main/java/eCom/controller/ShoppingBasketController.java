package eCom.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eCom.domain.cart.BasketItem;
import eCom.repository.CataglogCsvRepository;
import eCom.repository.CataglogRepository;

@RestController
@RequestMapping("/shoppingItems")
public class ShoppingBasketController {
		
	@RequestMapping(method = RequestMethod.GET)
	public List<BasketItem> loadItemsForSale() throws Exception{
		CataglogRepository cr = new CataglogCsvRepository();
		List<BasketItem> basketItems = cr.load().getBasketItems();
		return basketItems;
	}
}
