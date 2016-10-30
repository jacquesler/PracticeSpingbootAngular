package eCom.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eCom.domain.order.BoughtItem;
import eCom.repository.CataglogCsvRepository;
import eCom.repository.CataglogRepository;
import eCom.domain.cart.ShoppingCart;

@RestController
@RequestMapping("/checkout")
public class ShoppingBasketCheckoutController {

	
	@RequestMapping(
			method = RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE})
	public Response checkout(@RequestBody List<BoughtItem> boughtItems) throws Exception{
		CataglogRepository cr = new CataglogCsvRepository();
		ShoppingCart cart = new ShoppingCart(cr);
		cart.AddToCart(boughtItems);
		return Response.ok(cart.getOrder().getRecieptItems()).build();
	}
}
