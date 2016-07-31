(function () {
    'use strict'

    var people = {
        templateUrl:"app/people_component/people_component.html"
    }

    angular
        .module('chat')
        .component('people',people);
})();
