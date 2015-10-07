'use strict';

angular.module('clientApp')
    .controller('DashboardCtrl', function ($scope, $log, $http, alertService, $location) {

        $scope.metadata = [];

        $scope.searchMovies = function() {

            $http.get('/app/movies/search?query=' + $scope.searchInput)
                .success(function(data) {
                    $scope.metadata = data;
                });

        };

    });
