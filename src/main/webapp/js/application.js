angular.module('presentation.services', ['ngResource']);
angular.module('presentation.controllers', []);
angular.module('presentationApp', ['presentation.services', 'presentation.controllers', 'ngRoute', 'ui.bootstrap'])
    .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
        $routeProvider
            .when('/slide/', {redirectTo: '/slide/1'})
            .when('/slide/:slideId', {templateUrl: 'views/slideContainer.html', controller: 'SlideCtrl'})
            .otherwise({redirectTo: '/slide'});

        $httpProvider.responseInterceptors.push(function ($q, $location) {
            return function (promise) {
                return promise.then(
                    function (response) {
                        return response;
                    },
                    function (response) {
                        if (response.status === 401)
                            $location.url('/login');
                        return $q.reject(response);
                    }
                );
            }
        });
    }]);