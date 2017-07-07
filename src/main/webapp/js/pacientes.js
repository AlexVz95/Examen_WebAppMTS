angular.module('webappApp')
.controller ('PacientesCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
	
	$scope.listas = {};
	$scope.formulario ={};
	$scope.tablas ={};
	$scope.tablas.pacientes = [];
	$scope.insertar={};
	$scope.update={};
	$http({
		method: "POST",
		url:"http://localhost:8080/Practica_WebApp/services/clinica/pacientes"
	}).success(function(data){
		 $scope.listas.pacientes = data;
		 $scope.listas.selectRolesPantallasValue = $scope.listas.creado_por;
		 $scope.tablas.pacientes = data;
		  
		console.log("Pacientes..");
		console.log($scope.tablas.pacientes);
	
	   });
	
	$scope.filters = {myfilter: ''}; 
	  
	  
	$scope.tableParams = new ngTableParams({
		page: 1,            // show first page
		count: 10,
		filter: $scope.filters,
		sorting: {
		        	
		// initial sorting

		}
	}, {
		count:[], //here put empty counts
	    total: $scope.tablas.pacientes.length, // length of data
		getData: function($defer, params) {
			
			var filteredData = params.filter() ? $filter('filter')($scope.tablas.pacientes, params.filter().myfilter) : data;
	        var orderedData = params.sorting() ?
	        $filter('orderBy')(filteredData, params.orderBy()) :
	        	data;
	            params.total(orderedData.length); // set total for recalc pagination
		        $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
		},
	    $scope: { $data: {} }
		   
		});
	
	$scope.activar = function(catalog){
		console.log(catalog);
		$scope.update.nombre=catalog.nombre;
		$scope.update.cedula_ide=catalog.cedula_ide;
		$scope.update.telefono=catalog.telefono;
		$scope.update.direccion=catalog.direccion;
		$scope.update.edad=catalog.edad;
		$scope.update.idPaciente=catalog.idPaciente;
		
		$("#myModal").modal("show");
	}
	
	$scope.$watch("tablas.pacientes", function(){
	      $scope.tableParams.reload(); 
	      console.log($scope.tablas.pacientes);
	  })
	  
	  $scope.actualizarDatos = function(){
		console.log($scope.update)
		 $http({
			 method: "POST",
			 data: $scope.update,
			 url:"http://localhost:8080/Practica_WebApp/services/clinica/updatepacientes"
		 }).success(function(data){
			 console.log(data);
			 console.log(data.mensaje);	
		 });
		 $("#myModal").modal("hide");
	  }
	
	$scope.mostrarInsercion = function(){
		console.log("initi.")
		$("#insertarPaciente").modal("show");
		
	}
	$scope.insertarDatos = function(){
		  console.log($scope.insertar)
		  $http({
				method: "POST",
				data: $scope.insertar,
				url:"http://localhost:8080/Practica_WebApp/services/clinica/insertarpacientes"
			}).success(function(data){
				console.log(data);
				console.log(data.mensaje);	
			   });
		  $("#insertarPaciente").modal("hide");
	  }
}]);








