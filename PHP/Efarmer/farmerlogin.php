<?php
	
	include "fmconfig.php";
	
	$email=$_GET['email'];
	$password=$_GET['password'];
	
	
	$sql="insert into login(email,password)values('$email','$password')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Login Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Login unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>