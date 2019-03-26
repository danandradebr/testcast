// public/js/controllers/fotos-controller.js

angular.module('alurapic').controller('PersonsController', function($scope, $http,$sce,recursoFoto) {

    $scope.mensagem = '';
    $scope.persons=[];    

    $http.get('http://localhost:8080/rest/pessoas')
    .success(function(retorno) {
        console.log(retorno);
        $scope.persons = retorno;

    })
    .error(function(erro) {
        console.log(erro)
    });

    

    $scope.removePerson = function(id){
            

            $http.delete('http://localhost:8080/rest/pessoa/remove/' + id)
                .success(function() {
                    $scope.mensagem='Person removed by sucess!';

                    $http.get('http://localhost:8080/rest/pessoas')
                        .success(function(retorno) {
                            console.log(retorno);
                            $scope.persons = retorno;

                        })
                        .error(function(erro) {
                            console.log(erro)
                        });

                })
                .error(function(erro) {
                    console.log(' Erro ao realizar operalção');
                });





        };

     
});