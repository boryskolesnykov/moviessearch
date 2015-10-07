'use strict';

angular.module('clientApp')
  .controller('MovieCtrl', function ($scope, $http, $routeParams) {

      $scope.movies = [];

      $scope.getAllFavListMovies = function(){
        var id = $routeParams.id;
        $http.get('/app/favourite-lists/' + id + '/movie')
            .success(function (data) {
              $scope.movies = data;
            });
      };

      $scope.getAllFavListMovies();

  });
