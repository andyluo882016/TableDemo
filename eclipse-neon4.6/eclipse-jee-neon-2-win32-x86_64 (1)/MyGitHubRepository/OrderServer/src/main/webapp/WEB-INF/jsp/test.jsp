<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring Boot - Angularjs Example</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
     
      <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />

</head>
<body>
   <h3>Welcome to Using the Angular to register Product:</h3>
    
    <div ng-app="MyApp" ng-controller="MyController">
    <pre>http status code: {{status}}</pre>
  <pre>http response data: {{data}}</pre>
  <p>Test message: {{test}}</p><hr>
        Product ID:
        <input type="text" ng-model="id"/>
        <br/><br/><hr>
        Product Name:
          <input type="text" ng-model="name"/>
        <br/><br/><hr>
        Product Price:
          <input type="text" ng-model="price"/>
        <br/><br/><hr>
        <input type="button" value="Submit" ng-click="ButtonClick()"/>
        <br/><hr>
         
    </div>
    
    <script>
    var app = angular.module('MyApp', [])
    app.controller('MyController', function ($scope, $http, $window) {
        $scope.ButtonClick = function () {
        	$scope.code = null;
            $scope.response = null;
            $scope.test="this is my testing data";
        	//var post = 
            	$http({
                method: "POST",
                url: "http://localhost:8877/api/ORDER-SERVER/productOrder/product",
                dataType: 'json',
                data: { "id": $scope.id, "name":$scope.name, "price":$scope.price },
                headers: { "Content-Type": "application/json" }
            }).then(function(response) {
                $scope.status = JSON.stringify(response.status);
                $scope.data = JSON.stringify(response.data);
                console.log(JSON.stringify(response.data));
              }, function(response) {
                $scope.data = response.data || 'Request failed';
                $scope.status = JSON.stringify(response.status);
                $window.alert(response.status);
            });
         // };

 
            /*post.success(function (data, status) {
                $window.alert("Hello: " + data.firstname + " .\nCurrent Date and Time: " + data.DateTime);
            });
 
            post.error(function (data, status) {
                $window.alert(data.Message);
            });*/
        }
    });
    </script>
</body>
</html>
</body>
</html>