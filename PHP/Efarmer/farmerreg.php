<?php
	
	include "fmconfig.php";
	
	$fname=$_GET['fname'];
	$femail=$_GET['femail'];
	$fpassword=$_GET['fpassword'];
	$fcpassword=$_GET['fcpassword'];
	
	$sql="insert into fregistration(fname,femail,fpassword,fcpassword)values('$fname','$femail','$fpassword','$fcpassword')";
	
	
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