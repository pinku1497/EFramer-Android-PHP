<?php
	
	include "fmconfig.php";
	
	$fertname=$_GET['fertname'];
	$image=$_GET['image'];
	$rate=$_GET['rate'];
	$description=$_GET['description'];
	
	$sql="insert into sproduct(fertname,image,rate,description)values('$fertname','$image','$rate','$description')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Product Added Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>" unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>