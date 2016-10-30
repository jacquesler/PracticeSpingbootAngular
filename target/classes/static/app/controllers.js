'use strict';

var app = angular.module('app.shoppingControllers', ['app.shoppingServices']);

app.controller('StockItemsCtrl', ['$http', '$scope', 'CatalogFactory', 'CalculateItemsFactory',
    function ($http, $scope, CatalogFactory, CalculateItemsFactory) {

	$scope.receiptItems = [];
	$scope.basketItems = CatalogFactory.query();
	$scope.submited = false;
	
	$scope.plusOne = function(index) { 
	  	$scope.basketItems[index].quantity += 1;
	   };
	
   $scope.minusOne = function(index) { 
	   if($scope.basketItems[index].quantity > 0){
		   $scope.basketItems[index].quantity -= 1; 
	   }else{
		   $scope.basketItems[index].quantity = 0;
	   }
   };
	  
   $scope.checkout = function(){	   
	   var boughtItems = [];
	   
	   angular.forEach($scope.basketItems,function(basketItem,index){
		   if(basketItem.quantity > 0){
			   boughtItems.push({
			        id: basketItem.stockItem.id,
			        quantity: basketItem.quantity
			    });
		   }
           
       });
	   
	   var result = CalculateItemsFactory.checkout(boughtItems);
	   
	   result.$promise.then(function(result){		  
		   $scope.submited = true;
		   $scope.receiptItems = result.entity;
			
		});	  
   }	
}]);