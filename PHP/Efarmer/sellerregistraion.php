<?php
	
	include "fmconfig.php";
	
	$name=$_GET['name'];
	$email=$_GET['email'];
	$password=$_GET['password'];
	$cpassword=$_GET['cpassword'];
	
	$sql="insert into sellerreg(name,email,password,cpassword)values('$name','$email','$password','$cpassword')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Registration Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Registration unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>