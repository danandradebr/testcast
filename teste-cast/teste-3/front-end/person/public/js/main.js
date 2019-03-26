angular.module('alurapic', ['minhasDiretivas', 'ngAnimate', 'ngRoute', 'meusServicos','ngSanitize'])
    .config(function($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true);

        $routeProvider.when('/persons', {
            templateUrl: 'partials/principal.html',
            controller: 'PersonsController'
        });

         $routeProvider.when('/newPerson', {
            templateUrl: 'partials/newPerson.html',
            controller: 'NewPersonController'
        });

        $routeProvider.when('/person/detail/:id', {
            templateUrl: 'partials/personDetail.html',
            controller: 'PersonDetailController'
        });


        $routeProvider.otherwise({redirectTo: '/persons'});

    });