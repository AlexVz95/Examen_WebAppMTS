angular.module('webappApp')
.controller ('CitasCtrl',['$scope','$http','ngTableParams','$filter', function ($scope,$http,ngTableParams,$filter){
	
	$scope.listas = {};
	$scope.formulario ={};
	$scope.tablas ={};
	$scope.tablas.citas = [];
	$scope.insertar={};
	$scope.update={};
	$http({
		method: "POST",
		url:"http://localhost:8080/Practica_WebApp/services/clinica/citas"
	}).success(function(data){
		 $scope.tablas.citas = data;
		  
		console.log("Citas..");
		console.log($scope.tablas.citas);
	
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
	    total: $scope.tablas.citas.length, // length of data
		getData: function($defer, params) {
			
			var filteredData = params.filter() ? $filter('filter')($scope.tablas.citas, params.filter().myfilter) : data;
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
		$scope.update.idConsulta=catalog.idConsulta;
		$scope.update.fecha=catalog.fecha;
		$scope.update.costo=catalog.costo;
		$scope.update.hora_consulta=catalog.hora_consulta;
		$scope.update.idhomeopata=catalog.idHomeopata;
		$scope.update.idMedico=catalog.idMedico;
		$scope.update.idPaciente=catalog.idPaciente;
		
		$("#myModal").modal("show");
	}
	
	$scope.$watch("tablas.citas", function(){
	      $scope.tableParams.reload(); 
	      console.log($scope.tablas.citas);
	  })
	  
	  $scope.actualizarDatos = function(){
		console.log($scope.update)
		 $http({
			 method: "POST",
			 data: $scope.update,
			 url:"http://localhost:8080/Practica_WebApp/services/clinica/updatecita"
		 }).success(function(data){
			 console.log(data);
			 console.log(data.mensaje);	
		 });
		 $("#myModal").modal("hide");
	  }
	
	$scope.mostrarInsercion = function(){
		console.log("initi.")
		$("#insertarCita").modal("show");
		
	}
	$scope.insertarDatos = function(){
		  console.log($scope.insertar)
		  $http({
				method: "POST",
				data: $scope.insertar,
				url:"http://localhost:8080/Practica_WebApp/services/clinica/insertcita"
			}).success(function(data){
				console.log(data);
				console.log(data.mensaje);	
			   });
		  $("#insertarCita").modal("hide");
	  }
}]);








