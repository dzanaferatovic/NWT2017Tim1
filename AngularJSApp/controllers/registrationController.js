app.controller('registrationController', function($log, $scope, $location, $http, $rootScope){
	$log.log('registration kontroler ucitan');

	//napravi usera za registraciju
	
	$rootScope.register=function(){

		/*if($scope.password1==$scope.password2)
		{
			$scope.user.pw=$scope.password1;
			$http.post("http://localhost:8080/users-client/user/register",$scope.user).then(function(response){
				return response.data;
				$location.path('/');
			});
		}*/

		if($scope.password1==$scope.password2)
		{
			$scope.user.password=$scope.password1;
			$log.log($scope.user);
			$http.post("http://localhost:8081/user/register",$scope.user).then(function(response){
				return response.data;
				$location.path('/');
			});
		}
	}


});