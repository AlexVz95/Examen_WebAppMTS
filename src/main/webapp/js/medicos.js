angular.module('webappApp')
.controller ('MedicosCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
	
	$scope.listas = {};
	$scope.formulario ={};
	$scope.tablas ={};
	$scope.tablas.homeopatas = [];
	$scope.tablas.medicos = [];
	$scope.insertar={};
	$scope.update={};
	
	  
	$http({
		method: "POST",
		url:"http://localhost:8080/Practica_WebApp/services/clinica/homeopatas"
	}).success(function(data){
		 $scope.tablas.homeopatas = data;
		  
		console.log("Homeopatas..");
		console.log($scope.tablas.homeopatas);
	
	   });
	
	$http({
		method: "POST",
		url:"http://localhost:8080/Practica_WebApp/services/clinica/medicos"
	}).success(function(data){
		 $scope.tablas.medicos = data;
		  
		console.log("Homeopatas..");
		console.log($scope.tablas.medicos);
	
	   });
	
	$scope.filters = {myfilter: ''}; 
	$scope.filters2 = {myfilter: ''}; 
	  
	  
	$scope.tableParams = new ngTableParams({
		page: 1,            // show first page
		count: 10,
		filter: $scope.filters,
		sorting: {
		        	
		// initial sorting

		}
	}, {
		count:[], //here put empty counts
	    total: $scope.tablas.homeopatas.length, // length of data
		getData: function($defer, params) {
			
			var filteredData = params.filter() ? $filter('filter')($scope.tablas.homeopatas, params.filter().myfilter) : data;
	        var orderedData = params.sorting() ?
	        $filter('orderBy')(filteredData, params.orderBy()) :
	        	data;
	            params.total(orderedData.length); // set total for recalc pagination
		        $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
		},
	    $scope: { $data: {} }
		   
		});

	$scope.tableParams2 = new ngTableParams({
		page: 1,            // show first page
		count: 10,
		filter: $scope.filters2,
		sorting: {
		        	
		// initial sorting

		}
	}, {
		count:[], //here put empty counts
	    total: $scope.tablas.medicos.length, // length of data
		getData: function($defer, params) {
			
			var filteredData = params.filter() ? $filter('filter')($scope.tablas.medicos, params.filter().myfilter) : data;
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
		$scope.update.fecha_inicio=catalog.fecha_inicio;
		$scope.update.idHomeopata=catalog.idHomeopata;
		$scope.update.esMedico="n";
		$("#myModal").modal("show");
	}
	
	$scope.activarMedicos = function(catalog){
		console.log(catalog);
		$scope.update.nombre=catalog.nombre;
		$scope.update.cedula_ide=catalog.cedula_ide;
		$scope.update.telefono=catalog.telefono;
		$scope.update.direccion=catalog.direccion;
		$scope.update.fecha_inicio=catalog.fecha_inicio;
		$scope.update.idHomeopata=catalog.idHomeopata;
		$scope.update.especialidad=catalog.especialidad;
		$scope.update.esMedico="s";
		$("#updateMedico").modal("show");
	}
	$scope.$watch("tablas.homeopatas", function(){
	      $scope.tableParams.reload(); 
	      console.log($scope.tablas.homeopatas);
	  })
	
	  $scope.$watch("tablas.medicos", function(){
	      $scope.tableParams2.reload(); 
	      console.log($scope.tablas.medicos);
	  })
	  
	  $scope.actualizarDatos = function(){
		console.log($scope.update)
		 $http({
			 method: "POST",
			 data: $scope.update,
			 url:"http://localhost:8080/Practica_WebApp/services/clinica/updatemedicos"
		 }).success(function(data){
			 console.log(data);
			 console.log(data.mensaje);	
		 });
		 $("#myModal").modal("hide");
	  }
	$scope.actualizarDatosMedicos = function(){
		console.log($scope.update)
		 $http({
			 method: "POST",
			 data: $scope.update,
			 url:"http://localhost:8080/Practica_WebApp/services/clinica/updatemedicos"
		 }).success(function(data){
			 console.log(data);
			 console.log(data.mensaje);	
		 });
		 $("#updateMedico").modal("hide");
	  }
	
	$scope.mostrarInsercion = function(){
		console.log("initi.")
		$("#insertarMedicos").modal("show");
		
		
		
	}
	$scope.insertarDatos = function(){
		  console.log($scope.insertar)
		  $http({
				method: "POST",
				data: $scope.insertar,
				url:"http://localhost:8080/Practica_WebApp/services/clinica/insertarmedico"
			}).success(function(data){
				console.log(data);
				console.log(data.mensaje);	
			   });
		  $("#insertarMedicos").modal("hide");
	  }
}]);








