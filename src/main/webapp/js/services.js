angular.module('presentation.services').factory('user', ['$resource', function ($resource) {
    return $resource('/user/:id')
}]);

angular.module('presentation.services').factory('chat', function () {
    var service = {};

    var socket = new SockJS('/chat');
    var stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        service.callback(frame);

        stompClient.subscribe("/app/message2", function (data) {
            service.callback(data.body)
        });

        stompClient.subscribe("/topic/message", function (data) {
            service.callback(data.body)
        });

        stompClient.subscribe("/user/topic/message", function (data) {
            service.callback("Pour moi-meme :" + data.body)
        });
    }, function (error) {
        console.log("STOMP protocol error " + error);
    });

    service.subscribe = function (callback) {
        service.callback = callback;
    };

    service.send = function (message) {
        stompClient.send("/app/message", {}, JSON.stringify(message));
    };

    service.sendMe = function (message) {
        stompClient.send("/app/message/me", {}, JSON.stringify(message));
    };

    return service;
});