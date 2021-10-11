<?php

	include "config.php";
	
	$name=$_GET['fname'];
	$lastn=$_GET['lname'];
	$pwd=$_GET['password'];
	$sql="insert into login(fname,lname,password) values('$name','$lastn','$pwd')";
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	
	if($res)
	{
		array_push($result,
				array('status'=>1,
					'msg'=>"Login Successfully.."));
	}
	
	else
	{
		array_push($result,
				array('status'=>0,
					'msg'=>"Login Unsuccessfully.."));
	}
	
	echo json_encode(array("result"=>$result));
	
	?>