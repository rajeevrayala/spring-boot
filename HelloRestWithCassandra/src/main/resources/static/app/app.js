var app = angular
		.module("myModule", [])
		.controller("myController", function ($scope, $http, $log) {
		
		var successCallBack = function (response) {
			$scope.employees = response.data;
		};
		
		var errorCallBack = function (response) {
			$scope.error = response.data;
		};
		
		$http({
			method: 'GET',
			url: 'http://localhost:8077/customer'
		})
			.then(successCallBack, errorCallBack);
		});