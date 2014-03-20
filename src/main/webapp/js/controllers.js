angular.module('presentation.controllers').controller('SlideCtrl', function ($scope, $routeParams, $location) {
    $scope.slideId = "views/slide" + $routeParams.slideId + ".html";

    $scope.currentPage = $routeParams.slideId;

    $scope.setPage = function (pageNo) {
        $location.path("/slide/" + pageNo)
    };
});

angular.module('presentation.controllers').controller('LoginCtrl', function ($scope) {
    $scope.authenticationError = false;
});

angular.module('presentation.controllers').controller('UserCtrl', function ($scope, user) {
    user.query(function (data) {
        $scope.users = data
    });

    user.save($scope.nickname, function (data) {
    });
});

angular.module('presentation.controllers').controller('ChatCtrl', function ($scope, chat) {
    $scope.messages = [];

    chat.subscribe(function (message) {
        $scope.messages.push(message);
        $scope.$apply();
    });

    $scope.send = function () {
        chat.send($scope.text);
        $scope.text = ""
    };

    $scope.sendMe = function () {
        chat.sendMe($scope.text);
        $scope.text = ""
    }
});