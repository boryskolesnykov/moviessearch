'use strict';

angular.module('clientApp')
    .controller('DashboardCtrl', function ($scope, $log, $http, alertService, $location) {

        $scope.movies = [];

        $scope.searchMovies = function() {

            $http.get('/app/search')
                .success(function(data) {
                    $scope.movies = data;
                });

        };

        $scope.searchMovies();

    });
