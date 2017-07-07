angular.module('webappApp')
.controller ('MedicamentosCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
	
	$scope.listas = {};
	$scope.formulario ={};
	$scope.tablas ={};
	$scope.tablas.medicamentos = [];
	$scope.insertar={};
	$scope.update={};
	$http({
		method: "POST",
		url:"http://localhost:8080/Practica_WebApp/services/clinica/medicamentos"
	}).success(function(data){
		 $scope.tablas.medicamentos = data;
		  
		console.log("Pacientes..");
		console.log($scope.tablas.medicamentos);
	
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
	    total: $scope.tablas.medicamentos.length, // length of data
		getData: function($defer, params) {
			
			var filteredData = params.filter() ? $filter('filter')($scope.tablas.medicamentos, params.filter().myfilter) : data;
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
		$scope.update.codigo_med=catalog.codigo_med;
		$scope.update.idMedicamentos=catalog.idMedicamentos;
		
		$("#myModal").modal("show");
	}
	
	$scope.$watch("tablas.medicamentos", function(){
	      $scope.tableParams.reload(); 
	      console.log($scope.tablas.medicamentos);
	  })
	  
	  $scope.actualizarDatos = function(){
		console.log($scope.update)
		 $http({
			 method: "POST",
			 data: $scope.update,
			 url:"http://localhost:8080/Practica_WebApp/services/clinica/updatemedicamento"
		 }).success(function(data){
			 console.log(data);
			 console.log(data.mensaje);	
		 });
		 $("#myModal").modal("hide");
	  }
	
	$scope.mostrarInsercion = function(){
		console.log("initi.")
		$("#insertarMedicamento").modal("show");
		
	}
	$scope.insertarDatos = function(){
		  console.log($scope.insertar)
		  $http({
				method: "POST",
				data: $scope.insertar,
				url:"http://localhost:8080/Practica_WebApp/services/clinica/insertarmedicamento"
			}).success(function(data){
				console.log(data);
				console.log(data.mensaje);	
			   });
		  $("#insertarPaciente").modal("hide");
	  }
}]);








