// public/js/controller/foto-controller.js

angular.module('alurapic')
    .controller('PersonDetailController', function($scope, $http, $routeParams) {

        $scope.person = {};

         
         $http.get('http://localhost:8080/rest/pessoa/'+$routeParams.id)
            .success(function(retorno) {
                $scope.person = retorno;
            })
            .error(function(erro) {
                console.log(erro)
            });
    });