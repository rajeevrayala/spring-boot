var app = angular.module('SecurityTestApp', []);

app.config([ '$httpProvider', function($httpProvider) {
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
} ]);

app.controller('AppCtrl', function($http, $scope) {
	
	$scope.login = function() {
		var base64Credential = btoa($scope.username + ':' + $scope.password);
		
		$http.get('user', {
			headers : {
				'Authorization' : 'Basic ' + base64Credential
			}
		}).success(function(res) {
			$scope.password = null;
			if (res.authenticated) {
				$scope.message = '';
				$http.defaults.headers.common['Authorization'] = 'Basic ' + base64Credential;
				$scope.user = res;
			} else {
				$scope.message = 'Authetication Failed !';
			}
		}).error(function(error) {
			$scope.message = 'Authetication Failed !';
		});
	};
	$scope.getAdminResouce = function() {
		$http.get('/api/admin/resource').success(function(res) {
			$scope.resource = res;
		}).error(function(error) {
			$scope.resource = error;
		});
	};
	$scope.getUserResouce = function() {
		$http.get('/api/user/resource').success(function(res) {
			$scope.resource = res;
		}).error(function(error) {
			$scope.resource = error;
		});
	};
	$scope.logout = function() {
		$http.defaults.headers.common['Authorization'] = null;
		$scope.user = null;
		$scope.message = 'Successfully logged out';
		$scope.resource = null;
	};
});