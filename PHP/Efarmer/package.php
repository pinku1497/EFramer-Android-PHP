<?php
	
	include "fmconfig.php";
	
	$packagename=$_GET['packagename'];
	$duration=$_GET['duration'];
	$rate=$_GET['rate'];
	$description=$_GET['description'];
	
	$sql="insert into package(packagename,duration,rate,description)values('$packagename','$duration','$rate','$description')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Done.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Fail..."));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>