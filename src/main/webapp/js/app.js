'use strict';

var app = angular
  .module('webappApp', [
    'ngRoute',
    'ngTable',
    'ngResource',
    'ngRoute',
    'ngSanitize'
    
  ]).config(function ($routeProvider) {
	    $routeProvider
	      .when('/', {
	        templateUrl: 'view/welcome.html',
	      })
	      .when('/pacientes',{
	    	  templateUrl: 'view/pacientes.html',
	    	  controller: 'PacientesCtrl'
	      })
	      .when('/medicos',{
	    	  templateUrl: 'view/medicos.html',
	    	  controller: 'MedicosCtrl'
	      })
	      .when('/medicamentos',{
	    	  templateUrl: 'view/medicamentos.html',
	    	  controller: 'MedicamentosCtrl'
	      })
	      .when('/sustancias',{
	    	  templateUrl: 'view/sustancias.html',
	    	  controller: 'SustanciasCtrl'
	      })
	      .when('/citas',{
	    	  templateUrl: 'view/citas.html',
	    	  controller: 'CitasCtrl'
	      })
	      .otherwise({
	        redirectTo: '/'
	      });
  		}

  );



