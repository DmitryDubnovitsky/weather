'use strict';


var App = angular.module('example', []);

App.controller('SoundController', function ($scope, $http) {

    $http.get('subject').success(function (data) {
        $scope.subjects = data;

    });


    $http.get('sound').success(function (data) {
        $scope.calles = data;

    });

    $scope.addSubject = function () {
        $http.post('subject', $scope.subject).success(function (data) {
            $scope.subjects = data;
            $scope.subject = {};

        });
    };

    $scope.addSound = function () {
        $http.post('sound', $scope.call).success(function (data) {
            $scope.calles = data;
            $scope.call = {};

        });
    };

    $scope.findSubject = function () {

        /** @namespace $scope.sound */
        $http.post('subject/find', $scope.sound).success(function (data) {
            console.log(data);
            $scope.result = data;
        });
    };

   $scope.getSubjectId = function(array) {
        $http.get('subject/id',{ params: { subjectId: array.id }}).success(function (data) {
        })
    };

    $scope.remove = function(subject) {
        $http.delete('subject', { params: { subjectId: subject.id }}).success(function (data) {
            $scope.subjects = data;
            location.href = 'http://localhost:8080/';
        })

    };


    $scope.removeSound = function(call) {
        $http.delete('sound', { params: { soundId: call.id }}).success(function (data) {
            $scope.calles = data;
        })
    };

});