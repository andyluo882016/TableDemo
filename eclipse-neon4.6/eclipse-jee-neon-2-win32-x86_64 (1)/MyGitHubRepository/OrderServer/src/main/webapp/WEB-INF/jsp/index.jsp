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
<div ng-app="myApp" ng-controller="myCtrl">
  Name: <input ng-model="name">
  <hr>
  <p>{{name}}</p>
</div>

<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
  $scope.name = "John Doe";
});
</script>
</body>
</html>