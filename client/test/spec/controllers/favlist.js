'use strict';

describe('Controller: FavlistCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var FavlistCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FavlistCtrl = $controller('FavlistCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(FavlistCtrl.awesomeThings.length).toBe(3);
  });
});
