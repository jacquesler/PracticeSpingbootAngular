'use strict';

var app = angular.module('app.shoppingServices', ['ngResource']);

app.factory('CatalogFactory', function ($resource) {
    return $resource('/shoppingItems', {}, {
        query: { method: 'GET', isArray: true }
    })    
});

app.factory('CalculateItemsFactory', function($resource){
	return $resource('/checkout', {},{
		checkout: {method: 'POST'}
	})
});