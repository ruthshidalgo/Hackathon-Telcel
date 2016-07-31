(function () {
    'use strict'

    var sidenav = {
        templateUrl:"app/side_nav/side_nav.html"
    }



    angular
        .module('chat')
        .component('sidenav',sidenav);
})();