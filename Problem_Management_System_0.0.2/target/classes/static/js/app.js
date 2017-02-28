var app = angular.module('mainRoute', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'views/home.html',
			controller: 'HomeController'
		})
		.when('/problem', {
			templateUrl: 'views/problem.html',
			controller: 'ProblemController'
		})
		.when('/course', {
			templateUrl: 'views/course.html',
			controller: 'CourseController'
		})
		.when('/comment', {
			templateUrl: 'views/comment.html',
			controller: 'CommentController'
		})
		.when('/about', {
			templateUrl: 'views/about.html',
			controller: 'AboutController'
		})
		.when('/trolley', {
			templateUrl: 'views/trolley.html',
			controller: 'TrolleyController'
		})
		.when('/userinfo', {
			templateUrl: 'views/userinfo.html',
			controller: 'UserinfoController'
		})
		.when('/admin', {
			templateUrl: 'views/admin.html',
			controller: 'AdminController'
		})
		.otherwise({
			redirectTo: '/home'
		});
}]);