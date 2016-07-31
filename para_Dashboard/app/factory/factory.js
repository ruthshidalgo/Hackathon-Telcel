(function () {
    'use strict'

    angular
        .module('chat')
        .factory('chatData',chatData);

    function chatData($firebaseArray) {
        var link = new Firebase('https://urbanx.firebaseio.com/Person')
        return $firebaseArray(link)
    }
})();