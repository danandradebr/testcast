// public/js/controller/foto-controller.js

angular.module('alurapic')
    .controller('NewPersonController', function($scope, $http, $routeParams) {

        $scope.person = {};
        $scope.mensagem = '';

         
        $scope.submeter = function() {

        $http.post('http://localhost:8080/rest/pessoa/save', $scope.person)
           .success(function(jobsRetorno) {
                $scope.person = jobsRetorno;
                $scope.mensagem = $scope.person.name+' Includes!';
                $scope.person = {};
        
            })
            .error(function(erro) {
               console.log(erro);
                $scope.mensagem = 'Erro no servidor ao incluir Person ';
                })
        };
    });