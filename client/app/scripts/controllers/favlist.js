'use strict';

angular.module('clientApp')
  .controller('FavListCtrl', function ($scope, $http, $location) {

      $scope.favListsSet = [];

      $scope.createNewFavList = function () {

        var payload = {
          name: $scope.favListName,
          isDefault: $scope.isDefault
        };

        $http.post('/app/favourite-lists', payload)
            .success(function (data) {
              $scope.favListsSet.push(data);
            });

      };

      $scope.updateFavListSet = function(){
        $http.get('/app/favourite-lists/')
            .success(function (data) {
              $scope.favListsSet = data;
            })
      };

      $scope.openFavList = function(id){
          $location.path('/favourite-list/list/' + id);
      };

      $scope.addMovieToFavList = function (listId, movie) {

          var payload = {
              favListId: listId,
              movie: {
                  name: movie.original_title,
                  thumbnailHref: movie.poster_path,
                  overview: movie.overview
              }
          };

          $http.post('/app/favourite-lists/' + listId + '/movie/', payload);
      };

      $scope.updateFavListSet();

  });
